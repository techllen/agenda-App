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
		Connection connection = null;
		PreparedStatement stmt=null;
		String enteredusername = user.getUsername();
		String enteredpassword = user.getPassword();

		try {
			//registering JDBC Driver

			Class.forName(JDBC_DRIVER);

			//opening a connection
			connection = DriverManager.getConnection(DB_URL,USER,PASS);

			//making a parameterized prepared statement and executing a query
			//String sqlq= "SELECT * FROM users WHERE username = ? and password = ?";
			String sqlq= "SELECT * FROM users WHERE username = ?;";

			stmt= connection.prepareStatement(sqlq);
            
			//Bind values into the parameters
			stmt.setString(1,"matare");
			//stmt.setString(2, "enteredpassword");
			
			//stmt.setString(1, "go");
			//stmt.setString(2, "go");

			//selecting the specific user
			ResultSet rs = stmt.executeQuery(sqlq);

			//extract data from resultset
			//status =rs.next();
			//System.out.println(enteredpassword + "  "+ enteredusername);
			while(rs.next()) {
				
				String retrievedusername = rs.getString("username");
				String retrievedpassword = rs.getString("password");
				
				System.out.println(retrievedusername +"    "+ retrievedpassword);
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

	public static void main(String[] args) {
		LoginDao login = new LoginDao();
		User us = new User("matare", "matare");
				login.validatelogin(us);
	}

}



