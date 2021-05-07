package com.techllenapps.agendaapp.model;

import java.sql.*;

import com.techllenapps.agendaapp.entity.User;

public class RegisterDao {

	//JDBC Driver name and database URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/agendaapp_db?useSSL=false";

	//Database credentials
	final String USER = "root";
	final String PASS = "@Mysql21";



	public int regsiterUser(User user) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement stmt=null;
		int result=0;
		String enteredUsername = user.getUsername();
		String enteredPassword = user.getPassword();
		String enteredEmail = user.getEmail();


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
			stmt.setString(1,enteredEmail);
			stmt.setString(2,enteredUsername);
			stmt.setString(3,enteredPassword);

			//adding a user by running the query to update the table
			result = stmt.executeUpdate();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return result;

	}
}



