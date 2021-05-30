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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

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

<title>Add Activity</title>
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
                <div class="col-sm-2">
                </div>
                <div class="appname col-sm-10">
                    AGENDA
                </div>
            </div>
        </div>

        <!-- Menu -->
        <div class="sidenav">
            <div class="row">
                <div class="menu col-sm-2">
                    <a href="<%=request.getContextPath()%>/home">Agenda App</a>
                    <a href="<%=request.getContextPath()%>/addactivity">Add Activity</a>
                    <a href="<%=request.getContextPath()%>/updateactivity?username=<c:out value="${user.username}"/>">Update Activity</a>
                    <a href="<%=request.getContextPath()%>/viewactivity?username=<c:out value="${user.username}"/>"> View Activities</a>
                    <a href="<%=request.getContextPath()%>/logout">Logout</a> 
                </div>
        <!-- Contents -->
                <div class="col-sm-10">
                    <div class="content-addactivity">
                        <p>Whats on your mind for today</p>
                        <form action="${pageContext.request.contextPath}/validatedate" method="get">
                        	<label for="tittle">Please enter the name of the activity</label><br>
                            <input style="height: 30px;" id="tittle" name="tittle" maxlength="50" size="50" required><br>
                            <label for="description">Please describe what you are planning to do</label><br>
                            <textarea id="description" name="description" cols="70" required></textarea><br>
                            <label for="startdate">Please enter start date and time</label><br>
                            <input type="date" id="startdate" name="startdate" required><br>
                            <label for="enddate">Please enter end date and time</label><br>
                            <input type="date" id="enddate" name="enddate" required><br><br><br>
                        	<input type="hidden" name="form" value="addactivity"/><br>
                        	<input type="hidden" name="username" value="${user.username}"/><br>
                            <button type="submit">Add</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!--footer-->
        <div class="footer">
            <div class="row">
                <div class="made col">
                    Developed by M@are
                </div>
            </div>
        </div>
    </div>
</body>

</html>