package busproject;

import java.sql.*;



public class Database {
    private static final String url="jdbc:mysql://localhost:3306/busreserv";
	private static final String username="root";
	private static final String password="Tech@123";
	
	public static Connection getconnection() throws SQLException
	{
		return DriverManager.getConnection(url,username,password);
	}
}
