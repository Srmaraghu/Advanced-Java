
import javax.swing.*;



import java.awt.event.*;

public class Logout extends JFrame {

    // Constructor
    public Logout() {
        // Set up the frame for the logout confirmation
        setTitle("Logout");
        setLayout(null);

        // Label to ask for logout confirmation
        JLabel label = new JLabel("Are you sure you want to logout?", JLabel.CENTER);
        label.setBounds(50, 50, 300, 30);
        add(label);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 120, 100, 30);
        add(logoutButton);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(210, 120, 100, 30);
        add(cancelButton);

        // Action listener for the logout button
        logoutButton.addActionListener(e -> logoutUser());

        // Action listener for the cancel button (to return to the previous screen)
        cancelButton.addActionListener(e -> cancelLogout());

        // Frame settings
        setSize(400, 200);
        setLocation(500, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    }


    private void logoutUser() {
       
        // Show a confirmation message
        JOptionPane.showMessageDialog(this, "You have logged out successfully.", "Logout Successful", JOptionPane.INFORMATION_MESSAGE);

        // Close the current window and go back to the login screen
        this.dispose();  // Close the current frame

        // Open the login screen again (assuming you have a Login class)
        new LoginUI(); 
    }

    // Method to cancel the logout action
    private void cancelLogout() {
        // Simply close the logout confirmation window without logging out
        this.dispose();
    }

    // Driver method to test the logout functionality
    public static void main(String[] args) {
        new Logout();
    }
}
