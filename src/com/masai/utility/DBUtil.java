package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection provideConnection() {
		
	Connection conn = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("problem with Driver");
	}
	String cs = "jdbc:mysql://localhost:3306/faizan";
	
	try {
		conn = DriverManager.getConnection(cs, "root","masai@123#$");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	return conn;
		
		
		
	}
}
