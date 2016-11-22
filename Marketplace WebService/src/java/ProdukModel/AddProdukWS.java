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
 * @author rezaramadhan
 */
@WebService(serviceName = "AddProdukWS")
public class AddProdukWS {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost:3306/produk?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    String USER = "salesproject";
    String PASS = "password";

    /**
     * Web service operation
     */
    @WebMethod(operationName = "tambahProduk")
    public String tambahProduk(@WebParam(name = "name") String name, @WebParam(name = "desc") String desc, @WebParam(name = "price") String price, @WebParam(name = "owner") String owner, @WebParam(name = "fileExt") String fileExt) {
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
            
            
            String filename = owner + "_" + name + "." + fileExt;
            
            String sql = "INSERT INTO Product (name, desk, price, photo, owner) VALUES (?, ?, ?, ?, ?)";
                    //Execute query
            PreparedStatement prStmt = conn.prepareStatement(sql);
            prStmt.setString(1, name);
            prStmt.setString(2, desc);
            prStmt.setString(3, price);
            prStmt.setString(4, filename);
            prStmt.setString(5, owner);
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
}
