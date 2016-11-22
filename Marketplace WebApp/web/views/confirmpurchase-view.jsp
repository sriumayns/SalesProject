<%-- 
    Document   : confirmpurchase-view
    Created on : Nov 7, 2016, 7:07:51 PM
    Author     : Mayu
--%>
<%
    // Mengambil id produk pada passing parameter
    String id = request.getParameter("id_product");
    String productinfo = Controller.ConfirmPurchaseController.getProductInfo(id);
    //String productinfo = Controller.ConfirmPurchaseController.getProductInfo("1");
    
    // Membaca informasi produk
    String[] element = productinfo.split("!");
    //String owner = element[0];
    String productname = element[1];
    String price = element[2];
    //String photo = element[3];  
    
     
    String[] userinfo = Controller.AkunController.getUserInfo(Controller.RetrieveCookieController.retrieveName(request.getCookies()));
    String fullname = "";
    String address = "";
    String phonenum = "";
    String postcode = "";
    if (userinfo != null) {
        fullname = userinfo[0];
        address = userinfo[1];
        phonenum = userinfo[2];
        postcode = userinfo[3];
    } else {
        out.print("kosong");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
		<script src="javascript/purchase-validation.js" type="text/javascript"></script>
		<title>Confirm Purchase</title>
	</head>

	<body>
		<header id="header">
			<h1>Sale<a>Project</a></h1>
			<div class="float-right">
                            <jsp:include page="/includes/dashboard.jsp"/>
			</div>
			
			<nav>
				<ul>
					<li><a href="catalog.jsp">Catalog</a></li>
					<li><a href="yourproducts.jsp">Your Product</a></li>
					<li><a href="addproducts.jsp">Add Product</a></li>
					<li><a href="sales.jsp">Sales</a></li>
					<li><a id="nav_purchased" href="purchased.jsp">Purchased</a></li>
				</ul>
			</nav>
		</header>

		<div class="container">
			<h2>Please confirm your purchase</h2>
			<hr>
			<form method="POST" id="confirmpurchase" action="ServletConfirmPurchase" onsubmit="return(valpurchase());">
				
                            
                                <input type="hidden" name="id_product" value="<%= id %>">
                                <p>Product		: <%= productname %></p>
				<p>Price		: IDR <%= price %> </p>
				<p onchange="totalPrice(<%= price %>)">Quantity		: <input class="inputquantity" type="number" name="quantity" id="quantity" value="1"> pcs</p>
				<p id="total">Total Price	: <%= price %></p>
				<p>Delivery	to	:</p> 
				<p>Consignee</p>
				<input type="text" name="fullname" id="fullname" value="<%= fullname %>"><br>
				<p>Full Address</p>
				<input type="text" name="address" id="address" value="<%= address %>"><br>
				<p>Postal Code</p>
				<input type="text" name="postalcode" id="postalcode" value="<%= postcode %>"><br>
				<p>Phone Number</p>
				<input type="number" name="phonenumber" id="phonenumber" value="<%= phonenum %>"><br>
				<p>12 Digits Credit Card Number</p>
				<input type="number" name="creditnumber" id="creditnumber"><br>
				<p>3 Digits Card Verification Value</p>
				<input type="number" name="creditverify" id="creditverify"><br>
				<button type="submit">CONFIRM</button>
				<button>CANCEL</button>
			</form>
		</div>
	</body>
</html>
