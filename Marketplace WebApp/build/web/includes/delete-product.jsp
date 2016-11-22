<%-- 
    Document   : delete-product
    Created on : Nov 13, 2016, 3:06:23 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    int idProduct = Integer.parseInt(request.getParameter("idProduct"));
    String results = Controller.DeleteYourProductController.deleteYourProduct(idProduct);
    
    String site = new String("http://localhost:8080/Marketplace_WebApp/yourproducts.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site); 

%>
