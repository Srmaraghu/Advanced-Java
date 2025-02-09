import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SumAndDifference extends MouseAdapter {
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    public SumAndDifference() {
        JFrame f = new JFrame();
        // Set up the frame
        f.setTitle("Sum and Difference");
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel num1Label = new JLabel("Enter Number 1:");
        num1Field = new JTextField();

        JLabel num2Label = new JLabel("Enter Number 2:");
        num2Field = new JTextField();

        JLabel resultTextLabel = new JLabel("Result:");
        resultLabel = new JLabel("0"); // Default result is 0

        // Add mouse listener to handle mouse press and release
        num1Field.addMouseListener(this);
        num2Field.addMouseListener(this);

        // Add components to the frame
        f.add(num1Label);
        f.add(num1Field);
        f.add(num2Label);
        f.add(num2Field);
        f.add(resultTextLabel);
        f.add(resultLabel);
       

        // Make the frame visible
        f.setVisible(true);
    }

    // Custom MouseAdapter class to handle mouse events
        @Override
        public void mousePressed(MouseEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double sum = num1 + num2;
                resultLabel.setText("Sum: " + sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }        }

        @Override
        public void mouseReleased(MouseEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double difference = num1 - num2;
                resultLabel.setText("Difference: " + String.valueOf(difference));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }        }
    

    // Method to calculate and display the sum
  
    public static void main(String[] args) {
        new SumAndDifference();
    }
}
