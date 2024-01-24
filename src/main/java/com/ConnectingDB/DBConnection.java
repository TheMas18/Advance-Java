package com.ConnectingDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded And Registered!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established");

			stmt = con.createStatement();
			
			System.out.println("Platform Created");
		
			rs=	stmt.executeQuery("SELECT * FROM jspiders.course");
			while(rs.next()) {
				String title=rs.getString("title");
				System.out.println(title);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			
			stmt.close();
			con.close();
			
			}
	}
}
