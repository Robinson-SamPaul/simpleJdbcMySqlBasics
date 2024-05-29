package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.sam.UseCase.*;

public class AabInsertQuery {

	public static void main(String[] args) throws Exception {	
		
		String query = "SELECT * FROM STUDENT";
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);		
		Statement statement = connection.createStatement();
		
		/*
		 * No need for resultSet, 
		 * just for understanding that it is being closed
		 * automatically while calling executeUpdate
		 * we r creating resultSet with statement object
		 * with the same statement object, we're doing executeUpdate
		 * so, it might close like that
		 */
		ResultSet resultSet = statement.executeQuery(query); 
		
		query = "INSERT into STUDENT (id, name) VALUES (12, 'Lyla')";
		
		print(resultSet);  // result set is open
		int count = statement.executeUpdate(query);  // result will be closed
		print(count);
		print(resultSet);
		
		close(connection, statement, resultSet);
	}
}
