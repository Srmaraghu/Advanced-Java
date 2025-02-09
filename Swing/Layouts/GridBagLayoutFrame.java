package Layouts;

import javax.swing.*;

import java.awt.*;

public class GridBagLayoutFrame extends JFrame {

    // Declare buttons as class members
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public GridBagLayoutFrame() {
        // Initialize the buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

        // Set the layout of the frame to GridBagLayout
        setLayout(new GridBagLayout());

        // Create a GridBagConstraints object to control the layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Button 1 (Grid position 0, 0; spans 1 column)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Button 1 will stretch horizontally
        add(button1, gbc);

        // Add Button 2 (Grid position 1, 0; spans 2 columns)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Button 2 spans 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Button 2 stretches horizontally
        add(button2, gbc);

        // Add Button 3 (Grid position 0, 1; spans 1 row and 1 column)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;  // Button 3 spans 2 rows
        gbc.fill = GridBagConstraints.BOTH;  // Button 3 stretches both horizontally and vertically
        add(button3, gbc);

        // Add Button 4 (Grid position 1, 1; no span)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Button 4 stretches horizontally
        add(button4, gbc);

        // Add Button 5 (Grid position 2, 1; no span)
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Button 5 stretches horizontally
        add(button5, gbc);

        // Frame settings
        setTitle("GridBagLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  // Make the frame visible
    }

    public static void main(String[] args) {
        new GridBagLayoutFrame();  // Create an instance of the frame
    }
}
