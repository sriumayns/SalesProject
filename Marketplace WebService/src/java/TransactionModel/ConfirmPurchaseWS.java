/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionModel;

import java.sql.Connection;
import java.sql.Date;
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
 * @author LENOVO
 */
@WebService(serviceName = "ConfirmPurchaseWS")
public class ConfirmPurchaseWS {
    //Parameter untuk membukan koneksi ke database
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost:3306/produk?zeroDateTimeBehavior=convertToNull";

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
    // Memasukkan transaksi purchase ke database
    @WebMethod(operationName = "addPurchase")
    public String addPurchase(@WebParam(name = "username") String username, @WebParam(name = "id_product") String id_product, @WebParam(name = "penerima_barang") String penerima_barang, @WebParam(name = "alamat_penerima") String alamat_penerima, @WebParam(name = "postal_code") String postal_code, @WebParam(name = "phone_num") String phone_num, @WebParam(name = "credit_num") String credit_num, @WebParam(name = "verification_num") String verification_num, @WebParam(name = "jml_barang") String jml_barang, @WebParam(name = "owner") String owner, @WebParam(name = "productname") String productname, @WebParam(name = "price") String price, @WebParam(name = "photo") String photo) {
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
            
            // Query untuk input purchase
            String sql = "INSERT INTO Purchase (username, id_product, penerima_barang, alamat_penerima, postal_code, phone_num, credit_card_number, card_verification_number, jml_barang, owner, name, price, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Input parameter query
            PreparedStatement prStmt = conn.prepareStatement(sql);
            prStmt.setString(1, username);
            prStmt.setString(2, id_product);
            prStmt.setString(3, penerima_barang);
            prStmt.setString(4, alamat_penerima);
            prStmt.setString(5, postal_code);
            prStmt.setString(6, phone_num);
            prStmt.setString(7, credit_num);
            prStmt.setString(8, verification_num);
            prStmt.setString(9, jml_barang);
            prStmt.setString(10, owner);
            prStmt.setString(11, productname);
            prStmt.setString(12, price);
            prStmt.setString(13, photo);
            prStmt.executeUpdate();            
            prStmt.close();
            
            // Menandakan query berhasil
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
    // Mendapatkan informasi produk untuk confirm purchase
    @WebMethod(operationName = "getPurchaseProduct")
    public String getPurchaseProduct(@WebParam(name = "id") String id) {
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
            
            String query = "SELECT * FROM Product WHERE id = '" + id + "' LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            
            // Menyatukan info produk pada 1 string agar bisa dikirim ke Client
            String prefix = "!";
            if (rs.next())
            {
                result += rs.getString("owner");
                result += prefix;
                result += rs.getString("name");
                result += prefix;
                result += rs.getInt("price");
                result += prefix;
                result += rs.getString("photo");
                result += prefix;
                rs.close();
            }
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
