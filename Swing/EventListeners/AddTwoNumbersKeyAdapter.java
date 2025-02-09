import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddTwoNumbersKeyAdapter extends KeyAdapter {
private JTextField num1Field, num2Field, resultField;
    public AddTwoNumbersKeyAdapter() {
        // Set up the frame
        JFrame frame = new JFrame();
        frame.setTitle("Add Two Numbers");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        
        // Create components
        JLabel num1Label = new JLabel("Enter Number 1:");
         num1Field = new JTextField();

        JLabel num2Label = new JLabel("Enter Number 2:");
         num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
         resultField = new JTextField();
        resultField.setEditable(false); // Make result field read-only
        resultField.addKeyListener(this);

     
        // Add components to the frame
        frame.add(num1Label);
       frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(resultLabel);
        frame.add(resultField);
       
        // Make the frame visible
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e){
        try {
            // Parse numbers from the text fields
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            // Perform addition and display the result
            double result = num1 + num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            // If input is invalid or empty, clear the result field
            resultField.setText("");
        }



    }

    // Method to calculate and display the result
    

    public static void main(String[] args) {
        new AddTwoNumbersKeyAdapter();
    }
}
