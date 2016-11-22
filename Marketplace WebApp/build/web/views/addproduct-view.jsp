<%-- 
    Document   : addproduct-view
    Created on : Nov 7, 2016, 7:06:53 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String owner = Controller.RetrieveCookieController.retrieveName(request.getCookies());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
		<script src="javascript/addproduct.js" type="text/javascript"></script>
		<title>Sale Project</title>
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
					<li><a class="active" href="addproducts.jsp">Add Product</a></li>
					<li><a href="sales.jsp">Sales</a></li>
					<li><a id="nav_purchased" href="purchased.jsp">Purchased</a></li>
				</ul>
			</nav>
		</header>

		<h2>Please add your product here</h2>

			<form method="POST" id="addproduct" enctype="multipart/form-data" action="addproduct" onsubmit="return(validate());">
				<input type="hidden" name="owner" value="<%= owner %>"/>
                                <p>Name</p>
				<input type="text" name="name" id="name">
				<p>Description (max 200 chars)</p>
				<textarea rows="6" form="addproduct" name="description" id="description"></textarea>
				<p>Price (IDR)</p>
				<input name="price" id="price"><br>
				<p>Photo</p>
				<input type="file" name="photo" id="photo">
				<button>CANCEL</button>
				<button type="submit">ADD</button>
			</form>


	</body>

</html>
