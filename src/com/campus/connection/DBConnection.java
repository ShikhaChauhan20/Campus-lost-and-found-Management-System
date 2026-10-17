package com.campus.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class DBConnection {
	private static final String URL="jbdc.mysql://localhost:3306/campus_lost_found";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(URL,USER,PASSWORD);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		}
	
}
