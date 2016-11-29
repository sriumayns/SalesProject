<%-- 
    Document   : fcm-app
    Created on : 28-Nov-2016, 21:03:26
    Author     : rezaramadhan
--%>
<% 
    Cookie[] cookies = request.getCookies();
    String username = Controller.RetrieveCookieController.retrieveName(cookies); %>
<script>


messaging.requestPermission()
.then(function() 
{
	console.log('Have permission');
  return messaging.getToken();
})
.then(function(token)
{
        console.log(token);
        var data = "type=token"
        data += "&token=" + token;
        data += "&username=" + "<%= username %>";
        sendToServlet(data);
})
.catch(function(err)
{
	alert('Error occured', err);
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
      console.log(refreshedToken);
      var data = "type=token"
        data += "&token=" + refreshedToken;
        data += "&username=" + "<%= username %>";
        sendToServlet(data);
    })
    .catch(function(err) {
      console.log('Unable to retrieve refreshed token ', err);
      showToken('Unable to retrieve refreshed token ', err);
    });
  });
  
</script>