/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author rezaramadhan
 */
public class OnlineUser {
    public String username;
    public String tokenFCM;

    public OnlineUser() {
        this.username = "";
        this.tokenFCM = "";
    }
    
    public OnlineUser(String username, String tokenFCM) {
        this.username = username;
        this.tokenFCM = tokenFCM;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getToken()
    {
        return this.tokenFCM;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
        public void setToken(String token)
    {
        this.tokenFCM = token;
    }
    
    @Override
    public String toString() {
        return "Username: " + username+ "\nToken: " +tokenFCM + "\n";
    }
}
