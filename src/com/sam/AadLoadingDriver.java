package com.sam;

import java.sql.DriverManager;

import static com.sam.UseCase.print;

public class AadLoadingDriver {

	public static void main(String[] args) throws Exception {
		
		Class<?> clazz1 = Class.forName("com.mysql.jdbc.Driver");  // we have to provide qualified name
		print("\nDeprecated = " + clazz1);
		
		Class<?> clazz2 = Class.forName("com.mysql.cj.jdbc.Driver");
		print("Latest, still no need = " + clazz2);
		
		/*
		 * If u get into Driver class
		 * it'll have the exact below lines inside static block
		 * so to execute that, we can just simply load the class
		 * instead of writing below lines
		 * but anyway it's deprecated
		 */
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		/* Starting from JDBC 4.0, we don't need above lines */	
	}

}
