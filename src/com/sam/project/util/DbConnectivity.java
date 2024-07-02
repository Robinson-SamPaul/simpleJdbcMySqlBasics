package com.sam.project.util;

import static com.sam.UseCase.PASSWORD;
import static com.sam.UseCase.URL;
import static com.sam.UseCase.USERNAME;
import static com.sam.UseCase.print;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbConnectivity {
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	private static Connection getConnection() throws SQLException {
		if (Objects.isNull(connection)) {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			/* Another way of creating connection */
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setURL(URL);
			dataSource.setUser(USERNAME);
			dataSource.setPassword(PASSWORD);
			print(dataSource.getConnection());
		}
		return connection;
	}
	
	private static Statement getStatement() throws SQLException {
		if (Objects.isNull(statement)) {
			statement = getConnection().createStatement();
		}
		return statement;
	}
	
	public static ResultSet getResultSet(String query) throws SQLException {
		return getStatement().executeQuery(query);
	}
	
	public static PreparedStatement getPreparedStatement(String query) throws SQLException {
		return getConnection().prepareStatement(query);
	}
}
