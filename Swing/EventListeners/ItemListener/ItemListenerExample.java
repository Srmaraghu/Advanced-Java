package EventListeners.ItemListener;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class ItemListenerExample implements ItemListener {

    public ItemListenerExample() {
        // Set up the frame
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.LEADING,3,2));

        // Create radio buttons and add item listener
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        radioButton1.addItemListener(this);
        radioButton2.addItemListener(this);

        // Create check box and add item listener
        JCheckBox checkBox = new JCheckBox("Check me");
        checkBox.addItemListener(this);

        // Create combo box and add item listener
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Item 1");
        comboBox.addItem("Item 2");
        comboBox.addItem("Item 3");
        comboBox.addItemListener(this);

        // Add components to frame
        JPanel panel = new JPanel();
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(checkBox);
        panel.add(comboBox);
        frame.add(panel);



        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    // Implement ItemListener methods
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (source instanceof JRadioButton) {
                System.out.println("Radio Button Selected: " + ((JRadioButton) source).getText());
            } else if (source instanceof JCheckBox) {
                System.out.println("Check Box Selected: " + ((JCheckBox) source).getText());
            } else if (source instanceof JComboBox) {
                System.out.println("Combo Box Selected: " + ((JComboBox<?>) source).getSelectedItem());
            }
        }
    }

    public static void main(String[] args) {
        new ItemListenerExample();
    }
}
