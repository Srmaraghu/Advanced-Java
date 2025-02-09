
import javax.swing.*;

import utility.DBConnection;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLibrarian extends JFrame {

    // Declare the components
    private JTextField idField;
    private JButton deleteButton;

    // Constructor
    public DeleteLibrarian() {
        // Frame initialization
        setTitle("Delete Librarian");

        setLayout(null);

        // Label and Text Field for Librarian ID
        JLabel idLabel = new JLabel("Enter Librarian ID to Delete:");
        idLabel.setBounds(50, 80, 200, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(250, 80, 200, 30);
        add(idField);

        // Delete Button
        deleteButton = new JButton("Delete Librarian");
        deleteButton.setBounds(150, 150, 200, 40);
        add(deleteButton);

        // Action listener for the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLibrarianById(); // Call method to delete librarian
            }
        });

        // Frame settings
        setSize(500, 250);
        setLocation(330, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    }

    // Method to delete librarian from the database by ID
    private void deleteLibrarianById() {
        String idStr = idField.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid librarian ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(idStr); // Convert the input to an integer

        
        // SQL Query to delete a librarian by ID
        String sql = "DELETE FROM librarian WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Librarian deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                idField.setText(""); // Clear input field
            } else {
                JOptionPane.showMessageDialog(this, "No librarian found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Driver method
    public static void main(String[] args) {
        new DeleteLibrarian();
    }
}
