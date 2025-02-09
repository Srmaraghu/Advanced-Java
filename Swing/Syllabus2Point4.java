import javax.swing.*;
import java.awt.event.*;

public class Syllabus2Point4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        // Check Box Menu Item
        JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem("Check Option");
        checkBoxItem.addActionListener(e -> System.out.println("Check Box Toggled: " + checkBoxItem.getState()));

        // Radio Button Menu Items
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("Option 1");
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        rb1.setSelected(true); // Default selection

        // Mnemonics and Accelerators
        newItem.setMnemonic(KeyEvent.VK_N); // Alt + N for "New"
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)); // Ctrl + E for Exit

        // Add menu items to File Menu
        fileMenu.add(newItem);
        fileMenu.addSeparator(); // Add a separator
        fileMenu.add(checkBoxItem);
        fileMenu.add(rb1);
        fileMenu.add(rb2);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add File Menu to Menu Bar
        menuBar.add(fileMenu);

        // Toolbar
        JToolBar toolBar = new JToolBar();
        JButton newButton = new JButton("New");
        JButton exitButton = new JButton("Exit");
        newButton.setToolTipText("Create a new file");
        exitButton.setToolTipText("Exit the application");
        exitButton.addActionListener(e -> System.exit(0));
        toolBar.add(newButton);
        toolBar.add(exitButton);

        // Pop-up Menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        popupMenu.add(cutItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        // Enable/Disable example
        cutItem.setEnabled(false); // Disabled initially

        // Add components to frame
        frame.setJMenuBar(menuBar);
        frame.add(toolBar, "North");
        JTextArea textArea = new JTextArea();
        textArea.setComponentPopupMenu(popupMenu); // Add popup menu to text area
        frame.add(new JScrollPane(textArea));

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
