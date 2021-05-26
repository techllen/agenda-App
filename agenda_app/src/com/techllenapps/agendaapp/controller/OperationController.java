package com.techllenapps.agendaapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techllenapps.agendaapp.entity.Activity;
import com.techllenapps.agendaapp.model.ActivityOperationDao;



/**
 * THE-Allen
 */
@WebServlet("/")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityOperationDao aact = new ActivityOperationDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//we are switching functions according to form names
		String action = request.getServletPath();
		action = action.toLowerCase();

		switch (action) {
		case "/addactivity":
			addActivity(request,response);
			break;

		case "/addactivityform":
			addActivityForm(request,response);
			break;

		case "/updateactivity":
			updateActivity(request,response);
			break;

		case "/updateactivitypage":
			updateActivityPage(request,response);

		case "/update":
			update(request,response);

		case "/viewactivity":
			viewActivity(request,response);
			break;

		case "/delete":
			delete(request,response);

		case "/validatedate":
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
				if(endDatefmtd.compareTo(startDatefmtd)>0) {
					addActivityForm(request, response);
				}else {
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<body>");
					out.println("myFunction()");
					out.println("<script>");
					out.println("function myFunction() {");
					out.println(" alert("The end date is less than the start date")");

					out.println("</script>");

					out.println("</body>");
					out.println("</html>");
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}



	default:
		error(request,response);
		break;
	}
}

private void addActivity(HttpServletRequest request, HttpServletResponse response) {
	try {
		request.getRequestDispatcher("addactivity.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void addActivityForm(HttpServletRequest request, HttpServletResponse response) {
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

}

private void viewActivity(HttpServletRequest request, HttpServletResponse response) {

	ArrayList<Activity> listedactivities = new ArrayList<Activity>();
	listedactivities =new ActivityOperationDao().viewActivity();
	request.setAttribute("listedactivities", listedactivities);

	try {
		request.getRequestDispatcher("viewactivity.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void updateActivity(HttpServletRequest request, HttpServletResponse response) {
	//extracting data from database and display on update activity page using method viewActivity 
	//in activity operation dao
	ArrayList<Activity> listedactivities = new ArrayList<Activity>();
	listedactivities =new ActivityOperationDao().viewActivity();
	request.setAttribute("listedactivities", listedactivities);
	try {
		request.getRequestDispatcher("updateactivity.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void updateActivityPage(HttpServletRequest request, HttpServletResponse response) {
	int id = Integer.parseInt(request.getParameter("id"));
	Activity activityToDisplay= new Activity();
	activityToDisplay = new ActivityOperationDao().selectActivityToDisplay(id);	
	request.setAttribute("activityToDisplay", activityToDisplay);

	try {
		request.getRequestDispatcher("updateactivitypage.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}

}

private void update(HttpServletRequest request, HttpServletResponse response) {
	//getting parameters from the form
	int id = Integer.parseInt(request.getParameter("id"));
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
	String status = request.getParameter("status");

	//setting parameters to the object using constructor
	Activity updatedActivity = new Activity(id,tittle, description, startDatefmtd, endDatefmtd,status);

	//validating and adding activity
	//if the activity is added go back to the add activity page
	try {
		if (aact.updateActivity(updatedActivity)==1) {
			home(request, response);				}
		else {
			error(request,response);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void delete(HttpServletRequest request, HttpServletResponse response) {
	int id = Integer.parseInt(request.getParameter("id"));
	try {
		int deletedRows = new ActivityOperationDao().deleteActivity(id);

		if (deletedRows==1) {
			home(request, response);
		}else {
			error(request, response);
		}
	} catch (ClassNotFoundException e) {
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

private void home(HttpServletRequest request, HttpServletResponse response) {
	try {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

//this method is for testing
public static void main(String[] args) {
	ActivityOperationDao act = new ActivityOperationDao();
	System.out.println(act.viewActivity());
}

}
