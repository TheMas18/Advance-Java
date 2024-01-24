package com.JDBC_Concepts;
import java.sql.*;
import java.util.Scanner;

public class TakeInputDB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//For Insert
//		int sid = sc.nextInt();
//		sc.nextLine();
//		String sname = sc.nextLine();
//		String saddress = sc.nextLine();
//		String qry = "insert into studentinformation.student values(?,?,?)";
		
		
		// For update
//		int sid = sc.nextInt();
//		sc.nextLine();
//		String sname = sc.nextLine();
//		String qry="Update studentinformation.student set sname=? where sid=?";
		
		
		String qry = "Delete from studentinformation.student where sid=?";
		int sid = sc.nextInt();
		
		
		String fqcn = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(fqcn);
			con = DriverManager.getConnection(url);

			pstmt = con.prepareStatement(qry);

			// insert
//			pstmt.setInt(1, sid);
//			pstmt.setString(2, sname);
//			pstmt.setString(3, saddress);
//			pstmt.executeUpdate();
//			System.out.println("Data Inserted");			
			
			//update
			
//			pstmt.setString(1, sname);
//			pstmt.setInt(2, sid);
//			pstmt.executeUpdate();
//			System.out.println("Data Updated");
			
			//delete

//			pstmt.setInt(1, sid);
//			pstmt.executeUpdate();
//			System.out.println("Data Deleted");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}