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

<!-- ProjectOwn Exteranal CSS -->
<link rel="stylesheet" href="./assets/css/styles.css">

<title>Update Activity</title>
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
					<a href="<%=request.getContextPath()%>/addactivity">Add
						Activity</a> <a href="<%=request.getContextPath()%>/updateactivity">Update
						Activity</a> <a href="<%=request.getContextPath()%>/viewactivity">View
						Activities</a> <a href="${pageContext.request.contextPath}/logout">Logout</a>
				</div>
				<div class="col-sm-10">
					<div class="content-updateactivity">
						<p>Activities to update</p>
						<br> <br>
						<table>
							<thead>
								<tr>
									<th>Activity id</th>
									<th>Activity Name</th>
									<th>Activity Description</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>State of the activity</th>
									<th>Action</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="act" items="${listedactivities}">
									<tr>
										<td><c:out value="${act.id}" /></td>
										<td><c:out value="${act.tittle}" /></td>
										<td><c:out value="${act.description}" /></td>
										<td><c:out value="${act.startDate}" /></td>
										<td><c:out value="${act.endDate}" /></td>
										<td><c:out value="${act.status}" /></td>
										<td class="button-data">
											<!--Getting an ID for a specific activity to allow selection for Update and deletion
											by passing data to from this jsp another JSP
										<a
											href="updateactivitypage.jsp?id=<c:out value="${act.id}"/>">
												<button class="update-button" class="btn btn-success">Update</button>
										</a>/ -->
										<!--Getting an ID for a specific activity to allow selection for Update and deletion
											by passing data from this jsp to a servlet-->
											<a
											href="updateactivitypage?id=<c:out value="${act.id}"/>">
												<button class="update-button" class="btn btn-success">Update</button>
										</a>/ 
										<a
											href="<%=request.getContextPath()%>/delete?id=<c:out value="${act.id}"/>">
												<button class="delete-button" class="btn btn-warning">Delete</button>
										</a>
									</tr>
								</c:forEach>
							</tbody>
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