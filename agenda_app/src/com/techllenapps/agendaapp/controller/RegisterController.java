package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techllenapps.agendaapp.entity.User;
import com.techllenapps.agendaapp.model.RegisterDao;

/**
 * THE-Allen
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	RegisterDao registerdao = new RegisterDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formOperation = request.getParameter("form");
		formOperation= formOperation.toLowerCase();

		switch (formOperation) {
		case "register":
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//linking parameters to the class user
			user.setUsername(email);
			user.setUsername(username);
			user.setPassword(password);
			
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
}
