<%-- 
    Document   : register.jsp
    Created on : Nov 7, 2016, 12:45:28 PM
    Author     : Mayu
--%>



<%
    Cookie[] cookies = null;
    cookies = request.getCookies();
//    out.println(cookies.length);
    if (cookies.length>1){
        String site = new String("http://localhost:8080/catalog.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
    } else {
%>

<jsp:include page="views/register-view.jsp" />

<% } %>


