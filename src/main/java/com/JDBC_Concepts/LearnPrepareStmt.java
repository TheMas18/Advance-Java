package com.JDBC_Concepts;
import java.sql.*;

public class LearnPrepareStmt {

	public static void main(String[] args) {

		// By using Prepare statement
		String qry = "";
		String fqcn = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
//		String qry="insert into studentinformation.student values (40,'xyz1','abcd')";
//		String qry="Update studentinformation.student set sname='vegito' where sid=40";
//		String qry = "Delete from studentinformation.student where sid=40";

		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();

			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.executeUpdate();
			System.out.println("Data Inserted");

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
	}
}