package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.tools.javac.launcher.Main;

public class DbUtil {
	private static Connection connection = null;
private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	private static final String USERNAME = "system";
	
	private static final String PASSWORD = "12345";
	

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}

		else {
			try {
				
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			
			
		}
		return connection;
	}


}
	
}
