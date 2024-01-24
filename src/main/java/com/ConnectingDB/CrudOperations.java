package com.ConnectingDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperations {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		stmt = con.createStatement();
		//Insert 
//		String query="Insert into jspiders.course values(3,'ASP.net','Learn C#')";
//		stmt.execute(query);
		 
//		stmt.executeUpdate("Update studentinformation.student set sname='Mithilesh' WHERE sid=3");
//		String query = "Delete from studentinformation.student where sid=4";
//		stmt.executeUpdate(query);
//			rs=	stmt.executeQuery("SELECT * FROM jspiders.course");
//			while(rs.next()) {
//				String title=rs.getString("title");
//				System.out.println(title);
//			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			
			stmt.close();
			con.close();
			
			}
	}
}
