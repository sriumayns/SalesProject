<%-- 
    Document   : editproduct-view
    Created on : Nov 7, 2016, 7:08:39 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        String idp = request.getParameter("id_product");
        String[] column = Controller.ProdukController.getProductbyID(idp);
        String id = column[0];
        String name = column[1];
        String desc = column[2];
        String price = column[3];
        String owner = column[4];
      
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
		<script src="javascript/editproduct.js" type="text/javascript"></script>
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
					<li><a href="sales.jsp">Sales</a></li>
					<li><a id="nav_purchased" href="purchased.jsp">Purchased</a></li>
				</ul>
			</nav>
		</header>

		<h2>Please update your product here</h2>

			<form method="POST" id="addproduct" enctype="multipart/form-data" action="editproduct" onsubmit="return(validate());">
				<p>Name</p>
                                <input type="hidden" name="id" value="<%= id %>"/>
                                
				<input type="text" name="name" id="name" value="<%= name %>">
				<p>Description (max 200 chars)</p>
				<textarea rows="6" form="addproduct" name="desc" id="description" style="font-size:18px"><%= desc %></textarea>
				<p>Price (IDR)</p>
				<input name="price" id="price" value="<%= price %>"><br>
				<p>Photo</p>
				<input type="file" name="photo" disabled="" value="haha">
				<a href="yourproduct.php"><button>CANCEL</button></a>
				<button type="submit">UPDATE</button>
			</form>


	</body>

</html>
