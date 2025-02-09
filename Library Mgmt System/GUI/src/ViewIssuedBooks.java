import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import utility.DBConnection;

public class ViewIssuedBooks extends JFrame {

    // Table to display issued books
    private JTable issuedBooksTable;

    public ViewIssuedBooks() {
        // Set up the JFrame
        setTitle("View Issued Books");
        setSize(800, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Column Names for the JTable
        String[] columnNames = { "Book ID", "Student ID", "Student Name", "Contact", "Issue Date" };

        // Create the table model
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Initialize the JTable with the model
        issuedBooksTable = new JTable(tableModel);

        // Add the JTable to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(issuedBooksTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load data from the `issuebooks` table
        loadIssuedBooksData(tableModel);

        // Make the JFrame visible
        setVisible(true);
    }

    // Method to load issued books data from the database
    private void loadIssuedBooksData(DefaultTableModel tableModel) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM issuebooks";  // Query to fetch all issued books
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Clear any existing rows in the table
            tableModel.setRowCount(0);

            // Loop through the ResultSet and populate the table
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("studentname");
                String contact = rs.getString("student_contact");
                Date issueDate = rs.getDate("issueddate");

                // Add the row to the table model
                tableModel.addRow(new Object[]{bookId, studentId, studentName, contact, issueDate});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Driver method to test the ViewIssuedBooks class
    public static void main(String[] args) {
        new ViewIssuedBooks();
    }
}
