/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdukModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rezaramadhan
 */
@WebService(serviceName = "EditProductWS")
public class EditProductWS {
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
    @WebMethod(operationName = "updateProduk")
    public String updateProduk(@WebParam(name = "id") String id, @WebParam(name = "name") String name, @WebParam(name = "desc") String desc, @WebParam(name = "price") String price) {
        //TODO write your implementation code here:
        String result = "";
        
         Connection conn = null;
        try{
            //Register JDBC driver
            StringBuilder tmpResult = new StringBuilder();
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Get request parameter
            
            
            
            String sql = "UPDATE Product SET name='"+name+"',desk='"+desc+"',price='"+price+"' WHERE id = '"+id+"'";
            //result = sql;
                //Execute query
            PreparedStatement prStmt = conn.prepareStatement(sql);
            //prStmt.setString(2, name);
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
    @WebMethod(operationName = "getProductByID")
    public String getProductByID(@WebParam(name = "id") String id) {
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
            stmt = conn.createStatement();

            String query = "SELECT * FROM Product WHERE id = '" +id+"'";

            ResultSet rs = stmt.executeQuery(query);
            String prefix = "";
            String prefixcol = "!!!";
            while(rs.next()){
                //Retrieve by column name
                int idP  = rs.getInt("id");
                String name = rs.getString("name");
                String desk = rs.getString("desk");
                int price = rs.getInt("price");
                String owner = rs.getString("owner");

                //Add to result
                tmpResult.append(prefix);
                tmpResult.append(Integer.toString(idP) + prefixcol);
                tmpResult.append(name + prefixcol);
                tmpResult.append(desk + prefixcol);
                tmpResult.append(Integer.toString(price) + prefixcol);
                tmpResult.append(owner + prefixcol);
//                tmpResult.append(addDay + prefixcol);
//                tmpResult.append(addDate);
                
                prefix = "===";
            }
            rs.close();
            result = tmpResult.toString();  
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

        }//end try

        
        return result;
    }
}
