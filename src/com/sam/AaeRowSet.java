package com.sam;

import javax.sql.rowset.JdbcRowSet;
import static com.sam.UseCase.getJdbcRowSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AaeRowSet {

	public static void main(String[] args) {

		try (JdbcRowSet jdbcRS = getJdbcRowSet()) {

			jdbcRS.setCommand("SELECT * FROM STUDENT");
			jdbcRS.execute();

			System.out.println("The properties of JdbcRowSet are: \n");

			System.out.println("Read-only? " + jdbcRS.isReadOnly());
			System.out.println("Auto-commit? : " + jdbcRS.getAutoCommit());
			System.out.println("Fetch direction: " + jdbcRS.getFetchDirection());
			System.out.println("Code for FETCH_FORWARD? " + ResultSet.FETCH_FORWARD);
			System.out.println("Code for FETCH_REVERSE? " + ResultSet.FETCH_REVERSE);
			System.out.println("Code for FETCH_UNKNOWN? " + ResultSet.FETCH_UNKNOWN);
			System.out.println("Command: " + jdbcRS.getCommand());

			System.out.println("\n-------------------");
			System.out.println("Metadata: \n" + jdbcRS.getMetaData());

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
