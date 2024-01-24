package car_showroom;

import java.sql.*;
import java.util.Scanner;

class LetsConnect {
	static Scanner sc = new Scanner(System.in);
	static String fqcn = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
	static Connection con = null;
	static PreparedStatement pstmt = null;

}

public class customer extends LetsConnect {

	static {
		System.out.println("");
		System.out.println("||__________//__(:----Welcome to Our Car Showroom----:)__\\__________||");
		System.out.println();
	}


	public static void showcars() {
		System.out.println("");
		System.out.println("||--------------\\\\___WELCOME TO OUR CAR SHOWROOM___////--------------||");
		System.out.println("");
		System.out.println("");
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from carshowroom.ourcars ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(" | " + rs.getString(1) + "  |  " + rs.getString(2) + "  |  " + rs.getString(3)
						+ "  |  " + rs.getString(4) + "  |  " + rs.getString(5) + " | ");
			}
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
		}

		System.out.println("");
		System.out.println("");
		System.out.println(
				"Nice to meet you Sir!... \n 0 : To Purchase the car \n 1 : To sell the car \n 2 : To See Upcomming Cars \n 3 : Exit");
		int n1 = sc.nextInt();

		switch (n1) {
		case 0: {
			purchase();
			break;
		}
		case 1: {
			sellCar();
			break;
		}
		case 2: {
			upcoming();
			break;
		}
		case 3: {
			welcome();
			break;
		}

		default:
			System.out.println("Please Try From Given Value");
			showcars();
		}

	}

	public static void purchase() {
		Scanner prc = new Scanner(System.in);
		System.out.print("");
		System.out.println("");

		System.out.print("Select Car Id : ");// 1
		String car_id = prc.nextLine().toLowerCase();

		System.out.println("");
		System.out.println("");
		System.out.println("Details Of the car that you have selected");
		System.out.println("");
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt_select = con.prepareStatement("select * from carshowroom.ourcars where carid=?");
			pstmt_select.setString(1, car_id);
			ResultSet rs = pstmt_select.executeQuery();
			while (rs.next()) {
				System.out.println("  |  " + rs.getString(2) + "  |  " + rs.getString(3) + "  |  " + rs.getString(4)
						+ " | " + rs.getString(5) + " | ");
			}
			System.out.println("");
			System.out.println("Do you want to purchase?  { Yes : 0   No : 1 }");
			System.out.println("");
			int confirm = prc.nextInt();

			if (confirm == 0) {

				PreparedStatement pstmt1 = con.prepareStatement("Delete from carshowroom.ourcars where carid=?");
				pstmt1.setString(1, car_id);
				pstmt1.executeUpdate();
				System.out.println("Congratulations!...Car Purchased Successfully");
				showcars();

			} else {
				showcars();
			}
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
			if (prc != null) {
				try {
					prc.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void sellCar() {
		Scanner sell = new Scanner(System.in);
		System.out.println("Enter Your Car Details :- ");
		System.out.print("");

		System.out.print("Enter Car id :- ");
		String car_id = sell.nextLine();

		System.out.print("Enter Car Name :- ");
		String carname = sell.nextLine();

		System.out.print("Enter Car Model :- ");
		String model = sell.nextLine();

		System.out.print("Enter Car Brand :- ");
		String brand = sell.nextLine();

		System.out.print("Enter Car Price :- ");
		String price = sell.nextLine();

		try {

			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
			String query_sell = "insert into carshowroom.ourcars values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query_sell);
			pstmt.setString(1, car_id);
			pstmt.setString(2, carname);
			pstmt.setString(3, model);
			pstmt.setString(4, brand);
			pstmt.setString(5, price);

			pstmt.executeUpdate();
			System.out.println();
			System.out.println("|||_______\\----__Car Sold Successfully__----//_______|||");
			System.out.println();
			showcars();

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
			if (sell != null) {
				try {
					sell.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void upcoming() {
		Scanner up = new Scanner(System.in);
		System.out.println("");
		System.out.println("||_______These are Our upcoming cars_______||");
		System.out.println("");
		System.out.println("");
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from carshowroom.upcomingcars");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(" | " + rs.getString(1) + "  |  " + rs.getString(2) + "  |  " + rs.getString(3)
						+ "  |  " + rs.getString(4) + "  |  ");
			}
			System.out.println("");
			System.out.println("Press 0 : Back , 1 : Exit");
			System.out.println();
			int pp = up.nextInt();
			switch (pp) {
			case 0: {
				showcars();
				break;
			}
			case 1:
				welcome();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + pp);
			}
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
			if (up != null) {
				try {
					up.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("");
		System.out.println("");

	}

	public static void welcome() {
		System.out.println("");
		System.out.println("");
		System.out.println("Enter { 0 : Register ,  1 : Login }");
		int no = sc.nextInt();
		switch (no) {// 0
		case 0: {
			Register_User.register();
			break;
		}
		case 1: {
			login_User.login();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + no);
		}
	}

	public static void main(String[] args) {
		welcome();

	}
}
