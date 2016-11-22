<%-- 
    Document   : product-panel
    Created on : Nov 7, 2016, 10:43:50 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
//    if( cookies != null ){
//        for (int i = 0; i < cookies.length; i++){
//           cookie = cookies[i];
//           out.print("Name : " + cookie.getName( ) + ",  ");
//           out.print("Value: " + cookie.getValue( )+" <br/>");
//        }
//    }else{
//       out.println("<h2>No cookies founds</h2>");
//    }
            
    String username = cookies[1].getValue();
    String[] results = Controller.YourProductController.displayProduct(username);
    String id_active = "0";
//    out.print("<br>" + results.length);
    for (String result : results) {
//       out.print("<br>" + result);
       if (!result.equals("")) {

            String[] column = result.split("!!!");
            String id = column[0];
            String name = column[1];
            String desk = column[2];
            String price = column[3];
            String photo = "img/" + column[4];
            String addtime = column[5];
            String owner = column[6];
            String nLike = column[7];
            String nPurchase = column[8];
            String liked = column[9];
    
%>

<div class="date-and-time">
        <p><%= addtime %></p>
</div>

<div class="container-product">
    <img src="<%= photo %>" alt="<%= photo %>" width="100px" height="100px">
    <div class="about-product">
        <h3><%= name %></h3>
        <p id="price">IDR <%= price %></p>
            <p><%= desk %></p>
    </div>
    <div class="stats-product">
            <p><%= nLike %> likes</p>
            <p><%= nPurchase %> purchases</p>
            <div class="menu">
                    <p><a class="menu-edit" href="editproducts.jsp?id_product=<%= id %>">EDIT</a></p>
                    <p><a class="menu-delete" onclick="return(confirmdelete());" href="includes/delete-product.jsp?idProduct=<%=id%>">DELETE</a></p>
            </div>
    </div>
</div>
<%}
    }
    %>