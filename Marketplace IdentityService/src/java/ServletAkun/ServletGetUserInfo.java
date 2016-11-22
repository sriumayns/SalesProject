/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAkun;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "ServletGetUserInfo", urlPatterns = {"/userinfo"})
public class ServletGetUserInfo extends HttpServlet {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost:3306/akun?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    String USER = "salesproject";
    String PASS = "password";

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
//            out.print("abc");
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            //TODO write your implementation code here:
//            out.print("<br> username =" +username);
            Connection conn = null;
            Statement stmt = null;
            try{
                //Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //Open a connection
                //System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //Get request parameter
                stmt = conn.createStatement();

                String query = "SELECT * FROM User WHERE username = '"+username+"'";
            
                ResultSet rs = stmt.executeQuery(query);
                String prefix = "";
                String prefixcol = "!!!";
               
                if (rs.first()) {
                    //Retrieve by column name
                    String fullname  = rs.getString("fullname");
                    String address = rs.getString("address");
                    String postCode = rs.getString("postal_code");
                    String phoneNumber = rs.getString("phone_number");
                    
                    //Add to result
                    out.print(prefix);
                    out.print(fullname + prefixcol);
                    out.print(address + prefixcol);
                    out.print(postCode + prefixcol);
                    out.print(phoneNumber);
                    prefix = "===";
                } else {
                    out.print("EMPTY");
                }
               
                rs.close();
            } catch(SQLException se){
                //Handle errors for JDBC
                out.print(se);
            } catch(Exception e){
                //Handle errors for Class.forName
               out.print(e);
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
                    out.print(se);
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
