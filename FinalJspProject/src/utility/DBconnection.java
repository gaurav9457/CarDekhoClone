package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static Connection connection;
	
    public static Connection getConnection() throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			 connection =DriverManager.getConnection("jdbc:mysql://192.168.57.5:3306/gaurav","gaurav.p","E9fGhIjK");
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
		
		
	}
	

}
