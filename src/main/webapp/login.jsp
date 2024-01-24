<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String cid = request.getParameter("id");
	String title = request.getParameter("nm");
	String desc = request.getParameter("rl");

	out.println(cid + "" + title + "" + desc);

	String fqcn = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306?user=root&password=root";
	PreparedStatement pstmt = null;
	Connection con = null;
	try {
		Class.forName(fqcn);
		con = DriverManager.getConnection(url);

		String qry = "insert into jspiders.course values(?,?,?)";
		pstmt = con.prepareStatement(qry);
		pstmt.setString(1, cid);
		pstmt.setString(2, title);
		pstmt.setString(3, desc);

		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>



</body>
</html>