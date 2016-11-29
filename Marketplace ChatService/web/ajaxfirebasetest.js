var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          console.log("chatServlet:" + this.responseText);
        }
    };
	xhttp.open("POST", "https://fcm.googleapis.com/fcm/send", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.setRequestHeader("Authorization", "key=AIzaSyDHolAWSGjSASlD4IQ5p4CnS9EPrZVQaUE");
	xhttp.send(JSON.stringify({ "notification": {
    "title": "Portugal vs. Denmark",
    "body": "5 to 1"
  },
  "to" : "d5w9Gz1JuJ0:APA91bGgcpI6bUvCBo8eZFs_SYdPg9XYR-Xdk0GT1qZsgzrpV8PTr-9nuClktkXH3AbNhqbCjSBwdqM8SaBNXrvkdJk5tO5trRtPAFXAvDNDojk7rAhUjJW7A7LEQ3P4C7XNCu4hfuly"
}));

	console.log("done?");
	