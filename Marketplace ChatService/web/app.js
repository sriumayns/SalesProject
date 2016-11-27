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
messaging.requestPermission()
.then(function() 
{
	console.log('Have permission');
  return messaging.getToken();
})
.then(function(token)
{
  console.log(token);
})
.catch(function(err)
{
	console.log('Error occured');
})

messaging.onMessage(function(payload)
{
	//console.log('test');
	console.log(payload.notification.body);
	//console.log('onMessage: ', payload);
})

messaging.onTokenRefresh(function() {
    messaging.getToken()
    .then(function(refreshedToken) {
      console.log('Token refreshed.');
      //setTokenSentToServer(false);
      // Send Instance ID token to app server.
      //sendTokenToServer(refreshedToken); -send to server
      // [START_EXCLUDE]
      // Display new Instance ID token and clear UI of all previous messages.
      //resetUI();
      // [END_EXCLUDE]
    })
    .catch(function(err) {
      console.log('Unable to retrieve refreshed token ', err);
      showToken('Unable to retrieve refreshed token ', err);
    });
  });