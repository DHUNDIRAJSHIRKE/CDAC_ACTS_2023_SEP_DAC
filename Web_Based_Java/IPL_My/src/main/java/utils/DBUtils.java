package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	// add a method to open n ret a FIXED db cn
	public static Connection openConnection() throws /* ClassNotFoundException, */ SQLException {
		// optional : load JDBC driver class
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dhundirajwebjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		System.out.println("Connection Formed!!");
		return cn;
	}
	// add a method to close DB connection
	public static void closeConnection() throws SQLException
	{
		if(cn != null)
			cn.close();
	}
	//add a getter for connection
	public static Connection getCn() {
		System.out.println(" Got the Connection ");
		return cn;
	}
	

}