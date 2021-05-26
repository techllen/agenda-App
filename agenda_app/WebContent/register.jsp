<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<!-- ProjectOwn Exteranal CSS -->
<link rel="stylesheet" href="assets/css/styles.css">

<title>AgendaApp Registration</title>
</head>

<body>
<%
	//Instructing the browser not to save/cache this page to block a logged out user from viewing it again
	//restrict the access to the previous pages after log out
	//when the user user HTTP 1.1
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	//for the previous version of http HTTP 1.0
	response.setHeader("Pragma","no-cache");
	//Proxies,set the page to expire in 0s time
	response.setHeader("Expires","0");
	%>
	<!-- intro bar -->
	<div class="app">
		<div class="topbar">
			<div class="row">
				<div class="appname col-sm-12">AGENDA</div>
			</div>
		</div>

		<!-- things we can do -->
		<div class="login container">
			<p>User registration</p>
			<br>
			<p>Please enter your email,username and password to register</p>
			<br>
			<form action="${pageContext.request.contextPath}/register"
				method="post">
				<label for="email">Email address</label><br>
				<br> <input type="email" id="email" name="email" required><br>
				<br> <label for="username">Username</label><br>
				<br> <input type="text" id="username" name="username" required><br>
				<br> <label for="password">Password</label><br>
				<br> <input type="password" id="password" name="password" required><br><br> <br>
				<br> <label for="password">Please Re-enter the Password</label><br>
				<br> <input type="password" id="password" name="password" required><br><br> <br>
				<input type="hidden" name="form" value="register"><br><br>
				<button type="submit">Register</button>
				<br><br>
				<p>If you are already a user you may <a href="./login.jsp">Login</a>  </p>
				
			</form>
		</div>
		<!--footer-->
		<div class="footer">
			<div class="row">
				<div class="made col">Developed by M@are</div>
			</div>
		</div>
	</div>
</body>

</html>