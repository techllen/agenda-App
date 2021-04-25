package com.agendaApp.model;

import java.sql.*;

import com.agendaApp.entity.User;

public class LoginDao {
	
	//JDBC Driver name and database URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/users_db?useSSL=false";

	//Database credentials
	final String USER = "root";
	final String PASS = "@Mysql21";
	
	boolean status = false;

	public boolean validatelogin(User user) {
		String enteredusername = user.getUsername();
		String enteredpassword = user.getPassword();
		
		Connection connection = null;

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a parameterized prepared statement
			String query = "select * from users where username = ? and password = ? ";
			//String query = "select * from users";

			
			PreparedStatement preparedStatement= connection.prepareStatement(query);

			preparedStatement.setString(1, enteredusername);
			preparedStatement.setString(2, enteredpassword);
			//Execute a query

			ResultSet rs = preparedStatement.executeQuery();

			//extract data from resultset
			status =rs.next();
			while(rs.next()) {
				System.out.println(rs.getString("username"));
			}

			//SClean-up environment
			System.out.println("matare");

			rs.close();
			preparedStatement.close();
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

	public static void main(String[] args) {
		LoginDao login = new LoginDao();
		User us = new User("matare21", "matare");
				login.validatelogin(us);
	}

}



