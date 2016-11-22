/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.Cookie;

/**
 *
 * @author Mayu
 */
public class RetrieveCookieController {
        
        
        public static String retrieveName(Cookie[] cookies) {
            Cookie cookie = null;
            // Get an array of Cookies associated with this domain
            String name = null;
            if( cookies != null ){
                for (int i = 0; i < cookies.length; i++){
                   cookie = cookies[i];
                   if (cookie.getName().equals("username")){
                       name = cookie.getValue();
                   }
//                   out.print("Name : " + cookie.getName( ) + ",  ");
//                   out.print("Value: " + cookie.getValue( )+" <br/>");
                }
            }else{
//                out.println("<h2>No cookies founds</h2>");
            }
            
            return name;
        }
        
        public static String retrieveToken(Cookie[] cookies) {
            Cookie cookie = null;
            // Get an array of Cookies associated with this domain
            String token = null;
            if( cookies != null ){
                for (int i = 0; i < cookies.length; i++){
                   cookie = cookies[i];
                   if (cookie.getName().equals("token")){
                       token = cookie.getValue();
                   }
//                   out.print("Name : " + cookie.getName( ) + ",  ");
//                   out.print("Value: " + cookie.getValue( )+" <br/>");
                }
            }else{
//                out.println("<h2>No cookies founds</h2>");
            }
            
            return token;
        }
        
        public static Cookie retrieveCookie(Cookie[] cookies, String name) {
            Cookie cookie = null;
            // Get an array of Cookies associated with this domain
            if( cookies != null ){
                for (int i = 0; i < cookies.length; i++){
                   cookie = cookies[i];
                   if (cookie.getName().equals(name)){
//                       cookie.setValue(value);
                       break;
                   }
//                   out.print("Name : " + cookie.getName( ) + ",  ");
//                   out.print("Value: " + cookie.getValue( )+" <br/>");
                }
            }else{
//                out.println("<h2>No cookies founds</h2>");
            }
            return cookie;
        }
}
