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
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "ServletToken", urlPatterns = {"/ServletToken"})
public class ServletToken extends HttpServlet {
    private int nMinute = 1000*60*60;
    private int expireTime = nMinute * 10;
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
                String oldtoken = request.getParameter("token");  
                String token = generateToken(16);
              
                String query1 = "SELECT * FROM User WHERE token='"+oldtoken+"'";
                ResultSet result = stmt.executeQuery(query1);
                result.last();
                int rows = result.getRow();
                result.beforeFirst();
                
                
                if (rows==1) {
                    result.first();
                    String username = result.getString("username");
                    long expiredAt = result.getTimestamp("expire").getTime() + expireTime;
                    Date cTime = new Date();
                    long currentTime = cTime.getTime();
                    
                    boolean valid = expiredAt > currentTime;
                    
                    if (valid) {
//                        String sql = "UPDATE user SET token=? WHERE username='"+username+"'";
//                        //Execute query
//                         PreparedStatement prStmt = conn.prepareStatement(sql);
//                         prStmt.setString(1, token);
//                         prStmt.executeUpdate();
//
//                         if(result.next()) {     
//                             username = result.getString("username");
//                             out.print(username);
//                         }
                         out.println("VALID");
//                         out.println("<h2>Token : "+ token +"</h2>");
                    } else {
                        out.println("expired");
                        //response.sendRedirect("http://localhost:8080/Marketplace_WebApp/ServletCookie?token="+token+"&username="+username);
                    }
                    stmt.close();
                    conn.close();
                } else {
                    out.println("invalid");
//                    response.sendRedirect("http://localhost:8080/Marketplace_WebApp/login.jsp");
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
public static String generateToken(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }
}
