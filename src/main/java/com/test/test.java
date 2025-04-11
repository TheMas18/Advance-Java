package com.test;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Brand = req.getParameter("cb");
        String price = req.getParameter("cp");
        String qty = req.getParameter("cq");
        PrintWriter out = resp.getWriter();
        String fqcn = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/your_database_name?user=root&password=root";
        PreparedStatement pstmt = null;
        Connection con = null;

        try {
            Class.forName(fqcn);
            con = DriverManager.getConnection(url);

            String q = "insert into jspiders.chaidata values(?,?,?)";
            pstmt = con.prepareStatement(q);
            pstmt.setString(1, Brand);
            pstmt.setString(2, price);
            pstmt.setString(3, qty);

            pstmt.executeUpdate();

            out.print("<html><body bgcolor='yellow'> <h1> " + Brand + price + qty + " </h1> </body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
