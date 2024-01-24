package com.JDBC_Concepts;

import java.sql.*;
import java.util.Scanner;

public class PlatformCreation {
	public static void main(String[] args) {
		try {
//By using Statement
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518");
			Statement stmt = con.createStatement();

//			 stmt.executeUpdate("Insert into carwale.carinfo values(1,'BMW','xyz',10000)");
//			 stmt.executeUpdate("Insert into carwale.carinfo values(2,'ABC','xyz',20000)");
//			 stmt.executeUpdate("Insert into carwale.carinfo values(3,'PQR','xyz',30000)");
//			 stmt.executeUpdate("Update carwale.carinfo set car_name='Audi' , car_model='1969' WHERE cari_id=3");

//			 stmt.executeUpdate("Insert into carwale.carinfo values(4,'nexon','2001',5000)");
//			 stmt.executeUpdate("Insert into studentinformation.student values(5,'mas','pqr')");

//			stmt.executeUpdate("Delete from carwale.carinfo where cari_id=1");
//			stmt.executeUpdate("Delete from studentinformation.student where sid=3");

			Scanner sc = new Scanner(System.in);
			String cari_id = sc.nextLine();
			String car_name = sc.nextLine();
			String car_model = sc.nextLine();
			String car_price = sc.nextLine();

//			String str=
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
	}
}