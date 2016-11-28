<%-- 
    Document   : dashboard.jsp
    Created on : Nov 7, 2016, 7:45:55 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        
	<p>Hi, <%= Controller.RetrieveCookieController.retrieveName(request.getCookies())%>!</p>
        
	<p><a href="http://localhost:8080/ServletLogout" onclick="return(logout());">logout</a></p>
	<script type="text/javascript">
        <jsp:include page="/javascript/logout-confirmation.js"/>
        </script>
</html>
