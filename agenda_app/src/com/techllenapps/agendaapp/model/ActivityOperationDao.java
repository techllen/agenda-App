package com.techllenapps.agendaapp.model;

import java.sql.*;
import java.util.Date;

import com.techllenapps.agendaapp.entity.Activity;
import com.techllenapps.agendaapp.entity.User;

public class ActivityOperationDao {

	//JDBC Driver name and database URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/agendaapp_db?useSSL=false";

	//Database credentials
	final String USER = "root";
	final String PASS = "@Mysql21";



	public int addActivity(Activity act) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement stmt=null;
		int result=0;
		String enteredTittle = act.getTittle();
		String enteredDescription= act.getDescription();
		String enteredStatus = act.getStatus();
		Date enteredStartDate = act.getStartDate();
		Date enteredEndDate = act.getEndDate();

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "INSERT INTO user" +
					"  (email,username,password) VALUES " +
					" (?, ?, ?);";
			stmt= connection.prepareStatement(sqlq);

			//Bind values into the parameters
			stmt.setString(1,enteredTittle);
			stmt.setString(2,enteredDescription);
			stmt.setDate(3,enteredEndDate);
			stmt.setString(4,enteredStatus);
			stmt.setDate(5,java.sql.Timestamp(enteredStartDate));

			
			//adding a user by running the query to update the table
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}
}



