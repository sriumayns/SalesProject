<%-- 
    Document   : login-view
    Created on : Nov 7, 2016, 7:09:25 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
                <script src="javascript/login-validation.js" type="text/javascript"></script>
		
		<title>Sale Project - Login</title>
	</head>

	<body>
		<div class="container">
			<h1>Sale<a>Project</a></h1>

			<h2>Please Login</h2>

			<form method="POST" onsubmit="return(validateLogin());" action="http://localhost:8080/ServletLogin" >
				<p>Email or Username</p>
				<input id="username" type="text" name="username" autofocus="">
				<p>Password</p>
				<input id="password" type="password" name="password"><br>
				<button type="submit">LOGIN</button>
			</form>
                        
			<p id="pesan">Don't have an account yet? Register <a href="register.jsp">here</a></p>
		</div>
	</body>
</html>