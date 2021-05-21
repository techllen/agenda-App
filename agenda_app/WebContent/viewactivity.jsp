<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- ProjectOwn Exteranal CSS -->
<link rel="stylesheet" href="assets/css/styles.css">

<title>View activities</title>
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
				<div class="menu col-sm-2">
					<!-- page names will determine which operation is being executed by JSP -->
					<a href="./addactivity.jsp">Add Activity</a> <a
						href="./updateactivity.jsp">Update Activity</a> <a
						href="./viewactivity.jsp">View Activities</a> <a
						href="${pageContext.request.contextPath}/logout">Logout</a>
				</div>
				<div class="col-sm-10">
					<div class="content-viewactivity">
						<p>List of Agendas</p>
						<br> <br>
						<table>
							<tr>
								<th>Activity Name</th>
								<th>Activity Description</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>State of the activity</th>
							</tr>
							<c:forEach items="${listedactivities}" var="act">
								<tr>
									<td>${act.tittle}</td>
									<td>${act.description}</td>
									<td>${act.startDate}</td>
									<td>${act.endDate}</td>
									<td>${act.status}</td>
								</tr>
							</c:forEach>
						</table>
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