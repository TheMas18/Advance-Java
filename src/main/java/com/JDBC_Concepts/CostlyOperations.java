package com.JDBC_Concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CostlyOperations {
	public static void main(String[] args) {

		String qry = "";
		String fqcn = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
//		String qry="insert into studentinformation.student values (40,'xyz1','abcd')";
//		String qry="Update studentinformation.student set sname='vegito' where sid=40";
//		String qry = "Delete from studentinformation.student where sid=40";


		String qry1="insert into studentinformation.student values (1,'MAYURESH','Samant')";
		String qry2="Update studentinformation.student set sname='gogeta' where sid=2";
		String qry3 = "Delete from studentinformation.student where sid=101";

		Connection con = null;
//		PreparedStatement pstmt = null;
		try {
			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
//			pstmt = con.prepareStatement(qry);
//			pstmt.executeUpdate();
			
			Statement st=con.createStatement();
			st.addBatch(qry1);
			st.addBatch(qry2);
			st.addBatch(qry3);
			st.executeBatch();
			System.out.println("Operation Done");
//			System.out.println("Data Inserted");

		} catch (Exception e) {
			e.printStackTrace();

		}

//		finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}
}