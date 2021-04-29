package com.agendaApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class OperationController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "viewactivity":
			viewActivity(request,response);
			break;
			
		case "updateactivity":
			updateActivity(request,response);
			break;
		
		case "addactivity":
			addActivity(request,response);
			break;

		default:
			break;
		}
	}

	private void addActivity(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("addactiivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateActivity(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("updateactiivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	private void viewActivity(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("viewactiivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
