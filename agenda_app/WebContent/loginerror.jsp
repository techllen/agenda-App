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

<!-- Custom external Exteranal CSS -->
    <!--<link rel="stylesheet" href="styles.css">-->
    <!-- Internal Custom CSS -->
<style type="text/css">
.app {
	padding: 20px;
}

.login {
	margin-top: 150px;
	text-align: center;
	margin-bottom: 300px;
}

.topbar .row {
	background-color: #0099ff;
	font-size: 35px;
	color: #f2f2f2;
	height: 60px;
}

.footer {
	color: f2f2f2;
	text-align: center;
	border-top: 5px solid #f2f2f2;
}

.footer .row {
	background-color: blue;
	height: 50px;
}

.made {
	margin-top: 10px;
}

</style>

<title>Invalid Login</title>
</head>

<body>
<%		
	//restricting the user from accessing the app when in another browser(session is browser dependent)
	//or when trying to view the page withoud loging in
	if(session.getAttribute("user")==null){
		response.sendRedirect("./login.jsp");
	}
	%>
	<!-- intro bar -->
	<div class="app container">
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
						<br><a href="./login.jsp"><button  class="try-again-button"type="submit">Try Again</button></a>
					</div>
				</div>
			</div>
		</div>
		<%@include file="./header_footer/footer.jsp" %>