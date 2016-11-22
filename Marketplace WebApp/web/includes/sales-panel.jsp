<%-- 
    Document   : sales-panel
    Created on : Nov 7, 2016, 10:44:39 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    // Get an array of Cookies associated with this domain
    cookies = request.getCookies();
    if( cookies != null ){
        for (int i = 0; i < cookies.length; i++){
           cookie = cookies[i];
//                   out.print("Name : " + cookie.getName( ) + ",  ");
//                   out.print("Value: " + cookie.getValue( )+" <br/>");
        }
    }else{
//                out.println("<h2>No cookies founds</h2>");
    }
    String namaOwner = cookies[1].getValue();
    //String namaOwner = "kamu";
    String[] results = Controller.TransactionController.displaySales(namaOwner);
//    out.print("<br>" + results.length);
    for (String result : results) {
//       out.print("<br>" + result);
       if (!result.equals("")) {
            String[] column = result.split("!!!");
            String id_buyer = column[0];
            String product = column[1];
            String receiver = column[2];
            String address = column[3];
            String postal_code = column[4];
            String phone_num = column[5];
            String credit_num = column[6];
            String verification_num = column[7];
            String jml_barang = column[8];
            String owner = column[9];
            String productname = column[10];
            String price = column[11];
            String photo = "img/" + column[12];
            String purchase_date = column[13];
            String purchase_time = column[14];
            
//            String id = "haha";
//            String name = "haha";
//            String desk = "haha";
//            String price = "haha";
//            String photo = "http://localhost:8081/Marketplace_WebService/";
//            String addtime = "haha";
//            String owner = "haha";
//            String nLike = "haha";
//            String nPurchase = "haha";
//            String liked = "haha";
%>
<div class="date-and-time">
        <p id="date"><%= purchase_date %></p>
        <p>at <%= purchase_time %></p>
    </div>

    <div class="container-product">
        <img src="<%= photo %>" width="100px" height="100px">
        <div class="about-transaction">
                <h3><%= productname %></h3>
                <p>IDR <%= String.valueOf(Integer.parseInt(price)*Integer.parseInt(jml_barang)) %></p>
                <p><%= jml_barang %> pcs</p>
                <p><%= price %></p>
                <br>
                <p>bought by <%= id_buyer %></strong></p>
        </div>
        <div class="buyer-stats">
                <p>Delivery to <strong><%= receiver %></strong></p>
                <p><%= address %></p>
                <p><%= postal_code %></p>
                <p><%= phone_num %></p>
        </div>
    </div>
<%      }

    }%>
