package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static com.sam.UseCase.*;

public class AacPrepareStatement {

	public static void main(String[] args) throws Exception {
		
		String query = "INSERT into STUDENT VALUES (?, ?)";
		int id = 15;
		String name = "Jhye";
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		print(connection);
		
		PreparedStatement statement = connection.prepareStatement(query);
		print(statement);

		statement.setInt(1, id); // first question mark
		statement.setString(2, name); // second question mark
		
		statement.executeUpdate();
		
		close(connection, statement, null);
	}
}
