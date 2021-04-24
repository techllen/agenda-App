package com.agendaApp.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao {

	public boolean validatemethod(Datasource datasource) {
		//1.Initialize connection objects
		List<User> listusers = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSET rs = null;

		try {
			connect = dataSource.getConnection();			
			//2: Create a SQL statements string
			String query = "Select * from users";
			stmt = connect.createStatement();
			//3: Execute SQL query
			rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				rs.getString("username")
				rs.getString("password")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}

