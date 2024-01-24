package com.servlet_chaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/form",loadOnStartup=8)
public class FormServlet extends GenericServlet {

	public FormServlet() {
		System.out.println("Servlet object is created");
	}
	
	public void init(ServletConfig config)throws ServletException{
		System.out.println("servlet obj is initialized");
	}
	
	
	@Override
	public void service(ServletRequest request, ServletResponse rep) throws ServletException, IOException {

		System.out.println("service() is called");
		
//		String name = request.getParameter("nm");
//		String place = request.getParameter("pl");
//		// System.out.println(name + " "+ place);
//
//		// geteWriter()-----> ServerletResponse
//		// ref ---> PrinterWriter
//		PrintWriter out = rep.getWriter();
//
//		out.print("<html><body bgcolor='yellow'> <h1> User Details :-->" + name + " " + "from" + " " + place
//				+ " </h1> </body></html>");
//
//		String fqcn = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306?user=root&password=Mayuresh@4518";
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		try {
//			Class.forName(fqcn);
//			con = DriverManager.getConnection(url);
//
//			String q = "insert into employee.formdetails values(?,?)";
//			pstmt = con.prepareStatement(q);
//			pstmt.setString(1, name);
//			pstmt.setString(2, place);
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
//		out.print("Data Inserted");
		
		
	}
	@Override
	public void destroy() {
		System.out.println("closed all the costly operation");
	}
}
