<%-- 
    Document   : sales-view
    Created on : Nov 7, 2016, 7:12:54 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
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
					<li><a href="addproducts.jsp">Add Product</a></li>
					<li><a class="active" href="sales.jsp">Sales</a></li>
					<li><a id="nav_purchased" href="purchased.jsp">Purchased</a></li>
				</ul>
			</nav>
		</header>

		<h2>Here are your sales</h2>
		
		<jsp:include page="../includes/sales-panel.jsp" />
		
	</body>

</html>
