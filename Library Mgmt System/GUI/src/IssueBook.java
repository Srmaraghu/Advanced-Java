import javax.swing.*;
import java.awt.*;
import java.sql.*;
import utility.DBConnection;

public class IssueBook extends JFrame {

    // Declare the input fields
    private JTextField bookIdField, studentIdField, studentNameField, studentContactField;
    private JButton issueButton;
    private JLabel verifyNote;

    public IssueBook() {
        // Frame initialization
        setTitle("Issue Book");

        // Set Layout
        setLayout(null);

        // Title Label
        JLabel title = new JLabel("Issue Book", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setOpaque(true);
        title.setBackground(Color.decode("#667F9E"));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 600, 50);
        add(title);

        // Book ID Label and Text Field
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(50, 80, 100, 30);
        add(bookIdLabel);
        bookIdField = new JTextField();
        bookIdField.setBounds(150, 80, 300, 30);
        add(bookIdField);

        // Student ID Label and Text Field
        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(50, 120, 100, 30);
        add(studentIdLabel);
        studentIdField = new JTextField();
        studentIdField.setBounds(150, 120, 300, 30);
        add(studentIdField);

        // Student Name Label and Text Field
        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameLabel.setBounds(50, 160, 100, 30);
        add(studentNameLabel);
        studentNameField = new JTextField();
        studentNameField.setBounds(150, 160, 300, 30);
        add(studentNameField);

        // Student Contact Label and Text Field
        JLabel studentContactLabel = new JLabel("Student Contact:");
        studentContactLabel.setBounds(50, 200, 120, 30);
        add(studentContactLabel);
        studentContactField = new JTextField();
        studentContactField.setBounds(150, 200, 300, 30);
        add(studentContactField);

        // Warning note for verifying Student ID
        verifyNote = new JLabel("<html><font color='red'>** Verify Student ID before issuing book. **</font></html>");
        verifyNote.setBounds(150, 240, 300, 30);
        add(verifyNote);

        // Issue Book Button
        issueButton = new JButton("Issue Book");
        issueButton.setBounds(200, 280, 150, 40);
        add(issueButton);
        issueButton.addActionListener(e -> issueBookToStudent());

        // Frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocation(300, 0);
        setVisible(true);
    }

    // Method to issue the book
    private void issueBookToStudent() {
        String bookId = bookIdField.getText();
        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String studentContact = studentContactField.getText();

        // Validate the input fields
        if (bookId.isEmpty() || studentId.isEmpty() || studentName.isEmpty() || studentContact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update the books table: decrease quantity by 1 and increase books_issued by 1
        try (Connection conn = DBConnection.getConnection()) {
            // Check if the book is available
            String checkBookQuery = "SELECT quantity, issued FROM books WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkBookQuery);
            checkStmt.setInt(1, Integer.parseInt(bookId));
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                int booksIssued = rs.getInt("issued");

                // If the book is available (quantity > 0), issue the book
                if (quantity > 0) {
                    // Decrease quantity by 1 and increase books_issued by 1
                    String issueBookQuery = "UPDATE books SET quantity = ?, issued = ? WHERE id = ?";
                    PreparedStatement issueStmt = conn.prepareStatement(issueBookQuery);
                    issueStmt.setInt(1, quantity - 1);  // Decrease quantity
                    issueStmt.setInt(2, booksIssued + 1);  // Increase books_issued
                    issueStmt.setInt(3, Integer.parseInt(bookId));

                    int rowsUpdated = issueStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        // After updating books table, log the book issue in the issuebooks table
                        String logIssueQuery = "INSERT INTO   issuebooks (book_id, student_id, studentname, student_contact, issueddate) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement logStmt = conn.prepareStatement(logIssueQuery);
                        logStmt.setInt(1, Integer.parseInt(bookId));
                        logStmt.setInt(2, Integer.parseInt(studentId));
                        logStmt.setString(3, studentName);
                        logStmt.setString(4, studentContact);
                        logStmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));

                        int rowsLogged = logStmt.executeUpdate();
                        if (rowsLogged > 0) {
                            JOptionPane.showMessageDialog(this, "Book issued successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            clearFields();
                            new ViewBooks();
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to log the book issue.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The book is out of stock.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Book not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields after issuing a book
    private void clearFields() {
        bookIdField.setText("");
        studentIdField.setText("");
        studentNameField.setText("");
        studentContactField.setText("");
    }

    public static void main(String[] args) {
        new IssueBook();
    }
}
