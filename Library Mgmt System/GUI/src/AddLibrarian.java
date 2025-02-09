
import javax.swing.*;

import utility.DBConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddLibrarian extends JFrame {

    // Declare the input fields
    private final JTextField nameField, emailField, cityField, contactField;
    private final JPasswordField passwordField;

    AddLibrarian() {
        setTitle("Library Management System");

        setLayout(null);

        // Title Label
        JLabel title = new JLabel("Add Librarian", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setOpaque(true);  // Makes the background visible
        title.setBackground(Color.decode("#667F9E"));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 600, 50);
        add(title);

        // Name Label and Text Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 80, 300, 30);
        add(nameField);

        // Email Label and Text Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 120, 100, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(150, 120, 300, 30);
        add(emailField);

        // Password Label and Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 160, 100, 30);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 160, 300, 30);
        add(passwordField);

        // City Label and Text Field
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(50, 200, 100, 30);
        add(cityLabel);
        cityField = new JTextField();
        cityField.setBounds(150, 200, 300, 30);
        add(cityField);

        // Contact Number Label and Text Field
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(50, 240, 120, 30);
        add(contactLabel);
        contactField = new JTextField();
        contactField.setBounds(170, 240, 280, 30);
        add(contactField);

        // Add Librarian Button (for example, to submit the data)
        JButton addButton = new JButton("Add Librarian");
        addButton.setBounds(200, 300, 150, 40);
        add(addButton);
        addButton.addActionListener(e -> addLibrarianToDatabase());


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
          setSize(600, 400);
          setLocation(310, 70);
          setVisible(true);
    }

    // Method to add librarian data to the database
    private void addLibrarianToDatabase() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String city = cityField.getText();
        String contact = contactField.getText();

        // Validate the input fields
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || city.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert into the database
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO librarian (name, email, password, city, contact) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, city);
            stmt.setString(5, contact);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Librarian added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();  // Clear input fields after successful insertion
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add librarian.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields after adding a librarian
    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        cityField.setText("");
        contactField.setText("");
    }

    public static void main(String[] args) {
        new AddLibrarian();
    }
}
