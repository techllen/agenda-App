package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techllenapps.agendaapp.entity.User;
import com.techllenapps.agendaapp.model.LoginDao;
import com.techllenapps.agendaapp.model.RegisterDao;

/**
 * THE-Allenlogin
 */
@WebServlet("/")
public class userAdministrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LoginDao logindao = new LoginDao();
	RegisterDao registerdao = new RegisterDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//we are switching functions according to paths to the servlet linked to usera dministration action
		String userAdminAction = request.getServletPath();
		userAdminAction = userAdminAction.toLowerCase();

		switch (userAdminAction) {
		case "login":
			String usernameLogin = request.getParameter("username");
			String passwordLogin = request.getParameter("password");

			//linking parameters to the class user
			user.setUsername(usernameLogin);
			user.setPassword(passwordLogin);
			//calling the dao method to validate the user the
			//the method logindao returns false when only unique row for the user is present
			//using the .next method
			if (logindao.validatelogin(user)==false) {
				//after validating set the session which will include attribute for this user
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//after validating open the home page for the user
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("loginerror.jsp").forward(request, response);
			}
			break;

		case "register":
			String email = request.getParameter("email");
			String usernameRegister = request.getParameter("username");
			String passwordRegister = request.getParameter("password");

			//linking parameters to the class user
			user.setUsername(email);
			user.setUsername(usernameRegister);
			user.setPassword(passwordRegister);

			//calling the Dao method to add the user to the database and 
			//check if the user has been added
			//using the executeUpdate method
			try {
				if (registerdao.regsiterUser(user)==1) {
					//after adding the user and validating if the user has been added
					//set the session which will include attribute for this user to enable
					//logging out
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					//after validating open the home page for the user
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else {
					//go to error if anything goes wrong
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "logout":
			//Invalidating user session which will terminate the user user
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.removeAttribute("user");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
