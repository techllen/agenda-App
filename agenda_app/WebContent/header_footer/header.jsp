<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.techllenapps.agendaapp.entity.Activity"%>
<%@ page isELIgnored="false"%>

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
@charset "UTF-8";

.app {
	padding: 20px;
}

/*loginpage*/
.login {
	margin-top: 250px;
	text-align: center;
	margin-bottom: 300px;
}

/*Index*/
.topbar .row {
	background-color: #0099ff;
	font-size: 35px;
	color: #f2f2f2;
	height: 60px;
}

.topbar .appname {
	text-align: center;
}

.sidenav .row .menu {
	display: flex;
	flex-direction: column;
	background-color: #0099ff;
}

.sidenav a {
	text-decoration: none;
	color: f2f2f2;
	font-size: 25px;
	border-bottom: 0.5px solid #f2f2f2;
}

.sidenav .row {
	height: 85%;
}

.menu a:hover {
	color: black;
}

.menu a:active {
	color: coral;
}

.content {
	text-align: center;
	font-size: 30px;
	margin-top: 300px;
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

/*Add ACtivity*/
.content-addactivity p {
	font-size: 30px;
	margin-top: 30px;
}

.content-addactivity label {
	font-size: 20px;
	margin-top: 30px;
}

.content-addactivity input {
	margin-top: 30px;
}

/*Apdate ACtivity*/
.content-updateactivity p {
	font-size: 30px;
	margin-top: 30px;
}

table {
	margin-top: -50px;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table th {
	text-align: center;
	background-color: #0099ff;
}

table tr:nth-child(odd) {
	background-color: #0099ff15;
}

table tr {
	height: 40px;
}

.update-button .delete-button {
	border-radius: 4px;
	background-color: #0099ff;
	height: 30px;
	width: 80px;
	font-size: 15px;
}

.delete-button {
	border-radius: 4px;
	background-color: #0099ff;
	height: 30px;
	width: 80px;
	font-size: 15px;
}

button-data a {
	text-align: center;
}

/*view activity*/
.content-viewactivity p {
	font-size: 30px;
	margin-top: 30px;
}

table {
	margin-top: -50px;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table th {
	text-align: center;
	background-color: #0099ff;
}

table tr:nth-child(odd) {
	background-color: #0099ff15;
}

table tr {
	height: 40px;
}

/*Login errot*/
button .try-again-button {
	border-radius: 4px;
	background-color: #0099ff;
	height: 30px;
	width: 80px;
	font-size: 15px;
}
</style>

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
				<div class="menu col-sm-2">
					<!-- page names will determine which operation is being executed by JSP -->
					<a href="<%=request.getContextPath()%>/home">Agenda App</a>
                    <a href="<%=request.getContextPath()%>/addactivity">Add Activity</a>
                    <a href="<%=request.getContextPath()%>/updateactivity?username=<c:out value="${user.username}"/>">Update Activity</a>
                    <a href="<%=request.getContextPath()%>/viewactivity?username=<c:out value="${user.username}"/>"> View Activities</a>
                    <a href="<%=request.getContextPath()%>/logout">Logout</a> 
				</div>