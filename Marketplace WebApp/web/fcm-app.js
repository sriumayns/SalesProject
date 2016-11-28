/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sendToServlet(data) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          console.log("chatServlet:" + this.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Marketplace_ChatService/chat", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(data);
}

// Initialize Firebase
var config = {
  apiKey: "AIzaSyAHtE_UY7YdGOcJyNOniF4Rt9hhsXRe6_c",
  authDomain: "chat-service-tubes-3-wbd.firebaseapp.com",
  databaseURL: "https://chat-service-tubes-3-wbd.firebaseio.com",
  storageBucket: "chat-service-tubes-3-wbd.appspot.com",
  messagingSenderId: "941665228418"
};
firebase.initializeApp(config);
    
const messaging = firebase.messaging();

