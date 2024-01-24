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

/*
 * public class cars { public static void main(String[] args) { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con = DriverManager
 * .getConnection("jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518"
 * );
 * 
 * //By using statement Statement stmt = con.createStatement();
 * 
 * //
 * stmt.executeUpdate("Insert into carwale.carinfo values(1,'BMW','xyz',10000)"
 * ); //
 * stmt.executeUpdate("Insert into carwale.carinfo values(2,'ABC','xyz',20000)"
 * ); //
 * stmt.executeUpdate("Insert into carwale.carinfo values(3,'PQR','xyz',30000)"
 * ); // stmt.
 * executeUpdate("Update carwale.carinfo set car_name='Audi' , car_model='1969' WHERE cari_id=3"
 * );
 * 
 * // stmt.
 * executeUpdate("Insert into carwale.carinfo values(4,'nexon','2001',5000)");
 * // stmt.
 * executeUpdate("Insert into studentinformation.student values(5,'mas','pqr')"
 * );
 * 
 * // stmt.executeUpdate("Delete from carwale.carinfo where cari_id=1"); //
 * stmt.executeUpdate("Delete from studentinformation.student where sid=3");
 * 
 * } catch (Exception e) { // e.printStackTrace(); System.out.println(e); } } }
 * 
 */
