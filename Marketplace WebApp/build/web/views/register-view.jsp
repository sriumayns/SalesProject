<%-- 
    Document   : register-view
    Created on : Nov 7, 2016, 7:11:49 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link rel="stylesheet" href="views/css/style.css">
                <script src="javascript/register-validation.js" type="text/javascript"></script>
		<title>Sale Project - Register</title>
	</head>

	<body>
		<div class="container">
			<h1>Sale<a>Project</a></h1>

			<h2>Register</h2>
                        <form method="POST" onsubmit="return(valRegister());" action="http://localhost:8080/ServletRegister">
				<p>Full Name : </p>
				<input id="fullname" type="text" name="fullname" autofocus="">
				<p>Username :</p>
				<input id="username" type="text" name="username"><br>
				<p>Email :</p>
				<input id="email" type="text" name="email" onchange="validateEmailForm()"><br>
				<p>Pasword :</p>
				<input id="password" type="password" name="password"><br>
				<p>Confirm Password :</p>
				<input id="confirmpassword" type="password" name="confirmpassword"><br>
				<p>Full Address :</p>
				<input id="address" type="text" name="address"><br>
				<p>Postal Code :</p>
				<input id="postalcode" type="text" name="postalcode"><br>
				<p>Phone Number :</p>
				<input id="phonenumber" type="number" name="phonenumber"><br>
				<button type="submit">REGISTER</button>
			</form>

			<p id="pesan">Already registered? Login <a href="login.jsp">here</a></p>
		</div>
	</body>
</html>