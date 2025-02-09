import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBConnection;

public class ReturnBook extends JFrame {

    // Input fields
    private JTextField bookIdField, studentIdField;

    public ReturnBook() {
        setTitle("Return Book");
        setSize(400, 300);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Return Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(0, 20, 400, 30);
        add(titleLabel);

        // Book ID label and field
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(50, 80, 100, 30);
        add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(150, 80, 200, 30);
        add(bookIdField);

        // Student ID label and field
        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(50, 130, 100, 30);
        add(studentIdLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(150, 130, 200, 30);
        add(studentIdField);

        // Return button
        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(130, 200, 150, 40);
        add(returnButton);

        // Action listener for the Return button
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });

        setVisible(true);
    }

    // Method to handle book return
    private void returnBook() {
        String bookId = bookIdField.getText();
        String studentId = studentIdField.getText();

        // Validate inputs
        if (bookId.isEmpty() || studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Book ID and Student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // Query to check if the record exists
            String checkSql = "SELECT * FROM issuebooks WHERE book_id = ? AND student_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, bookId);
            checkStmt.setString(2, studentId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Record exists, proceed to delete
                String deleteSql = "DELETE FROM issuebooks WHERE book_id = ? AND student_id = ?";
                PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
                deleteStmt.setString(1, bookId);
                deleteStmt.setString(2, studentId);

                int rowsDeleted = deleteStmt.executeUpdate();
                if (rowsDeleted > 0) {
                    // Update book quantity and issued count
                    String updateSql = "UPDATE books SET quantity = quantity + 1, issued = issued - 1 WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setString(1, bookId);
                    updateStmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Book returned successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to return book.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // No matching record found
                JOptionPane.showMessageDialog(this, "No record found for the provided Book ID and Student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields after successful return
    private void clearFields() {
        bookIdField.setText("");
        studentIdField.setText("");
    }

    public static void main(String[] args) {
        new ReturnBook();
    }
}
