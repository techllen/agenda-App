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
 * THE-Allen
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LoginDao logindao = new LoginDao();
	RegisterDao registerdao = new RegisterDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formOperation = request.getParameter("form");
		formOperation= formOperation.toLowerCase();

		switch (formOperation) {
		case "login":
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//linking parameters to the class user
			user.setUsername(username);
			user.setPassword(password);
			//calling the dao method to validate the user the user 
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
			//register(request,response);
			break;

		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
