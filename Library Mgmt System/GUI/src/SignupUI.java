import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import utility.DBConnection;

public class SignupUI extends JFrame {
    private  final JTextField nameText;
    private  final JTextField emailText;
    private  final JPasswordField passText;
    private final JRadioButton male;
    private  final JRadioButton female;
    private  final JComboBox<String> roleCombo;
    private final  JCheckBox termsCheck;

    public SignupUI() {
        this.setTitle("Library Management System");
        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 70, 600, 550);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Register", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.decode("#667F9E"));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 0, 600, 50);
        this.add(titleLabel);

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(230, 20, 150, 150);
File file = new File("D:\\. Code\\Java Programs\\LMS\\GUI\\Images\\signupDP.jpg");
        if (file.exists()) {
            ImageIcon loginIcon = new ImageIcon(file.getAbsolutePath());
            imageLabel.setIcon(loginIcon);
        } else {
            System.out.println("Image file not found at: " + file.getAbsolutePath());
        }        panel.add(imageLabel);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(130, 170, 100, 25);
        panel.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(240, 170, 150, 25);
        panel.add(nameText);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(130, 210, 100, 25);
        panel.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(240, 210, 150, 25);
        panel.add(emailText);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(130, 250, 100, 25);
        panel.add(passwordLabel);

        passText = new JPasswordField();
        passText.setBounds(240, 250, 150, 25);
        panel.add(passText);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(130, 290, 100, 25);
        panel.add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(240, 290, 60, 25);
        male.setBackground(Color.WHITE);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 290, 90, 25);
        female.setBackground(Color.WHITE);
        panel.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel roleLabel = new JLabel("Role: ");
        roleLabel.setBounds(130, 330, 100, 25);
        panel.add(roleLabel);

        String[] roles = {"Admin", "Librarian"};
        roleCombo = new JComboBox<>(roles);
        roleCombo.setBounds(240, 330, 150, 25);
        panel.add(roleCombo);

        termsCheck = new JCheckBox("I agree to the Terms and Conditions.");
        termsCheck.setBackground(Color.WHITE);
        termsCheck.setBounds(130, 380, 300, 25);
        panel.add(termsCheck);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(240, 420, 100, 30);
        panel.add(signUpButton);
        signUpButton.addActionListener(e -> handleSignUp());

        JLabel loginLabel = new JLabel("<html><u>Have an Account? Login Here</u></html>", JLabel.CENTER);
        loginLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        loginLabel.setForeground(Color.RED);
        loginLabel.setBounds(270, 460, 180, 20);
        loginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(loginLabel);
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // Close the signup window (optional)
                
                new LoginUI();
            }
        });

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(580, 600);
        this.setLocation(300, 0);
        this.setVisible(true);
    }
   
    private void handleSignUp() {
        String name = nameText.getText();
        String email = emailText.getText();
        String password = new String(passText.getPassword());
        String gender = male.isSelected() ? "Male" : "Female";
        String role = (String) roleCombo.getSelectedItem();

        if (!termsCheck.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please agree to the Terms and Conditions.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try (Connection connection = DBConnection.getConnection()) {
                String query = "INSERT INTO users (name, email, password, gender, role) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, gender);
                preparedStatement.setString(5, role);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new SignupUI();
    }
}
