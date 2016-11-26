<%-- 
    Document   : editproduct
    Created on : Nov 7, 2016, 6:55:41 PM
    Author     : Mayu
--%>
<%
    Cookie[] cookies = null;
    cookies = request.getCookies();
//    out.println(cookies.length);
    String oldToken = Controller.RetrieveCookieController.retrieveToken(cookies);
    String userAgent = Controller.RetrieveCookieController.retrieveCookie(cookies, "user_agent").getValue();
    String ip = Controller.RetrieveCookieController.retrieveCookie(cookies, "ip").getValue();
    String args = oldToken + "__" + userAgent + "__" + ip;
    //out.println(args);
    String newToken = Controller.TokenController.isValid(args);
    
    newToken = newToken.substring(0, newToken.length() - 1);
    if (newToken.contains("expired") || cookies.length==1 || newToken.contains("invalid")){
      String site = new String("http://localhost:8080/Marketplace_WebApp/login.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
    } else {
%>

<jsp:include page="views/editproduct-view.jsp" />

<% } %>

