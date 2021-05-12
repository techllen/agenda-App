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
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LoginDao logindao = new LoginDao();
	RegisterDao registerdao = new RegisterDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Invalidating user session which will terminate the user user
		HttpSession session = request.getSession(false);

		if(session != null) {
			session.removeAttribute("user");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
