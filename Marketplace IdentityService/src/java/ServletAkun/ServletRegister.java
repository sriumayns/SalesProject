/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAkun;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "ServletRegister", urlPatterns = {"/ServletRegister"})
public class ServletRegister extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegister</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRegister at " + request.getContextPath() + "</h1>");
            
            
            out.println("Name : " + request.getParameter("fullname"));
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
            String DB_URL = "jdbc:mysql://localhost:3306/akun?zeroDateTimeBehavior=convertToNull";

            //  Database credentials
            String USER = "salesproject";
            String PASS = "password";

            Connection conn = null;
            Statement stmt = null;
            try{
                //Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //Get request parameter
                stmt = conn.createStatement();
                String fullname = request.getParameter("fullname"); 
                String username = request.getParameter("username"); 
                String email = request.getParameter("email"); 
                String password = request.getParameter("password"); 
                String address = request.getParameter("address"); 
                String postal_code = request.getParameter("postalcode"); 
                int phone_number = Integer.parseInt(request.getParameter("phonenumber")); 
                String token = generateToken(16);
              
                String query1 = "SELECT id FROM User WHERE username='"+username+"' OR email='"+email+"'" ;
                ResultSet result = stmt.executeQuery(query1);
                result.last();
                int rows = result.getRow();
                result.beforeFirst();
                
                
                if (rows==0) {
                    //Prepare query
                    String sql = "INSERT INTO User (fullname, username, email, password, address, postal_code, phone_number,token) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    //Execute query
                    PreparedStatement prStmt = conn.prepareStatement(sql);
                    prStmt.setString(1, fullname);
                    prStmt.setString(2, username);
                    prStmt.setString(3, email);
                    prStmt.setString(4, password);
                    prStmt.setString(5, address);
                    prStmt.setString(6, postal_code);
                    prStmt.setInt(7, phone_number);
                    prStmt.setString(8, token);
                    prStmt.executeUpdate();

                    prStmt.close();
                    stmt.close();
                    conn.close();
                    out.println("<h2>Data Saved</h2>");
                    out.println("<h2>Token : "+ token +"</h2>");
                    response.sendRedirect("http://localhost:8080/ServletCookie?token="+token+"&username="+username);
                    
                }
            } catch(SQLException se){
                //Handle errors for JDBC
                out.print("<p>");
                out.print(se);
                out.println("</p>");

            } catch(Exception e){
                //Handle errors for Class.forName
                out.print("<p>");
                out.print(e);
                out.println("</p>");

            } finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                       conn.close();
                }catch(SQLException se){
                    out.print("<p>");
                    out.print(se);
                    out.println("</p>");
                }//end finally try

            }//end try
            
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }
    
    public static String generateToken(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
