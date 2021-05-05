package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techllenapps.agendaapp.entity.User;
import com.techllenapps.agendaapp.model.LoginDao;

/**
 * Matare
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao loginDao = new LoginDao();
       
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	
	
	if (loginDao.validatelogin(user)) {
		response.sendRedirect("index.jsp");
	}
	
 }

}
