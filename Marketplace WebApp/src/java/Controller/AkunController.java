/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author rezaramadhan
 */
public class AkunController {
    public static String[] getUserInfo(String username) {
        String r = "";
        HttpURLConnection connection = null;

        try {
          //Create connection
          String targetURL = "http://localhost:8082/Marketplace_IdentityService/userinfo?username=" + username;
          URL url = new URL(targetURL);
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("Content-Type", 
              "application/x-www-form-urlencoded");

          connection.setRequestProperty("Content-Language", "en-US");  

          connection.setUseCaches(false);
          connection.setDoOutput(true);

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
          return response.toString().split("!!!");
        } catch (Exception e) {
          r = e.toString();
          //return null;
        } finally {
          if (connection != null) {
            connection.disconnect();
          }
        }

        return null;
    }
    
    public static boolean isUserOnline(String username) {
        HttpURLConnection connection = null;

        try {
          //Create connection
          String targetURL = "http://localhost:8082/Marketplace_IdentityService/userinfo?username=" + username;
          URL url = new URL(targetURL);
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
//          connection.setRequestProperty("Content-Type", 
//              "application/x-www-form-urlencoded");
//
//          connection.setRequestProperty("Content-Language", "en-US");  
//
//          connection.setUseCaches(false);
//          connection.setDoOutput(true);

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
          return response.toString().contains("IN");
        } catch (Exception e) {
            //return null;
        } finally {
          if (connection != null) {
            connection.disconnect();
          }
        }
        
        return false;
    }
}
