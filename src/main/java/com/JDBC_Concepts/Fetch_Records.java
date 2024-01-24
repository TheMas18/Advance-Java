package com.JDBC_Concepts;

import java.sql.*;
import java.util.Formatter;
import java.util.Scanner;

public class Fetch_Records {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to fetch: ");
		int car_id=sc.nextInt();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518");

			
		
			PreparedStatement pstmt=con.prepareStatement("Delete from carshowroom.ourcars where carid=?");
			pstmt.setInt(1, car_id);
			pstmt.executeUpdate();
			System.out.println("Deleted");
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}

}