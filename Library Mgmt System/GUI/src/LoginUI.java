import java.awt.*;
import java.io.File;
import java.sql.*;
import javax.swing.*;
import utility.DBConnection;

public class LoginUI extends JFrame {
    private final JTextField emailText;
    private final JPasswordField passText;
    private final JButton loginButton;
    private final JComboBox<String> roleCombo;  

    LoginUI() {
        setTitle("Library Management System");

        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 70, 600, 450);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        // Title JLabel with specific background color
        JLabel title = new JLabel("LOGIN", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.ITALIC, 24));
        title.setOpaque(true);  // Makes the background visible
        title.setBackground(Color.decode("#667F9E")); 
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 600, 50);
        add(title);

        // Placeholder for user image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(230, 10, 150, 150);
        

        File file = new File("D:\\. Code\\Java Programs\\LMS\\GUI\\Images\\loginDP.jpg");
        if (file.exists()) {
            ImageIcon loginIcon = new ImageIcon(file.getAbsolutePath());
            imageLabel.setIcon(loginIcon);
        } else {
            System.out.println("Image file not found at: " + file.getAbsolutePath());
        }
       
        panel.add(imageLabel);

        // Email label
        JLabel userLabel = new JLabel("Email : ");
        userLabel.setBounds(130, 180, 100, 25);
        panel.add(userLabel);

        // Email text field
        emailText = new JTextField();
        emailText.setBounds(240, 180, 150, 25);
        panel.add(emailText);

        // Password label
        JLabel passLabel = new JLabel("Password : ");
        passLabel.setBounds(130, 220, 100, 25);
        panel.add(passLabel);

        // Password field
        passText = new JPasswordField();
        passText.setBounds(240, 220, 150, 25);
        panel.add(passText);

        // Role label
        JLabel roleLabel = new JLabel("Role: ");
        roleLabel.setBounds(130, 260, 100, 25);
        panel.add(roleLabel);

        // Role combo box (no local declaration, using class-level variable)
        String[] roles = { "Admin","Librarian"};
        roleCombo = new JComboBox<>(roles);
        roleCombo.setBounds(240, 260, 150, 25);
        panel.add(roleCombo);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(240, 300, 100, 30);
        panel.add(loginButton);

        loginButton.addActionListener(e -> handleLogin());

        // // Register options
        // JLabel registerLabel = new JLabel("<html><u>Create an Account</u></html>", JLabel.CENTER); // Underlined text
        // registerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        // registerLabel.setForeground(Color.RED);
        // registerLabel.setBounds(270, 340, 180, 20);

        // registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // panel.add(registerLabel);

        // registerLabel.addMouseListener(new MouseAdapter() {
        //     public void mouseClicked(MouseEvent evt) {
        //         dispose();  // Close the current window
        //         new SignupUI();  // Open SignupUI.java (Make sure this class exists)
        //     }
        // });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 500);
        setLocation(310, 50);
        setVisible(true);
    }

    private void handleLogin() {
        String email = emailText.getText();
        String password = new String(passText.getPassword());
        String selectedRole = (String) roleCombo.getSelectedItem(); 

        if (email.isEmpty() || password.isEmpty() || selectedRole == null) {
            JOptionPane.showMessageDialog(this, "Please enter email, password, and select a role.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query;
        PreparedStatement stmt;


        try (Connection connection = DBConnection.getConnection()) {
            if ("Admin".equals(selectedRole)) {
                  
            

                query = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
                
             stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, selectedRole); 
            }
            else{
                 query = "SELECT * FROM librarian WHERE email = ? AND password = ?";
                 
          stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
    
            }


            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                String username = rs.getString("name");  // Fetch username from the database


                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Redirect to the main application window after successful login
                if ("Admin".equals(selectedRole)) {
                    dispose();
                    new AdminDashboard(username);
                }
                else if ("Librarian".equals(selectedRole)) {
                    dispose();
                    new Dashboard(username);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password or role.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
