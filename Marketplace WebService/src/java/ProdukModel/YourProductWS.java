 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdukModel;

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
 * @author Mayu
 */
@WebService(serviceName = "YourProductWS")
public class YourProductWS {
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
    @WebMethod(operationName = "getProduk")
    public String getProduk(@WebParam(name = "namaOwner") String namaOwner) {
        return null;
    }

    private String isLiked(int idProduct, String owner) throws Exception {
        String liked = "";
        Connection conn = null;
        Statement stmt = null;
        //Register JDBC driver
        StringBuilder tmpResult = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //Get request parameter
        stmt = conn.createStatement();

        String query = "SELECT * FROM Liked WHERE id_product = " + idProduct + " AND username = '" + owner + "'";
        
        ResultSet rs = stmt.executeQuery(query);
        rs.last();
        int n = rs.getRow();
        if (n == 0) {
            liked = "LIKE";            
        } else {
            liked = "UNLIKE";
        }
        return liked;
    }
    
    private int getnLikes(int idProduct) throws Exception {
        int result = 0;
        
        Connection conn = null;
        Statement stmt = null;
        //Register JDBC driver
        StringBuilder tmpResult = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //Get request parameter
        stmt = conn.createStatement();

        String query = "SELECT * FROM Liked WHERE id_product = " + idProduct;
        
        ResultSet rs = stmt.executeQuery(query);
        rs.last();
        result = rs.getRow();
        rs.close();
        return result;
    }
    
    private int getnPurchases(int idProduct) throws Exception {
        int result = 0;

        Connection conn = null;
        Statement stmt = null;
        //Register JDBC driver
        StringBuilder tmpResult = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //Get request parameter
        stmt = conn.createStatement();

        String query = "SELECT * FROM Purchase WHERE id_product = " + idProduct;
        
        ResultSet rs = stmt.executeQuery(query);
        rs.last();
        result = rs.getRow();
        rs.close();
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getYourProduct")
    public String getYourProduct(@WebParam(name = "username") final String username) {
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

            String query = "SELECT * FROM Product WHERE owner='" + username + "'";

            ResultSet rs = stmt.executeQuery(query);
            String prefix = "";
            String prefixcol = "!!!";
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String desk = rs.getString("desk");
                int price = rs.getInt("price");
                String photo = rs.getString("photo");
                Timestamp t = rs.getTimestamp("addtime");
//                String addtime = rs.getTime("addtime").toString();
                Date d = new Date(t.getTime());
                SimpleDateFormat ft = new SimpleDateFormat ("E ',' yyyy.MM.dd 'at' hh:mm");
//                String addDate = ft.format(d);
                String addtime = String.format("%tA, %<te %<tB %<tY at %<tR", d);;
                String owner = rs.getString("owner");

                //Add to result
                tmpResult.append(prefix);
                tmpResult.append(Integer.toString(id) + prefixcol);
                tmpResult.append(name + prefixcol);
                tmpResult.append(desk + prefixcol);
                tmpResult.append(Integer.toString(price) + prefixcol);
                tmpResult.append(photo + prefixcol);
                tmpResult.append(addtime + prefixcol);
                tmpResult.append(owner + prefixcol);
                tmpResult.append(getnLikes(id) + prefixcol);
                tmpResult.append(getnPurchases(id) + prefixcol);
                tmpResult.append(isLiked(id,owner) + prefixcol);
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
