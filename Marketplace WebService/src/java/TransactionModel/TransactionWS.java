/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
 * @author LENOVO
 */
@WebService(serviceName = "TransactionWS")
public class TransactionWS {
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
    @WebMethod(operationName = "getPurchase")
    public String getPurchase(@WebParam(name = "username") String username) {
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
            stmt = conn.createStatement();

            String query = "SELECT * FROM Purchase WHERE username = '" + username + "'";

            ResultSet rs = stmt.executeQuery(query);
            String prefix = "";
            String prefixcol = "!!!";
            while(rs.next()){
                //Retrieve by column name
                String id_buyer  = rs.getString("username");
                int id_product = rs.getInt("id_product");
                String receiver = rs.getString("penerima_barang");
                String address = rs.getString("alamat_penerima");
                String postal_code = rs.getString("postal_code");
                int phone_num = rs.getInt("phone_num");
                String credit_num = rs.getString("credit_card_number");
                int verification_num = rs.getInt("card_verification_number");
                int jml_barang = rs.getInt("jml_barang");
                String owner = rs.getString("owner");
                String productname = rs.getString("name");
                int price = rs.getInt("price");
                String photo = rs.getString("photo");
                Timestamp t = rs.getTimestamp("purchase_time");
//                String addtime = rs.getTime("addtime").toString();
                Date d = new Date(t.getTime());
                String purchase_date = String.format("%tA, %<te %<tB %<tY", d);
                String purchase_time = String.format("%tR", d);

                //Add to result
                tmpResult.append(prefix);
                tmpResult.append(id_buyer + prefixcol);
                tmpResult.append(Integer.toString(id_product) + prefixcol);
                tmpResult.append(receiver + prefixcol);
                tmpResult.append(address + prefixcol);
                tmpResult.append(postal_code + prefixcol);
                tmpResult.append(Integer.toString(phone_num) + prefixcol);
                tmpResult.append(credit_num + prefixcol);
                tmpResult.append(Integer.toString(verification_num) + prefixcol);
                tmpResult.append(Integer.toString(jml_barang) + prefixcol);
                tmpResult.append(owner + prefixcol);
                tmpResult.append(productname + prefixcol);
                tmpResult.append(Integer.toString(price) + prefixcol);
                tmpResult.append(photo + prefixcol);
                tmpResult.append(purchase_date + prefixcol);
                tmpResult.append(purchase_time + prefixcol);
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSales")
    public String getSales(@WebParam(name = "namaOwner") String namaOwner) {
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
            stmt = conn.createStatement();

            String query = "SELECT * FROM Purchase WHERE owner = '" + namaOwner + "'";

            ResultSet rs = stmt.executeQuery(query);
            String prefix = "";
            String prefixcol = "!!!";
            while(rs.next()){
                //Retrieve by column name
                String id_buyer  = rs.getString("username");
                int id_product = rs.getInt("id_product");
                String receiver = rs.getString("penerima_barang");
                String address = rs.getString("alamat_penerima");
                String postal_code = rs.getString("postal_code");
                int phone_num = rs.getInt("phone_num");
                String credit_num = rs.getString("credit_card_number");
                int verification_num = rs.getInt("card_verification_number");
                int jml_barang = rs.getInt("jml_barang");
                String owner = rs.getString("owner");
                String productname = rs.getString("name");
                int price = rs.getInt("price");
                String photo = rs.getString("photo");
                Timestamp t = rs.getTimestamp("purchase_time");
//                String addtime = rs.getTime("addtime").toString();
                Date d = new Date(t.getTime());
                String purchase_date = String.format("%tA, %<te %<tB %<tY", d);
                String purchase_time = String.format("%tR", d);

                //Add to result
                tmpResult.append(prefix);
                tmpResult.append(id_buyer + prefixcol);
                tmpResult.append(Integer.toString(id_product) + prefixcol);
                tmpResult.append(receiver + prefixcol);
                tmpResult.append(address + prefixcol);
                tmpResult.append(postal_code + prefixcol);
                tmpResult.append(Integer.toString(phone_num) + prefixcol);
                tmpResult.append(credit_num + prefixcol);
                tmpResult.append(Integer.toString(verification_num) + prefixcol);
                tmpResult.append(Integer.toString(jml_barang) + prefixcol);
                tmpResult.append(owner + prefixcol);
                tmpResult.append(productname + prefixcol);
                tmpResult.append(Integer.toString(price) + prefixcol);
                tmpResult.append(photo + prefixcol);
                tmpResult.append(purchase_date + prefixcol);
                tmpResult.append(purchase_time + prefixcol);
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
