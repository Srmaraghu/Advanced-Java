import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import utility.DBConnection;

public class ViewBooks {

    // Frame and Table
    JFrame f;
    JTable j;

    // Constructor
    public ViewBooks() {
        // Frame initialization
        f = new JFrame("View Books");

        // Data and Column Names
        String[] columnNames = { "ID", "Name", "Author", "Publisher", "Quantity", "Issued", "Added Date" };

        // Create the table model with column names and an empty data array
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Initializing the JTable with the model
        j = new JTable(tableModel);

        // Adding JTable to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        // Fetch and load book data from the database
        loadBooksData(tableModel);

        // Frame settings
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(600, 500);
        f.setLocation(300, 20);
        f.setVisible(true);
    }

    // Method to fetch book data from the database and populate the table
    private void loadBooksData(DefaultTableModel tableModel) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";  // Query to get all books
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Clear existing data from the table
            tableModel.setRowCount(0);

            // Populate the table with fetched data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int issued = rs.getInt("issued");  // assuming 'issued' is an integer (0 for not issued, 1 for issued)
                Date addedDate = rs.getDate("added_date");

                // Add a row to the table
                tableModel.addRow(new Object[]{id, name, author, publisher, quantity, issued, addedDate});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Driver method
    public static void main(String[] args) {
        new ViewBooks();
    }
}
