<%-- 
    Document   : login
    Created on : Nov 7, 2016, 11:57:59 AM
    Author     : Mayu
--%>
<%
    Cookie[] cookies = null;
    cookies = request.getCookies();
//    out.println(cookies.length);
//    if (cookies.length>1){
//        String site = new String("http://localhost:8080/catalog.jsp");
//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site); 
//    } else {
%>

<jsp:include page="views/login-view.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-sanitize.js"></script>
<a class="openChat">Open chat</a>
<jsp:include page="includes/chat-window.jsp" />
<% //} %>






