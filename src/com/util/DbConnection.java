package com.util;

import java.sql.*;

public class DbConnection {
	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/students";
		String userName = "root";
		String password = "root";
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if(con != null) {
				System.out.println("Connected.....");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		getConnection();
	}
}
