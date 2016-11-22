<%-- 
    Document   : yourproduct
    Created on : Nov 7, 2016, 6:56:16 PM
    Author     : Mayu
--%>
<%
    Cookie[] cookies = null;
    cookies = request.getCookies();
//    out.println(cookies.length);
        String oldToken = Controller.RetrieveCookieController.retrieveToken(cookies);
    String newToken = Controller.TokenController.isValid(oldToken);
    newToken = newToken.substring(0, newToken.length() - 1);
    if (newToken.contains("expired") || cookies.length==1 || newToken.contains("invalid")){
        String site = new String("http://localhost:8080/Marketplace_WebApp/login.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
    } else {
%>

<jsp:include page="views/yourproduct-view.jsp" />

<% } %>




