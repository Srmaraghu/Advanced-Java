package in.sp.backend;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Check if the user already exists
            String checkQuery = "SELECT email FROM users WHERE email = ?";
            checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, email);
            rs = checkStmt.executeQuery();

            if (rs.next()) {
                out.println("<h3>User already exists!</h3>");
                out.println("<a href='register.html'>Try Again</a>");
            } else {
                // Register the user
                String insertQuery = "INSERT INTO users (email, password,email) VALUES (?,?, ?)";
                insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, email);
                insertStmt.setString(2, password);
                insertStmt.setString(3, "AAA");


                int rows = insertStmt.executeUpdate();
                if (rows > 0) {
                    out.println("<h3>User registered successfully!</h3>");
                    out.println("<a href='login.html'>Go to Login</a>");
                } else {
                    out.println("<h3>Failed to register the user. Please try again.</h3>");
                    out.println("<a href='register.html'>Try Again</a>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (checkStmt != null) checkStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
