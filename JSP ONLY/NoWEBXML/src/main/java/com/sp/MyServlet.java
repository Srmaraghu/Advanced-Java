package com.sp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/home")
public class MyServlet  extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		    
		Connection con = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/logindb";

		String user_db = "root";
		String pass_db = "root";
		String query ="Select * from users Where username =? and password = ?";
		

	 con =  DriverManager.getConnection(url,user_db,pass_db);
	stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		 rs = stmt.executeQuery();
		
		if (rs.next())
		{
			out.println("<h1>Login Succesful</h1>");
		}
		else {
			out.println("<h1>Login Failed</h1>");
			
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
        out.println("<h1>Error: " + e.getMessage() + "</h1>");
	}
	finally {
		try {
            // Close ResultSet if it was initialized
            if (rs != null) {
                rs.close();
            }
            // Close PreparedStatement if it was initialized
            if (stmt != null) {
                stmt.close();
            }
            // Close Connection if it was initialized
            if (con != null) {
                con.close();
            }

		}
		catch(SQLException e) {
			e.printStackTrace();
            out.println("<h1>Error closing resources: " + e.getMessage() + "</h1>");

			
		}
	}
	
	
	

		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

doPost(req,resp);
	}
	
}
