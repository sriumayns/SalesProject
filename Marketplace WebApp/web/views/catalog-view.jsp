<%-- 
    Document   : catalog-view
    Created on : Nov 7, 2016, 7:04:08 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
		<script src="javascript/catalog.js" type="text/javascript"></script>
		<title>Sale Project</title>
	</head>

	<body onload="pageLoad()">
		<header id="header">
			<h1>Sale<a>Project</a></h1>
			<div class="float-right">
                            <jsp:include page="/includes/dashboard.jsp"/>
			</div>

			<nav>
				<ul>
					<li><a class="active" href="catalog.jsp">Catalog</a></li>
					<li><a href="yourproducts.jsp">Your Product</a></li>
					<li><a href="addproducts.jsp">Add Product</a></li>
					<li><a href="sales.jsp">Sales</a></li>
					<li><a id="nav_purchased" href="purchased.jsp">Purchased</a></li>
				</ul>
			</nav>
		</header>

		<h2>What are you going to buy?</h2>

		<form class="container-search" method="GET">
			<input type="hidden" name="id_active" value=0 />
			<input id="form_search" type="text" name="search" value="Search catalog ..." onfocus="clearBar(this)">
			<button id="btn_GO" type="submit">GO</button>
			<div class="container-radio">
				<input class="radio" type="radio" name="search_opt" value="name" checked="checked"> Buy Product
			</div>
			<div class="container-radio">
				<input class="radio" type="radio" name="search_opt" value="owner"> Buy Store
			</div>

		</form>
                
                <jsp:include page="../includes/catalog-panel.jsp" />

	</body>

</html>
