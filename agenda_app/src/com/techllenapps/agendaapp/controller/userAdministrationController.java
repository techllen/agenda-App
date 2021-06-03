//package com.techllenapps.agendaapp.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.techllenapps.agendaapp.entity.User;
//import com.techllenapps.agendaapp.model.LoginDao;
//import com.techllenapps.agendaapp.model.RegisterDao;
//
///**
// * THE-Allenlogin
// */
//@WebServlet("/administration")
//public class userAdministrationController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	User user = new User();
//	LoginDao logindao = new LoginDao();
//	RegisterDao registerdao = new RegisterDao();
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//we are switching functions according to paths to the servlet linked to user administration action
//		String formOperation = request.getParameter("form");
//		formOperation= formOperation.toLowerCase();
//
//		switch (formOperation) {
//		case "login":
//			String usernameLogin = request.getParameter("username");
//			String passwordLogin = request.getParameter("password");
//
//			//linking parameters to the class user
//			user.setUsername(usernameLogin);
//			user.setPassword(passwordLogin);
//
//			//calling the dao method to validate the user the
//			//the method logindao returns false when only unique row for the user is present
//			//using the .next method
//			if (logindao.validatelogin(user)==false) {
//				//after validating set the session which will include attribute for this user
//				HttpSession session = request.getSession();
//				session.setAttribute("user", user);
//
//				//after validating open the home page for the user
//				home(request,response);
//			}
//			else {
//				loginerror(request,response);
//			}
//			break;
//
//		case "register":
//			String email = request.getParameter("email");
//			String usernameRegister = request.getParameter("username");
//			String passwordRegister = request.getParameter("password");
//
//			//linking parameters to the class user
//			user.setUsername(email);
//			user.setUsername(usernameRegister);
//			user.setPassword(passwordRegister);
//
//			//calling the Dao method to add the user to the database and 
//			//check if the user has been added
//			//using the executeUpdate method
//			try {
//				if (registerdao.regsiterUser(user)==1) {
//					//after adding the user and validating if the user has been added
//					//set the session which will include attribute for this user to enable
//					//logging out
//					HttpSession session = request.getSession();
//					session.setAttribute("user", user);
//
//					//after validating open the home page for the user
//					home(request,response);
//				}
//				else {
//					//go to error if anything goes wrong
//					error(request, response);
//				}
//			} catch (ClassNotFoundException | ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//
//		default:
//			error(request, response);
//		}
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String task = request.getParameter("task");
//		task= task.toLowerCase();
//		switch (task) {
//		case "logout":
//			//Invalidating user session which will terminate the user user
//			HttpSession session = request.getSession(false);
//			if(session != null) {
//				session.removeAttribute("user");
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//			else {
//				error(request, response);
//			}
//			break;
//		default:
//			error(request, response);
//		}
//	}
//
//	private void home(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("error.jsp").forward(request, response);
//	}
//
//	private void loginerror(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			request.getRequestDispatcher("loginerror.jsp").forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
