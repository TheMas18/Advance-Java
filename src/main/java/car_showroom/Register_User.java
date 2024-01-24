package car_showroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register_User {
	static Scanner sc = new Scanner(System.in);
	static String fqcn = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
	static Connection con = null;
	static PreparedStatement pstmt = null;

	public static void register() {
		System.out.println("");
		System.out.println("||_____Create Your Account_____||");
		System.out.println("");
		Scanner regi = new Scanner(System.in);
		System.out.print("Enter First Name" + "       " + " : ");
		String f_name = regi.nextLine();
		System.out.print("Enter Last Name" + "        " + " : ");
		String l_name = regi.nextLine();
		System.out.print("Enter Phone Number" + "     " + " : ");
		String phoneno = regi.nextLine();
		System.out.print("Enter Address" + "          " + " : ");
		String address = regi.nextLine();
		System.out.print("Enter Email" + "            " + " : ");
		String email = regi.nextLine();
		System.out.print("Enter Password" + "         " + " : ");
		String u_password = regi.nextLine();
		System.out.print("Enter Confirm Password" + "  : ");
		String conf_password = regi.nextLine();
//		if (f_name.equals("")) {
//			System.err.print("please enter firstname");
//			register();
//		}
//		if (l_name.equals("")) {
//			System.err.print("please enter lastname");
//			register();
//		}
//		if (phoneno.equals("")) {
//			System.err.print("please enter username");
//			register();
//		}
//		if (address.equals("")) {
//			System.err.print("please enter password");
//			register();
//		}
//		if (email.equals("")) {
//			System.err.print("please confirm your password");
//			register();
//		}
//		if (u_password.equals("")) {
//			System.err.print("please confirm your password");
//			register();
//		}
//		if (conf_password.equals("")) {
//			System.err.print("please confirm your password");
//			register();
//		} else {

		try {
			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
			if (u_password.equals(conf_password)) {

				String query_register = "insert into carshowroom.register values(?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query_register);
				pstmt.setString(1, f_name);
				pstmt.setString(2, l_name);
				pstmt.setString(3, phoneno);
				pstmt.setString(4, address);
				pstmt.setString(5, email);
				pstmt.setString(6, u_password);
				pstmt.setString(7, conf_password);
				pstmt.executeUpdate();

				System.out.println();
				System.out.println("\\____*-----Registered Successfully-----*____//");
				System.out.println();
				login_User.login();
			} else {
				System.err.println("Password did not match");
				register();
			}
		} catch (Exception e) {
			System.err.println("Invalid Details");
			register();
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
			if (regi != null) {
				try {
					regi.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		register();
	}
}
