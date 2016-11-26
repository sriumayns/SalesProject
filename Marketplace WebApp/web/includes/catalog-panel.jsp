<%-- 
    Document   : catalog-panel
    Created on : Nov 7, 2016, 10:41:52 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String namaProduk = "none";
    String namaOwner = "none";
    if (request.getParameter("search")!=null) {
        if (request.getParameter("search_opt").equals("name")) {
            namaProduk = request.getParameter("search");
        } else {
            namaOwner = request.getParameter("search");
        }
    }
//    out.print("Produk " + namaProduk);
//    out.print("<br> Owner " + namaOwner);
    String username = Controller.RetrieveCookieController.retrieveName(request.getCookies());
    String[] results = Controller.ProdukController.displayProduct(namaProduk, namaOwner);
    String id_active = "0";
//    out.print("<br>" + results.length);
    for (String result : results) {
//       out.print("<br>" + result);
       if (!result.equals("")) {

            String[] column = result.split("!!!");
            if (column.length == 10) {
                String id = column[0];
                String name = column[1];
                String desk = column[2];
                String price = column[3];
                String photo = "img/" + column[4];
                String addtime = column[5];
                String owner = column[6];
                String nLike = column[7];
                String nPurchase = column[8];
                String liked = Controller.ProdukController.isLiked(id, username);
                String color = "blue";
                if (liked.equals("UNLIKE")){
                    color = "red";
                }
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
                <ul>
                    <li class="hidden"><a href="#" ><%= owner %></a></li>
                    <li class="username" id="openChat"><a href="#" ><%= owner %></a></li>
                </ul>
                <p> <%= addtime %> </p>
            </div>

            <div class="container-product">
                    <img src="<%= photo %>" alt="<%= photo %>" width="100px" height="100px">
                    <div class="about-product">
                            <h3><%= name %></h3>
                            <p id="price">IDR <%= price %></p>
                            <p><%= desk %></p>
                    </div>
                    <div class="container-stats">
                            <p id="n_<%= id %>, <%= owner %>"><%= nLike %> likes</p>
                            <p><%= nPurchase %> purchases</p>
                            <div class="menu">
                                <div><a href="like?do=<%= liked %>&id_product=<%= id %>&uname=<%= username %>" class="menu-like" id="<%= id %>, <%= owner %>" style="color:<%= color %>"><%= liked %></a></div>
                                    <p><a class="menu-buy" href="confirmpurchase.jsp?id_product=<%= id %>">BUY</a></p>
                            </div>
                    </div>
            </div>
                                    <br>
<%          }
        }
    }%>