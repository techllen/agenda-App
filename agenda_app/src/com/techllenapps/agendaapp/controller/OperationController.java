package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techllenapps.agendaapp.entity.Activity;
import com.techllenapps.agendaapp.model.ActivityOperationDao;

import javax.servlet.annotation.WebServlet;



/**
 * THE-Allen
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityOperationDao aact = new ActivityOperationDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//we are switching functions according to form names
		String activityForm = request.getParameter("form");
		activityForm = activityForm.toLowerCase();
		
		switch (activityForm) {
		case "addactivity":
			//getting parameters from the form
			String tittle = request.getParameter("tittle");
			String description = request.getParameter("description");
			//converting dates
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			//getting date parameters from the form
			String startDate = request.getParameter("startdate");
			String endDate = request.getParameter("enddate");
			//parsing
			Date startDatefmtd=null;
			Date endDatefmtd=null;
			try {
				startDatefmtd = formatter.parse(startDate);
				endDatefmtd= formatter.parse(endDate);

			} catch (ParseException e) {
				e.printStackTrace();
			}
					
			//setting parameters to the object using constructor
			Activity act = new Activity(tittle, description, startDatefmtd, endDatefmtd);
			
			//validating and adding activity
			//if the activity is added go back to the add activity page
			try {
				if (aact.addActivity(act)==1) {
					home(request, response);				}
				else {
					error(request,response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//addActivity(request,response);
			break;
				
		case "updateactivity":
			updateActivity(request,response);
			break;
			
		case "viewactivity":
			viewActivity(request,response);
			break;
			
		default:
			error(request,response);
			break;
		}
	}


	private void home(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("addactivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void viewActivity(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Activity> listedactivities = new ArrayList<Activity>();
		listedactivities = new ActivityOperationDao().viewActivity();
		request.setAttribute("listedactivities", listedactivities);
		
		try {
			request.getRequestDispatcher("viewactivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateActivity(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("updateactivity.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	
	

	private void error(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
