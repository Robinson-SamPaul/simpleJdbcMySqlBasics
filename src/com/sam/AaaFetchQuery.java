package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.sam.UseCase.*;

public class AaaFetchQuery {

	public static void main(String[] args) throws Exception {
		
		// Sometimes, jar issue may come, just re-download the latest jar and try
		
		String query = "SELECT * FROM STUDENT";
		
		/* Establishing connection */
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		print(connection);
		
		/* Creating statement */
		Statement statement = connection.createStatement();
		print(statement);
		
		/* Executing query */
		ResultSet resultSet = statement.executeQuery(query);
		print(resultSet);

		/*
		 * next() will point next, it is for row
		 * and the numbers I specified below is for column
		*/
		print(resultSet.next() + " : " + resultSet.getInt(1) + " : " + resultSet.getString(2));
		print(resultSet.next() + " : " + resultSet.getInt("id") + " : " + resultSet.getString("name"));
		
		while(resultSet.next()) {
			print(resultSet.getInt(1) + " : " + resultSet.getString(2));
		}
		
		close(connection, statement, resultSet);
	}
}
