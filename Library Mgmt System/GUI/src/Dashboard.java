import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame {

    public Dashboard(String username) {
        // Set the title of the frame
        setTitle("Library Management System");
        setLayout(null); // Absolute layout

        // Header Label
        JLabel titleLabel = new JLabel("DASHBOARD", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setOpaque(true); // Allow background color
        titleLabel.setBackground(Color.decode("#667F9E")); // Set background color
        titleLabel.setForeground(Color.WHITE); // Set text color
        titleLabel.setBounds(0, 0, 600, 50); // Set position and size
        add(titleLabel);

        // Welcome Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setOpaque(false); // Transparent background
        welcomePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align content to the left
        welcomePanel.setBounds(10, 60, 580, 50); // Set position and size
        JLabel welcomeLabel = new JLabel("Welcome Librarian : ");
        String usernameCapital = username.toUpperCase();
        JLabel usernameLabel = new JLabel(usernameCapital); // Display the username
        usernameLabel.setForeground(Color.RED); // Highlight username in red
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(usernameLabel);
        add(welcomePanel);

        // Buttons
        String[] buttonLabels = {
            "Add Books", "View Books", "Issue Book",
            "View Issued Books", "Return Book", "Delete Book", "Log Out"
        };

        int yPosition = 120; // Starting Y position for buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBounds(50, yPosition, 200, 40); // Set button size and position
            button.addActionListener(e -> handleButtonClick(label)); // Handle button click
            add(button);
            yPosition += 50; // Increase Y position for the next button
        }

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 510); // Set frame size
        setLocation(310, 50); // Set frame location
        setVisible(true); // Make the frame visible
    }

    // Handle button clicks based on the label
    private void handleButtonClick(String label) {
        switch (label) {
            case "Add Books" -> new AddBook();
            case "View Books" -> new ViewBooks();
            case "Issue Book" -> new IssueBook();
            case "View Issued Books" -> new ViewIssuedBooks();
            case "Return Book" -> new ReturnBook();
            case "Delete Book" -> new DeleteBook();
            case "Log Out" -> {
                new Logout();
                dispose(); // Close the dashboard window
            }
            default -> System.out.println("Unknown action: " + label);
        }
    }

    // Main method for testing the Dashboard class
    public static void main(String[] args) {
        new Dashboard("test");
    }
}
