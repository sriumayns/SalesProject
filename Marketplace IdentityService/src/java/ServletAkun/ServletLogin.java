/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAkun;

import static ServletAkun.ServletRegister.generateToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
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
                String username = request.getParameter("username"); 
                String password = request.getParameter("password"); 
                String token = generateToken(16);
              
                String query1 = "SELECT username FROM User WHERE (username='"+username+"' OR email='"+username+"') AND password='"+password+"'" ;
                ResultSet result = stmt.executeQuery(query1);
                result.last();
                int rows = result.getRow();
                result.beforeFirst();
                
                
                if (rows==1) {
                     //GET IP ADDR
                    String ipAddress = request.getHeader("X-FORWARDED-FOR");  
                    if (ipAddress == null) {  
                        ipAddress = request.getRemoteAddr();  
                    }

                    //GET User-agent
                    String userAgent = request.getHeader("User-Agent");
                    userAgent = userAgent.replaceAll(";", "");
            
                    String sql = "UPDATE User SET token=? WHERE username='"+username+"' OR email='"+username+"'" ;
                   //Execute query
                    PreparedStatement prStmt = conn.prepareStatement(sql);
                    prStmt.setString(1, token + "__" + userAgent + "__" + ipAddress);
                    prStmt.executeUpdate();
                    
                    if(result.next()) {     
                        username = result.getString("username");
                        out.print(username);
                    }
                    
                    
                    stmt.close();
                    conn.close();
                    out.println("<h2>Data Saved</h2>");
                    out.println("<h2>Token : "+ token +"</h2>");
                    
                    response.sendRedirect("http://localhost:8080/ServletCookie?token="+token+"&username="+username);
                        
                } else {
                    response.sendRedirect("http://localhost:8080/login.jsp");
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
            
        }
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
