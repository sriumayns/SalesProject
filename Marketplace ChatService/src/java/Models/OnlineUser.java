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
    public String chattingWith;

    public OnlineUser(String username, String tokenFCM, String chattingWith) {
        this.username = username;
        this.tokenFCM = tokenFCM;
        this.chattingWith = chattingWith;
    }
    
    @Override
    public String toString() {
        return "Username: " + username+ "\nToken: " +tokenFCM + "\n ChattingWith: " + chattingWith;
    }
}
