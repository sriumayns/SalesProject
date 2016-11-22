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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rezaramadhan
 */
@WebService(serviceName = "LikeWS")
public class LikeWS {
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
    @WebMethod(operationName = "addLike")
    public String addLike(@WebParam(name = "id_product") String id_product, @WebParam(name = "owner") String owner) {
     String result = "";
        
         Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            StringBuilder tmpResult = new StringBuilder();
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Get request parameter
            
            
            String sql = "INSERT INTO Liked (username, id_product) VALUES ('"+owner+"', '"+id_product+"')";
                    //Execute query
            PreparedStatement prStmt = conn.prepareStatement(sql);
            
            prStmt.executeUpdate();
            
            prStmt.close();

            
            result = "OK";  
        } catch(SQLException se){
            //Handle errors for JDBC
            result = se.toString();
        } catch(Exception e){
            //Handle errors for Class.forName
           result = e.toString();
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
                result = se.toString();
            }//end finally try

        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "delLike")
    public String delLike(@WebParam(name = "id_product") String id_product, @WebParam(name = "owner") String owner) {
        //TODO write your implementation code here:
        String result = "";
        
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            StringBuilder tmpResult = new StringBuilder();
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Get request parameter
            
            
            String sql = "DELETE FROM Liked WHERE username = '"+owner+"' AND id_product = '"+id_product+"'";
                    //Execute query
            PreparedStatement prStmt = conn.prepareStatement(sql);
            prStmt.executeUpdate();
            
            prStmt.close();

            
            result = "OK";  
        } catch(SQLException se){
            //Handle errors for JDBC
            result = se.toString();
        } catch(Exception e){
            //Handle errors for Class.forName
           result = e.toString();
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
                result = se.toString();
            }//end finally try

        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isLiked")
    public String isLiked(@WebParam(name = "idProduct") String idProduct, @WebParam(name = "username") String username) {
        String liked = "";
        try {
            Connection conn = null;
            Statement stmt = null;
            //Register JDBC driver
            StringBuilder tmpResult = new StringBuilder();
            Class.forName("com.mysql.jdbc.Driver");
            
            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Get request parameter
            stmt = conn.createStatement();
            
            String query = "SELECT * FROM Liked WHERE id_product = " + idProduct + " AND username = '" + username + "'";
            
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int n = rs.getRow();
            if (n == 0) {
                liked = "LIKE";
            } else {
                liked = "UNLIKE";
            }
        } catch (ClassNotFoundException ex) {
            liked = ex.toString();
        } catch (SQLException ex) {
            liked = ex.toString();
        } catch (Exception ex) {
            liked = ex.toString();
        }
        return liked;
    }
}
