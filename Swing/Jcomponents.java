import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Jcomponents {

    public static void main(String[] args) {

        // Create the frame
        JFrame f = new JFrame();
        f.setTitle("JComponents");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridBagLayout());  // Use GridBagLayout for flexible layout

        // Create constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Add padding

        // Create a JTextField
        JLabel username = new JLabel("Username:");
        gbc.gridx = 0; // First column
        gbc.gridy = 0; // First row
        f.add(username, gbc);

        JTextField textField = new JTextField(15);
        textField.setToolTipText("Enter your username");
        gbc.gridx = 1; // Second column
        gbc.gridy = 0;
        f.add(textField, gbc);

        // Create a JPasswordField
        JLabel password = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        f.add(password, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        f.add(passwordField, gbc);

        // Create a JButton
        JButton button = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        f.add(button, gbc);

        // Create and add JRadioButtons
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        gbc.gridx = 0;
        gbc.gridy = 3;
        f.add(male, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        f.add(female, gbc);

        // Create and add JCheckBoxes
        JCheckBox music = new JCheckBox("Music");
        JCheckBox dance = new JCheckBox("Dance");
        gbc.gridx = 0;
        gbc.gridy = 4;
        f.add(music, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        f.add(dance, gbc);

        // Create two JLists with JScrollPane
        DefaultListModel<String> stringLM = new DefaultListModel<>();
        stringLM.addElement("Item 1");
        stringLM.addElement("Item 2");
        stringLM.addElement("Item 3");
        JList<String> stringList = new JList<>(stringLM);
        JScrollPane stringListScroll = new JScrollPane(stringList);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;

        f.add(stringListScroll, gbc);

        DefaultListModel<Integer> intLM = new DefaultListModel<>();
        intLM.addElement(10);
        intLM.addElement(20);
        intLM.addElement(30);
        JList<Integer> intList = new JList<>(intLM);
        JScrollPane intListScroll = new JScrollPane(intList);

        gbc.gridy = 6;
        f.add(intListScroll, gbc);

        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Exit the application
            }
        });
        file.add(openItem);
        file.add(saveItem);
        file.add(exitItem);
        menuBar.add(file);

        JMenu about = new JMenu("About");
        JMenuItem company = new JMenuItem("Company");
        JMenuItem system = new JMenuItem("System");
        about.add(company);
        about.add(system);
        menuBar.add(about);

        f.setJMenuBar(menuBar);

        // Create JTable with JScrollPane
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "John", 25},
                {2, "Alice", 30},
                {3, "Bob", 22}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 0; // Ensure starting at the correct column
        gbc.gridy = 7; // Row position
        gbc.gridwidth = 2; // Span across two columns
        gbc.gridheight = 2; // Span across two rows
        gbc.fill = GridBagConstraints.BOTH; // Allow table to grow both horizontally and vertically
        gbc.weightx = 1.0; // Allow it to expand horizontally
        gbc.weighty = 1.0; // Allow it to expand vertically

        f.add(scrollPane, gbc);
        // Create JComboBox
        String[] options = { "Option 1", "Option 2", "Option 3" };
        JComboBox<String> comboBox = new JComboBox<>(options);
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight=1;

        f.add(comboBox, gbc);

        // Add JSlider
        JLabel sliderLabel = new JLabel("Volume:");
        gbc.gridx = 0;
        gbc.gridy = 9;
        f.add(sliderLabel, gbc);

        JSlider volumeSlider = new JSlider(0, 100);
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        gbc.gridx = 1;
        f.add(volumeSlider, gbc);

        // Set the frame to be visible
        f.setVisible(true);
    }
}
