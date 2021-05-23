package com.techllenapps.agendaapp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import com.techllenapps.agendaapp.entity.Activity;

public class ActivityOperationDao {

	//JDBC Driver name and database URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/agendaapp_db?useSSL=false";

	//Database credentials
	final String USER = "root";
	final String PASS = "@Mysql21";
	//connection objects
	Connection connection = null;
	PreparedStatement stmt=null;

	public int addActivity(Activity act) throws ClassNotFoundException {
		//local connection object
		int result=0;
		//getting parameters from object
		String enteredTittle = act.getTittle();
		String enteredDescription= act.getDescription();
		Date enteredStartDate = act.getStartDate();
		Date enteredEndDate = act.getEndDate();

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "INSERT INTO activities" +
					"  (tittle,description,start_date,end_date) VALUES " +
					" (?, ?, ?,?);";
			stmt= connection.prepareStatement(sqlq);
			
			//Bind values into the parameters
			stmt.setString(1,enteredTittle);
			stmt.setString(2,enteredDescription);
			java.sql.Date sqlStartDate = new java.sql.Date(enteredStartDate.getTime());
			stmt.setDate(3,sqlStartDate);
			java.sql.Date sqlEndDate = new java.sql.Date(enteredEndDate.getTime());
			stmt.setDate(4,sqlEndDate);

			//adding a user by running the query to update the table
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}

	public ArrayList<Activity> viewActivity(){
		//Local connection object
		ArrayList<Activity> activities = new ArrayList<Activity>();
		ResultSet rs = null;
		try {
			//registering JDBC Driver
			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "SELECT * FROM activities";
			stmt= connection.prepareStatement(sqlq);

			//selecting all records
			rs = stmt.executeQuery();
			
			//extracting data from resultset and bind them to the activity object
			//for display
			while(rs.next()){
				activities.add(new Activity(rs.getInt("id"),rs.getString("tittle"), rs.getString("description"), rs.getDate("start_date"),rs.getDate("End_date"),rs.getString("status")));
			}	

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// handles error for JDBC driver class
			e.printStackTrace();
		}
		return activities;

	}
	
	public int updateActivity(Activity act) throws ClassNotFoundException {
		//local connection object
		int result=0;
		//getting parameters from object
		int id = act.getId();
		String enteredTittle = act.getTittle();
		String enteredDescription= act.getDescription();
		Date enteredStartDate = act.getStartDate();
		Date enteredEndDate = act.getEndDate();
		String status = act.getStatus();

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			//selecting a specific activity basing on the id
			String sqlq= "UPDATE activities set tittle=?,description=?,start_date=?,end_date =?,status=? WHERE id=?;";
			stmt= connection.prepareStatement(sqlq);
			
			//Bind values into the parameters
			stmt.setString(1,enteredTittle);
			stmt.setString(2,enteredDescription);
			java.sql.Date sqlStartDate = new java.sql.Date(enteredStartDate.getTime());
			stmt.setDate(3,sqlStartDate);
			java.sql.Date sqlEndDate = new java.sql.Date(enteredEndDate.getTime());
			stmt.setDate(4,sqlEndDate);
			stmt.setString(5,status);
			stmt.setInt(6,id);

			//updating a user by running the query to update the table
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}
	
	public Activity selectActivityToDisplay(int id){
		//Local connection object
		int selectedID = id;
		ResultSet rs = null;
		Activity selectedActivity = new Activity();
		try {
			//registering JDBC Driver
			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "SELECT * FROM activities WHERE id=?;";
			stmt= connection.prepareStatement(sqlq);
			
			//Bind values into the parameters
			stmt.setInt(1,selectedID);

			//selecting all records
			rs = stmt.executeQuery();
			
			//extracting data from resultset and bind them to the activity object
			//for display
			while(rs.next()){
			 selectedActivity = new Activity(rs.getInt("id"),rs.getString("tittle"), rs.getString("description"), rs.getDate("start_date"),rs.getDate("End_date"),rs.getString("status"));
			}	

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// handles error for JDBC driver class
			e.printStackTrace();
		}
		return selectedActivity;

	}
	
	//this method is for testing
	public static void main(String[] args) {
		ActivityOperationDao act = new ActivityOperationDao();
		System.out.println(act.viewActivity());
	}
}



