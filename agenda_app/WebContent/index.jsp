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

    <title>AgendaApp</title>
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

        <!-- things we can do -->
        <div class="sidenav">
            <div class="row">
                <div class="menu col-sm-2">
                        <!-- opening links to JSP pages -->
                    <a href="<%=request.getContextPath()%>/addactivity">Add Activity</a>
                    <a href="<%=request.getContextPath()%>/updateactivity">Update Activity</a>
                    <a href="<%=request.getContextPath()%>/viewactivity">View Activities</a>
                    <a href="${pageContext.request.contextPath}/logout">Logout</a>        
                </div>
                <div class="col-sm-10">
                    <div class="content">
                        <p>Welcome to myAgenda App</p>
                        <p>What can we do for you?</p>
                        <p>Anything in your mind for today!!!?</p>
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