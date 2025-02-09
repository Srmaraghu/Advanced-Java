import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SumAndDifference extends JFrame {
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    public SumAndDifference() {
        // Set up the frame
        setTitle("Sum and Difference");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel num1Label = new JLabel("Enter Number 1:");
        num1Field = new JTextField();

        JLabel num2Label = new JLabel("Enter Number 2:");
        num2Field = new JTextField();

        JLabel resultTextLabel = new JLabel("Result:");
        resultLabel = new JLabel("0"); // Default result is 0

        // Add mouse listener to handle mouse press and release
        num1Field.addMouseListener(new MouseAdapterClass());
        num2Field.addMouseListener(new MouseAdapterClass());

        // Add components to the frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultTextLabel);
        add(resultLabel);
        add(new JLabel()); // Placeholder for spacing
        add(new JLabel()); // Placeholder for spacing

        // Make the frame visible
        setVisible(true);
    }

    // Custom MouseAdapter class to handle mouse events
    private class MouseAdapterClass extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            calculateSum(); // Calculate sum when mouse is pressed
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            calculateDifference(); // Calculate difference when mouse is released
        }
    }

    // Method to calculate and display the sum
    private void calculateSum() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double sum = num1 + num2;
            resultLabel.setText("Sum: " + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    // Method to calculate and display the difference
    private void calculateDifference() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double difference = num1 - num2;
            resultLabel.setText("Difference: " + difference);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new SumAndDifference();
    }
}
