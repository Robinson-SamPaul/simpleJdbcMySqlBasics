package com.sam;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import static com.sam.UseCase.getJdbcRowSet;

public class AafIteratingOrMoving {

	public static void displayRow(String label, RowSet rowSet) throws SQLException {

		String name = rowSet.getString("name");
		int id = rowSet.getInt("id");

		String stdData = "\n%s:  %d, %s \n";
		System.out.format(stdData, label, id, name);
	}

	public static void main(String[] args) {

		try (JdbcRowSet jdbcRS = getJdbcRowSet()) {

			jdbcRS.setCommand("SELECT * FROM STUDENT");
			jdbcRS.execute();

			System.out.println("Moving around in a JdbcRowSet: \n");

			jdbcRS.first(); // points to first row
			displayRow("first()", jdbcRS);

			jdbcRS.relative(2); // move 2 rows front from current row
			displayRow("relative(2)", jdbcRS);

			jdbcRS.previous(); // move 1 row backward from current row
			displayRow("previous()", jdbcRS);

			jdbcRS.absolute(4); // points to 4th row
			displayRow("absolute(4)", jdbcRS);

            System.out.println("\nSleeping for a minute...");
            Thread.sleep(60000); // in the meantime, assume last value is updated

			jdbcRS.last(); // this will point to last row which isn't updated
            jdbcRS.refreshRow(); // this will refresh the row which is pointed currently
            displayRow("last()", jdbcRS);
            // let's say if the new row is added, then we gotta refresh before pointing to last(), 
            // then only pointer will be pointed to newly added one, and not old last one

            jdbcRS.relative(-1);
            displayRow("relative(-1)", jdbcRS);

        }
        catch (SQLException | InterruptedException ex) {
            ex.printStackTrace();
        }
	}
}