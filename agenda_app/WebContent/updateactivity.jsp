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

    <title>Update Activity</title>
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
                    <a href="/index.html">Home</a>
                    <a href="/addactivity.html">Add Activity</a>
                    <a href="/updateactivity.html">Update Activity</a>
                    <a href="/viewactivity.html">View Activities</a>
                </div>
                <div class="col-sm-10">
                    <div class="content-updateactivity">
                        <p>Activities to update</p><br><br>

                        <table>
                            <tr>
                                <th>Activity Description</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>State of the activity</th>
                                <th>Update</th>
                            </tr>
                            <tr>
                                <td>Doing cooking class</td>
                                <td>12/09/2021</td>
                                <td>17/09/2021</td>
                                <td>Beginning</td>
                                <td style="text-align:center"><a href="/updateactivitypage.html"><button class="update-button">Update</button>/<button class="update-button">Delete</button></a></td>
                            </tr>
                            <tr>
                                <td>Doing html class</td>
                                <td>13/09/2021</td>
                                <td>18/09/2021</td>
                                <td>Beginning</td>
                                <td style="text-align:center" ><a href="/updateactivitypage.html"><button class="update-button">Update</button>/<button class="update-button">Delete</button></a></td>
                            </tr>
                        </table>
                        
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