package com.campus.connection;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static final String URL= "jdbc:mysql://localhost:3306/campus_lost_found";
private static final String USER = "root"; 
private static final String PASSWORD = "your_password";
  
public static Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
=======
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
	
>>>>>>> 66569371fffd0f570ed033abc99d2e26d9bc4bb7
}
