var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "https://fcm.googleapis.com/fcm/send", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.setRequestHeader("Authorization", "key=AIzaSyDHolAWSGjSASlD4IQ5p4CnS9EPrZVQaUE");
	xhttp.send(JSON.stringify({ "notification": {
    "title": "Portugal vs. Denmark",
    "body": "5 to 1"
  },
  "to" : "dwrC_XOVBVs:APA91bFSEbUj7UWNma96zZTw1rawt-0PYhynYO5807YNITkd9AjTik_E5pWDtEAxkaTULEkEVqOJTsAi8KIXU-1FBRPvcc-zZoSRMeaFfhTpN4n9sP_Cr9KIQe4Ni6qILBzImgyxoMZm"
}));
	