package com.sam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class UseCase {
	
	public static final String URL = "jdbc:mysql://localhost:3306/simple_jdbc_concepts";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Root@2024";
	
	public static void print(Object obj) {
		System.out.println(obj);
		System.out.println();
	}
	
	public static void close(Connection connection, 
			Statement statement, ResultSet resultSet) throws SQLException {	
		if(Objects.nonNull(resultSet)) {
			resultSet.close();
		}
		statement.close();
		connection.close();
	}
}
