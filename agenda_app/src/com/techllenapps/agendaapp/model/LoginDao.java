package com.techllenapps.agendaapp.model;

import java.sql.*;

import com.techllenapps.agendaapp.entity.User;

public class LoginDao {

	//JDBC Driver name and database URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/agendaapp_db?useSSL=false";

	//Database credentials
	final String USER = "root";
	final String PASS = "@Mysql21";



	public boolean validatelogin(User user) {
		Connection connection = null;
		PreparedStatement stmt=null;
		String enteredusername = user.getUsername();
		String enteredpassword = user.getPassword();
		boolean status = true;

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a  prepared statement and executing a query
			String sqlq= "SELECT * FROM user  WHERE username = ? AND password = ?";

			stmt= connection.prepareStatement(sqlq);

			//Bind values into the parameters
			stmt.setString(1,enteredusername);
			stmt.setString(2,enteredpassword);

			//selecting the specific user
			ResultSet rs = stmt.executeQuery();

			//extract data from resultset
			while(rs.next()) {
				//Run the below code to see if the database is  working 
				//by retrieving the password and username from the databse
				/*
				String retrievedusername = rs.getString("username");
				String retrievedpassword = rs.getString("password");
				System.out.println(retrievedusername +"    "+ retrievedpassword);
				*/
				//use the .next method to see if only one row(unique) will be retrieved
				//the method .next returns true if we have more than one raw
				//and false if only one unique row has been retrieved
				status=rs.next();
			}
			//SClean-up environment
			rs.close();
			stmt.close();
			connection.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources

			try{
				if(connection!=null)
					connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return status;
	}
	//Run this code to test if the database is working
	/*public static void main(String[] args) {
		LoginDao login = new LoginDao();
		User us = new User();
		us.setUsername("matare");
		us.setPassword("matre");
		System.out.println(login.validatelogin(us));//status =rs.next();
	}*/
}



