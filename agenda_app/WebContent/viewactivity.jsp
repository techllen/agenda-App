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
						<br>
						<br>

						<table>
							<tr>
								<th>Activity Name</th>
								<th>Activity Description</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>State of the activity</th>
							</tr>
							<%
								List<User> listUsers = (List) request.getAttribute("listUsers");
								String updateURL;
								for (int i = 0; i < listUsers.size(); i++) {
									out.print("<tr>");
									out.print("<td>" + listUsers.get(i).getUsers_id() + "</td>");
									out.print("<td>" + listUsers.get(i).getUsername() + "</td>");
									out.print("<td>" + listUsers.get(i).getEmail() + "</td>");
									updateURL = request.getContextPath() + "/operation?page=updateUser" + "&usersId="
											+ listUsers.get(i).getUsers_id() + "&username=" + listUsers.get(i).getUsername() + "&email="
											+ listUsers.get(i).getEmail();
									deleteURL = request.getContextPath() + "/operation?page=deleteUser" + "&usersId="
											+ listUsers.get(i).getUsers_id();
									out.print("<td><a href=" + updateURL + ">Update</a>|");
							%>

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