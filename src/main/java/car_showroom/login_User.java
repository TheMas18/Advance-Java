package car_showroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login_User {
	static Scanner sc = new Scanner(System.in);
	static String fqcn = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	public static void login() {

		Scanner lg = new Scanner(System.in);
		try {

			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
			System.out.println("");
			System.out.print("");
			System.out.print("Enter Email     : ");
			String emails = lg.nextLine();
			System.out.print("Enter Password  : ");
			String u_password = lg.nextLine();
			if (emails.equals("admin") && u_password.equals("admin")) {

				admin.welcomeAdmin();
			} else {
				String query_login = "SELECT * FROM carshowroom.register where email=? and password=?";

				pstmt = con.prepareStatement(query_login);
				pstmt.setString(1, emails);
				pstmt.setString(2, u_password);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					System.out.println("\\____*-----Login Successful-----*____//");
					customer.showcars();

				} else {
					System.out.println("Invalid Details");
					login();
				}
			}

		} catch (Exception e) {
			System.out.println("Invalid Details");
			login();

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
			if (lg != null) {
				try {
					lg.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {
		login();
	}
}
