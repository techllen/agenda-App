<%@page import="java.util.ArrayList"%>
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

    <!-- ProjectOwn Exteranal CSS -->
    <link rel="stylesheet" href="./assets/css/styles.css">

    <title>Add Activity</title>
</head>

<body>
    <!-- intro bar -->
    <div class="app">
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
                        <!-- page names will determine which operation is being executed by JSP -->
                    <a href="<%=request.getContextPath()%>/addactivity">Add Activity</a>
                    <a href="<%=request.getContextPath()%>/updateactivity">Update Activity</a>
                    <a href="<%=request.getContextPath()%>/viewactivity">View Activities</a>
                    <a href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
        <!-- Contents -->
                <div class="col-sm-10">
                    <div class="content-addactivity">
                        <p>Anything changing today in this activity</p>
                        <form action="${pageContext.request.contextPath}/update" method="get">
        <!-- passing the activity id using scriplet -->
        					 <%--
        					                            <%
                            	int id = Integer.parseInt(request.getParameter("id"));
                            %>
                        	<p><%out.print(id);%></p>
        					  --%>
        					<input type="hidden" name="id" value="${activityToDisplay.id}">
        					<label for="tittle">Please enter the name of the activity</label><br>
                            <input style="height: 30px;" id="tittle" name="tittle" maxlength="50" size="50" value="${activityToDisplay.tittle}"><br>
                            <label for="description">Please describe what you are planning to do</label><br>
                            <input style="height: 100px;" id="description" name="description" maxlength="250" size="70" value="${activityToDisplay.description}"><br>
                            <label for="startdate">Please enter start date</label><br>
                            <input type="date" id="startdate" name="startdate" value="${activityToDisplay.startDate}"><br>
                            <label for="enddate">Please enter end date</label><br>
                            <input type="date" id="enddate" name="enddate" value="${activityToDisplay.endDate}"><br>
                            <label for="status">Please select the status of this activity</label><br><br>
                            <select name="status" id="status">
                                <option value="beginning">Beginning</option>
                                <option value="work in progress">Work in progress</option>
                                <option value="halted">Stopped for now</option>
                                <option value="finished">Finished</option>
                            </select><br> <br>
                            <button type="submit"> Update</button>
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