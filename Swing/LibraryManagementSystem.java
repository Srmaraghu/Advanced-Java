import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibraryManagementSystem {
    private JFrame frame;
    private JPanel panel;
    private JLabel userLabel, passwordLabel, message;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton, signupButton;

    public static void main(String[] args) {
        LibraryManagementSystem gui = new LibraryManagementSystem();
        // gui.createLoginUI();
    }

    // Method to create the login/signup UI
    // public void createLoginUI() {
    //     frame = new JFrame("Library Management System");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(400, 200);

    //     panel = new JPanel();
    //     frame.add(panel);
    //     panel.setLayout(null);

    //     // User Label
    //     userLabel = new JLabel("Username:");
    //     userLabel.setBounds(10, 20, 80, 25);
    //     panel.add(userLabel);

    //     // Username Text Field
    //     userText = new JTextField(20);
    //     userText.setBounds(100, 20, 165, 25);
    //     panel.add(userText);

    //     // Password Label
    //     passwordLabel = new JLabel("Password:");
    //     passwordLabel.setBounds(10, 50, 80, 25);
    //     panel.add(passwordLabel);

    //     // Password Text Field
    //     passwordText = new JPasswordField(20);
    //     passwordText.setBounds(100, 50, 165, 25);
    //     panel.add(passwordText);

    //     // Login Button
    //     loginButton = new JButton("Login");
    //     loginButton.setBounds(10, 80, 80, 25);
    //     panel.add(loginButton);

    //     // Signup Button
    //     signupButton = new JButton("Sign Up");
    //     signupButton.setBounds(180, 80, 80, 25);
    //     panel.add(signupButton);

    //     // Message label for success/failure message
    //     message = new JLabel("");
    //     message.setBounds(10, 110, 300, 25);
    //     panel.add(message);

    //     // Action Listeners for buttons
    //     loginButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             String username = userText.getText();
    //             String password = String.valueOf(passwordText.getPassword());

    //             // Simulated authentication check
    //             if ("admin".equals(username) && "password".equals(password)) {
    //                 message.setText("Login successful!");
    //                 createDashboardUI();
    //             } else {
    //                 message.setText("Invalid credentials. Try again.");
    //             }
    //         }
    //     });

    //     signupButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             // Logic for signup process
    //             message.setText("Signup process...");
    //         }
    //     });

    //     frame.setVisible(true);
    // }

    // Dashboard UI after login
    public void createDashboardUI() {
        // frame.dispose(); // Close the login frame

        JFrame dashboardFrame = new JFrame("Library Dashboard");
        dashboardFrame.setSize(500, 400);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Library Dashboard!");
        dashboardPanel.add(welcomeLabel);

        // Add more components like menu, buttons, etc.
        JButton viewBooksButton = new JButton("View Books");
        dashboardPanel.add(viewBooksButton);

        JButton logoutButton = new JButton("Logout");
        dashboardPanel.add(logoutButton);

        dashboardFrame.add(dashboardPanel);
        dashboardFrame.setVisible(true);

        // Logout Action
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardFrame.dispose();
                // createLoginUI(); // Return to login screen after logout
            }
        });
    }
}
