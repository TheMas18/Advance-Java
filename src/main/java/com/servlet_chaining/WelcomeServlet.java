package com.servlet_chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String uname=req.getParameter("un");
	 String pass=req.getParameter("pass");
	 PrintWriter out = resp.getWriter();
	 out.print("<html><body bgcolor='yellow'> <h1>Welcome to new Servlet </h1>"+"<br>"+"<h1>Username : "+uname +"password :"+pass+" </h1> </body></html>");
	
	
}
}
