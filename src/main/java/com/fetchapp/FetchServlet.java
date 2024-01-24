package com.fetchapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FetchServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String id = req.getParameter("id");

	String fqcn = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306?user=root&password=root";
	PreparedStatement pstmt = null;
	Connection con = null;
	try {
		Class.forName(fqcn);
		con = DriverManager.getConnection(url);

		String qry = "SELECT * FROM jspiders.course where id=?";
		pstmt = con.prepareStatement(qry);

		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();

		PrintWriter out = res.getWriter();

		if (rs.next()) {
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
			out.print("<html><body bgcolor='yellow'> <h1>" + rs.getString(1) + rs.getString(2) + rs.getString(3)
					+ " </h1> </body></html>");
		} else {

			out.print("<html><body bgcolor='yellow'> <h1> Invalid Id </h1> </body></html>");
		}

		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		String id = req.getParameter("id");
//
//		String fqcn = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		try {
//			Class.forName(fqcn);
//			con = DriverManager.getConnection(url);
//
//			String qry = "select * from employee.fetchrec where id=?";
//			pstmt = con.prepareStatement(qry);
//
//			pstmt.setString(1, id);
//
//			ResultSet rs = pstmt.executeQuery();
//
//			PrintWriter out = res.getWriter();
//
//			if (rs.next()) {
//				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
//				out.print("<html><body bgcolor='yellow'> <h1>" + rs.getString(1) + rs.getString(2) + rs.getString(3)
//						+ " </h1> </body></html>");
//			} else {
//
//				out.print("<html><body bgcolor='yellow'> <h1> Invalid Id </h1> </body></html>");
//			}
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}

}
