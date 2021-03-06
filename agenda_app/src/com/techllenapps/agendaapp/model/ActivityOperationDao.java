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
	
		public int addActivity(Activity act,String userName) throws ClassNotFoundException {
		//local connection object
		int result=0;
		
		//getting parameters from object
		String retrievedUsername = userName;
		String enteredTittle = act.getTittle();
		String enteredDescription= act.getDescription();
		Date enteredStartDate = act.getStartDate();
		Date enteredEndDate = act.getEndDate();
		
		//setting the default status of the activity to beginning when added for the first 
		//time
		String defaultStatus = "beginning";

		try {
			//registering JDBC Driver
			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			//IGNORE keyword allows mySQL to discard duplicate and not to throw error
			//initially status of the activity will be set to beginning ad default
			String sqlq= "INSERT IGNORE INTO activities" +
					"  (tittle,description,start_date,end_date,status,username) VALUES " +
					" (?, ?, ?,?,?,?);";
			stmt= connection.prepareStatement(sqlq);

			//Bind values into the parameters
			stmt.setString(1,enteredTittle);
			stmt.setString(2,enteredDescription);
			java.sql.Date sqlStartDate = new java.sql.Date(enteredStartDate.getTime());
			stmt.setDate(3,sqlStartDate);
			java.sql.Date sqlEndDate = new java.sql.Date(enteredEndDate.getTime());
			stmt.setDate(4,sqlEndDate);
			
			//default status set,user will update status as days Go
			stmt.setString(5,defaultStatus);
			stmt.setString(6,retrievedUsername);

			//adding a user by running the query to update the table
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}
	//activities will be selected basing on a specific user on the session
	//by passing usrname to this method for selection
	public ArrayList<Activity> viewActivity(String userName){
		
		//Local connection object
		ArrayList<Activity> activities = new ArrayList<Activity>();
		String specificUserName = userName;
		ResultSet rs = null;
		try {
			
			//registering JDBC Driver
			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "SELECT * FROM activities WHERE username = ?";
			stmt= connection.prepareStatement(sqlq);
			stmt.setString(1, specificUserName);

			//selecting all recordsClass.forName(JDBC_DRIVER);
			//			Class.forName(driverClassName);
			rs = stmt.executeQuery();

			//extracting data from resultset and bind them to the activity object
			//for display
			while(rs.next()){
				activities.add(new Activity(rs.getInt("id"),rs.getString("tittle"), rs.getString("description"), rs.getDate("start_date"),rs.getDate("End_date"),rs.getString("status")));
			}	

		}catch(SQLException | ClassNotFoundException se){
			//Handle errors for JDBC
			se.printStackTrace();
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

			//updating a user by running the query to update the table returns the number of rows updated/affected
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

	public int deleteActivity(int id) throws ClassNotFoundException {
		//local connection object
		int result=0;
		
		//getting parameters from object
		int idToDelete = id;


		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			//selecting a specific activity to delete basing on the id
			String sqlq= "DELETE FROM activities WHERE id=?;";
			stmt= connection.prepareStatement(sqlq);

			//Bind values into the parameters
			stmt.setInt(1,idToDelete);

			//updating a user by running the query to update the table returns the number of rows affected
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}

	//this method is for testing
	public static void main(String[] args) {
		//ActivityOperationDao act = new ActivityOperationDao();
	}
}



