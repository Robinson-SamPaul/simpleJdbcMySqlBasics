package com.sam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class UseCase {

	public static final String URL = "jdbc:mysql://localhost:3306/simple_jdbc_concepts";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Root@2024";

	public static void print(Object obj) {
		System.out.println(obj);
		System.out.println();
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (Objects.nonNull(resultSet)) {
			resultSet.close();
		}
		statement.close();
		connection.close();
	}

	public static JdbcRowSet getJdbcRowSet() {
		JdbcRowSet jdbcRS = null;
		try {
			jdbcRS = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRS.setUrl(URL);
			jdbcRS.setUsername(USERNAME);
			jdbcRS.setPassword(PASSWORD);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return jdbcRS;
	}
}
