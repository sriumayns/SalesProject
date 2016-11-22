/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdukModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mayu
 */
@WebService(serviceName = "DeleteYourProductWS")
public class DeleteYourProductWS {
    
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost:3306/produk?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    String USER = "salesproject";
    String PASS = "password";
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteProduct")
    public String deleteProduct(@WebParam(name = "idProduct") int idProduct) {
        //TODO write your implementation code here:
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
                
                String sql = "DELETE FROM product WHERE id = ?";
                //Execute query
                PreparedStatement prStmt = conn.prepareStatement(sql);
                prStmt.setInt(1, idProduct);
                prStmt.executeUpdate();
              
                stmt.close();
                conn.close();
                
            } catch(SQLException se){
                //Handle errors for JDBC
                System.out.print("<p>");
                System.out.print(se);
                System.out.println("</p>");

            } catch(Exception e){
                //Handle errors for Class.forName
                System.out.print("<p>");
                System.out.print(e);
                System.out.println("</p>");

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
                    System.out.print("<p>");
                    System.out.print(se);
                    System.out.println("</p>");
                }//end finally try

            }//end try
        return "";
    }
}
