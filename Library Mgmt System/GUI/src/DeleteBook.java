import javax.swing.*;
import utility.DBConnection;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBook extends JFrame {

    // Declare the components
    private JTextField idField;
    private JButton deleteButton;

    // Constructor
    public DeleteBook() {
        // Frame initialization
        setTitle("Delete Book");
        setLayout(null);

        // Label and Text Field for Book ID
        JLabel idLabel = new JLabel("Enter Book ID to Delete:");
        idLabel.setBounds(50, 80, 200, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(250, 80, 200, 30);
        add(idField);

        // Delete Button
        deleteButton = new JButton("Delete Book");
        deleteButton.setBounds(150, 150, 200, 40);
        add(deleteButton);

        // Action listener for the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBookAndRecords();
            }
        });

        // Frame settings
        setSize(500, 250);
        setLocation(500, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Method to delete book and associated records from the database
    private void deleteBookAndRecords() {
        String idStr = idField.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid book ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookId = Integer.parseInt(idStr); // Convert the input to an integer

        // SQL queries for cascading deletion
        String deleteIssuebooksSql = "DELETE FROM issuebooks WHERE book_id = ?";
        String deleteBookSql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            // Begin transaction
            conn.setAutoCommit(false);

            // Delete records from the issuebooks table
            try (PreparedStatement issuebooksStmt = conn.prepareStatement(deleteIssuebooksSql)) {
                issuebooksStmt.setInt(1, bookId);
                issuebooksStmt.executeUpdate();
            }

            // Delete the book from the books table
            try (PreparedStatement bookStmt = conn.prepareStatement(deleteBookSql)) {
                bookStmt.setInt(1, bookId);
                int rowsDeleted = bookStmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Book and associated records deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    conn.commit(); // Commit transaction
                    idField.setText(""); // Clear input field
                } else {
                    JOptionPane.showMessageDialog(this, "No book found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    conn.rollback(); // Rollback transaction
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Driver method
    public static void main(String[] args) {
        new DeleteBook();
    }
}
