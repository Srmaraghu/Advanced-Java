
import javax.swing.*;


import java.awt.*;


public class AdminDashboard extends JFrame {

    public AdminDashboard(String username) {

        
        // Set up the frame
        setTitle("Library Management System");
        
        setLayout(null);

       

        JLabel title = new JLabel("Admin Dashboard", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setOpaque(true);  // Makes the background visible
        title.setBackground(Color.decode("#667F9E"));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 600, 50);
        add(title);

        

        // Username, Date, and Time Panel
        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setBackground(Color.decode("#E5EACA"));
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBounds(10, 60, 580, 50);  // Position the panel below the title


        JLabel usernameLabel = new JLabel("Welcome: ");
        JLabel usernameValue = new JLabel(username); // Replace with dynamic username
        usernameValue.setForeground(Color.RED);

       

          // Add components to infoPanel
          infoPanel.add(usernameLabel);
          infoPanel.add(usernameValue);
  
          // Add infoPanel to the frame
          add(infoPanel);
       
        String[] buttonLabels = {"Add Librarian", "View Librarians", "Delete Librarian", "Log Out"};

        int yPosition = 120;  // Starting Y position for buttons

        for (String buttonLabel : buttonLabels) {
            JButton button = new JButton(buttonLabel);
            button.setBounds(100, yPosition, 200, 40);  // Positioning buttons
            button.addActionListener(e -> handleButtonClick(buttonLabel));
            add(button);
            yPosition += 50;  // Increment Y position for the next button
        }


       


       


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocation(310, 70);


        setVisible(true);
    }

    

    private void handleButtonClick(String buttonLabel) {
        // Handle button click actions
        switch (buttonLabel) {
            case "Add Librarian":
                new AddLibrarian();  // Open Add Book UI
                break;
            case "View Librarians":
                new ViewLibrarians();
                break;
            case "Delete Librarian":
                new DeleteLibrarian();
                break;
            case "Log Out":
                new Logout();
                break;
            // Add other cases for different buttons
        }
    }

    public static void main(String[] args) {
        new AdminDashboard("test");
    }
}
