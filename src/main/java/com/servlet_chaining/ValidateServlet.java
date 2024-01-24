package com.servlet_chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	 String uname=req.getParameter("un");/
//	 String pass=req.getParameter("pass");
//	 resp.sendRedirect("http://www.youtube.com");
//	 if (uname.equals("mayuresh") && pass.equals("123")) {
//		RequestDispatcher rd=req.getRequestDispatcher("welcome");
//		rd.forward(req, resp);
//		
//	} else {
//		 PrintWriter out = resp.getWriter();
//		 out.print("<html><body bgcolor='yellow'> <h1>Invalid username and password </h1> </body></html>");
//		 RequestDispatcher rd=req.getRequestDispatcher("index.html");
//			rd.include(req, resp);
//	
//	}
	 
	
		
		
	
	}
}
