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

<title>Invalid Login</title>
</head>

<body>
	<!-- intro bar -->
	<div class="app">
		<div class="topbar">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="appname col-sm-10">AGENDA</div>
			</div>
		</div>

		<!-- things we can do -->
		<div class="sidenav">
			<div class="row">
				<div class="col-sm-12">
					<div class="content">
						<p>Oooooooops!!!!</p>
						<p>Please check your username and password</p>
					</div>
					<div class="login container">
						<br>
						<p>Please enter your username and password</p>
						<br>
						<form action="${pageContext.request.contextPath}/loginAndRegister"
							method="post">
							<label for="username">Username</label><br> <br> <input
								type="text" id="username" name="username"
								value="${param.username}" required /><br> <br> <label
								for="password">Password</label><br> <br> <input
								type="password" id="password" name="password"
								value="${param.password}" required /><br> <br>
							<input type="hidden" name="form" value="login" /><br> <br>
							<input type="submit">
						</form>
					</div>
				</div>
			</div>
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