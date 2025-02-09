package Layouts;

import javax.swing.*;
import java.awt.*;

public class GroupLayoutExample extends JFrame {

    // Declare buttons as class members
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public GroupLayoutExample() {
        // Initialize the buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");

        // Create the layout and set it to the frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // Automatically create gaps between components
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Define the horizontal layout: a sequential group with button1, button2, button3
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(button1)  // Button 1 comes first
                        .addComponent(button2)  // Button 2 comes next
                        .addComponent(button3)  // Button 3 comes last
        );

        // Define the vertical layout: a parallel group so all buttons are aligned vertically
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button1)  // Button 1
                        .addComponent(button2)  // Button 2
                        .addComponent(button3)  // Button 3
        );

        // Frame settings
        setTitle("GroupLayout Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GroupLayoutExample();  // Create an instance of the frame
    }
}
