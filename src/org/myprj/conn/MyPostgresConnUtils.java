package org.myprj.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyPostgresConnUtils {
	public static Connection getPostgresConnection() throws ClassNotFoundException, SQLException {

		// Note: Change the connection parameters accordingly.
		String hostName = "localhost";
		String dbName = "postgres";
		String userName = "postgres";
		String password = "postgres";
		return getPostgresConnection(hostName, dbName, userName, password);
	}

	public static Connection getPostgresConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {

		// Declare the class Driver for DB
		// This is necessary with Java 5 (or older)
		// Java6 (or newer) automatically find the appropriate driver.
		// If you use Java> 5, then this line is not needed.
		Class.forName("org.postgresql.Driver");

		// URL Connection for MySQL
		// Example: jdbc:mysql://localhost:3306/simplehr
		String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

}
