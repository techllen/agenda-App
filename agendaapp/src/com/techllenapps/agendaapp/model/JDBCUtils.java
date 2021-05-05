package com.techllenapps.agendaapp.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {

	//JDBC Driver name and database URL
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	final static String DB_URL = "jdbc:mysql://localhost:3306/users_db?useSSL=false";

	//Database credentials
	final static String USER = "root";
	final static String PASS = "@Mysql21";

	

	public static Connection getConnection() {
		
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
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
        return connection;
    }
    public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
  