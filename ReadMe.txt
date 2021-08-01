Main Application Source Code : agenda_app folder in the repository
Readme: ReadMe.txt file in the repository
Screenshots: Agenda Application Screenshots folder in the repository

1.USER STORIES

1.1 This is a simple todo list app where the user can
-Register for an account
-Log into the registered account
-Logout
-Add activities into the todo list
-Update activities in the app
-View activities in the app
-delete activities in the app

1.2 Technologies used
The whole app is built based on the MVC(Model View Controller) design pattern .

1.2.1 Model Technologies
Technologies use are
-MySQL
-Software - MySQL Workbench 8.0

1.2.2 View Technologies
Technologies used are 
-HTML 5
-CSS 3
-Bootstrap 4(will be updated to 5)
-Java Scriplets
-JSTL

1.2.3 Controller Technologies
Technologies used are 
-JAVA 
-JSPs(Java Server Pages)

1.3 Design and How the app Work

1.3.1 Design
The app works basing on two entities/beans which are User and Activities.

User has all the properties that belongs to the specific user(email,
username and password) - HAS A Relationship

Activities has all the properties that belong to specific activities (title,description,
start date,end date,status and a user ID linked to that activity) HAS A Relationship

1.3.2 How the app works

1.3.2.a Login and Register Module
When tha app is opened the first page to appear is a registration page,for a new user you 
can register but if you are alredy a user there is a link to the login  page.

The part of the application which enable the execution of Login is
M odel - RegisterDao.java,LoginDao.java
V iew - Login.jsp,Register.jsp
C ontroller - LoginController,RegisterController
Entity/Bean - user.java

1.3.2.b Operations Module
After being validated and Logged in the user will be sent to the index page where
the menu will appear to perform different operations such as adding activities,
updating activities,viewing activities and Logout.

The part of the app involved in the execution of the operations above is
M odel - ActicityOperationDao.java
V iew - index.jsp,error.jsp,addactivity.jsp,updateactivity.jsp ,updateactivitypage.jsp,
        viewactivity.jsp
C ontroller - OperatioController.java
Entity - User.java ,Activity,java

1.3.2.b Logout Module
After the user is done performing the operations a logout can be done from the menu 
options.

The part of the app involved in the execution of the operations above is
V iew - index.jsp,error.jsp,addactivity.jsp,updateactivity.jsp ,updateactivitypage.jsp,
        viewactivity.jsp (the user can logout from any of this page)
C ontroller - LogoutController.java
Entity - User.java

1.3.3 FLOWDIAGRAM

1.3.3.1 Login and Register Module
1.3.3.2 Operations Module
1.3.3.3 Logout Module

2.PURPOSE FOR THIS CODE

2.1 PURPOSE OF THE APP
Is A simple todo list application for precticing how to code in java.


3.INSTALLATION
Create a MySQL database in your station and Link the username and password to the 
Application in the model layer(in the DAOs)
Add Tomcat as a server to your compiler
Run the files in your compiler

4.LICENCE INFORMATION

GNU General Public License v3.0

NOTE:Refer to licence file in the repository.

