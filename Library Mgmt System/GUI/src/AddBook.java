import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utility.DBConnection;

public class AddBook extends JFrame {

    // Declare the input fields
    private JTextField nameField, authorField, publisherField, quantityField, issuedField;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    AddBook() {
        setTitle("Library Management System");

        setLayout(null);

        // Title Label
        JLabel title = new JLabel("Add Book", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setOpaque(true);  // Makes the background visible
        title.setBackground(Color.decode("#667F9E"));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 600, 50);
        add(title);

        // Book Name Label and Text Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 80, 300, 30);
        add(nameField);

        // Author Label and Text Field
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 120, 100, 30);
        add(authorLabel);
        authorField = new JTextField();
        authorField.setBounds(150, 120, 300, 30);
        add(authorField);

        // Publisher Label and Text Field
        JLabel publisherLabel = new JLabel("Publisher:");
        publisherLabel.setBounds(50, 160, 100, 30);
        add(publisherLabel);
        publisherField = new JTextField();
        publisherField.setBounds(150, 160, 300, 30);
        add(publisherField);

        // Quantity Label and Text Field
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 200, 100, 30);
        add(quantityLabel);
        quantityField = new JTextField();
        quantityField.setBounds(150, 200, 300, 30);
        add(quantityField);

        // Issued Label and Text Field (You can use a number or a boolean value)
        JLabel issuedLabel = new JLabel("Issued:");
        issuedLabel.setBounds(50, 240, 100, 30);
        add(issuedLabel);
        issuedField = new JTextField();
        issuedField.setBounds(150, 240, 300, 30);
        add(issuedField);

        

        // Add Book Button (to submit the data)
        JButton addButton = new JButton("Add Book");
        addButton.setBounds(200, 320, 150, 40);
        add(addButton);
        addButton.addActionListener(e -> addBookToDatabase());

        // Set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
        setSize(600, 400);
        setLocation(300, 0);
        setVisible(true);
    }

  // Method to add book data to the database
  private void addBookToDatabase() {
    String name = nameField.getText();
    String author = authorField.getText();
    String publisher = publisherField.getText();
    String quantityText = quantityField.getText();
    String issuedText = issuedField.getText(); 

    // Validate the input fields
    if (name.isEmpty() || author.isEmpty() || publisher.isEmpty() || quantityText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate and parse the quantity field
    int quantity = -1;
    try {
        quantity = Integer.parseInt(quantityText);
        if (quantity < 0) {
            throw new NumberFormatException("Quantity cannot be negative");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate and parse the issued field (default to 0 if empty)
    int issued = 0;
    if (!issuedText.isEmpty()) {
        try {
            issued = Integer.parseInt(issuedText);
            if (issued < 0) {
                JOptionPane.showMessageDialog(this, "Issued count cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid issued count. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Get the current date
    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

    // Insert into the database
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "INSERT INTO books (name, author, publisher, quantity, issued, added_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, author);
        stmt.setString(3, publisher);
        stmt.setInt(4, quantity);
        stmt.setInt(5, issued);  // Insert the 'issued' value
        stmt.setDate(6, currentDate);  // Set the current date for added_date field
        
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Book added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();  // Clear input fields after successful insertion
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add book.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Method to clear input fields after adding a book
    private void clearFields() {
        nameField.setText("");
        authorField.setText("");
        publisherField.setText("");
        quantityField.setText("");
        issuedField.setText("");
    }

    public static void main(String[] args) {
        new AddBook();
    }
}
