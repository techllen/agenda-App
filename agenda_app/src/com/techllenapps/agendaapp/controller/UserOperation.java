package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.techllenapps.agendaapp.entity.User;
import com.techllenapps.agendaapp.model.LoginDao;
import com.techllenapps.agendaapp.model.RegisterDao;

/**
 * THE-Allen
 */
@WebServlet("/loginAndRegister")
public class UserOperation extends HttpServlet {
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
			if (login(user)==false) {
				loginUser(request, response);
			}
			else {
				loginerror(request,response);
			}
			break;

		case "register":
			//register(request,response);
			break;

		default:
			error(request,response);
		}
	}


	private boolean login(User user) {
		//calling the dao method to validate the user the user
		boolean status=logindao.validatelogin(user);
		//checking if the user is in the system
		return status;
	}

	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	public void loginerror(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("loginerror.jsp").forward(request, response);
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}
