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
    <link rel="stylesheet" href="assets/css/styles.css">

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
                    <a href="${pageContext.request.contextPath}/operation?page=addactivity">Add Activity</a>
                    <a href="${pageContext.request.contextPath}/operation?page=updateactivity">Update Activity</a>
                    <a href="${pageContext.request.contextPath}/operation?page=viewactivity">View Activities</a>
                    <a href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
        <!-- Contents -->
                <div class="col-sm-10">
                    <div class="content-addactivity">
                        <p>Whats on your mind for today</p>
                        <form action="${pageContext.request.contextPath}/operation" method="get">
                        	<label for="tittle">Please enter the name of the activity</label><br>
                            <input style="height: 30px;" id="tittle" name="tittle" maxlength="50" size="50"><br>
                            <label for="description">Please describe what you are planning to do</label><br>
                            <input style="height: 100px;" id="description" name="description" maxlength="250" size="70"><br>
                            <label for="startdate">Please enter start date and time</label><br>
                            <input type="date" id="startdate" name="startdate" required><br>
                            <label for="enddate">Please enter end date and time</label><br>
                            <input type="date" id="enddate" name="enddate" required><br><br><br>
                        	<input type="hidden" name="form" value="addactivity"/><br>
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