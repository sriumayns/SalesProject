/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AkunModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rezaramadhan
 */
@WebService(serviceName = "TokenValidationWS")
public class TokenValidationWS {

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
    @WebMethod(operationName = "isValid")
    public String isValid(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        String r = "";
        HttpURLConnection connection = null;

        try {
          //Create connection
          String targetURL = "http://localhost:8082/Marketplace_IdentityService/ServletToken?token=" + token;
          URL url = new URL(targetURL);
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("Content-Type", 
              "application/x-www-form-urlencoded");

//          connection.setRequestProperty("Content-Length", 
//              Integer.toString(urlParameters.getBytes().length));
          connection.setRequestProperty("Content-Language", "en-US");  

          connection.setUseCaches(false);
          connection.setDoOutput(true);

          //Send request
//          DataOutputStream wr = new DataOutputStream (
//              connection.getOutputStream());
//          wr.writeBytes(urlParameters);
//          wr.close();

          //Get Response  
          InputStream is = connection.getInputStream();
          BufferedReader rd = new BufferedReader(new InputStreamReader(is));
          StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
          String line;
          while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
          }
          rd.close();
          return response.toString();
        } catch (Exception e) {
          r = e.toString();
          //return null;
        } finally {
          if (connection != null) {
            connection.disconnect();
          }
        }

        return r;
    }
}
