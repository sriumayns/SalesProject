/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author rezaramadhan
 */
public class TokenController {

    public static String isValid(java.lang.String token) {
        akunmodel.TokenValidationWS_Service service = new akunmodel.TokenValidationWS_Service();
        akunmodel.TokenValidationWS port = service.getTokenValidationWSPort();
        return port.isValid(token);
    }
    
}
