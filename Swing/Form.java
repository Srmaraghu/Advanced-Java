
import java.awt.*;
import javax.swing.*;

public class Form extends JFrame {

    JPanel p1, p2;
    JLabel name = new JLabel("Name");
    JTextField tf = new JTextField();
    JRadioButton male = new JRadioButton("Female");
    JRadioButton female = new JRadioButton("Male");
    JButton b = new JButton("LogIn");
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenuItem newitem = new JMenuItem("New");
    

    Form() {
        setTitle("LogIn System");
        setVisible(true);
        setLocation(300, 200);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());

        p1 = new JPanel();
        p2 = new JPanel();
        p1.setBackground(Color.GREEN);
        p2.setBackground(Color.RED);
        p2.setLayout(null);
        p1.add(name);
        p1.add(tf);
        p1.add(female);
        p1.add(male);
        p1.add(b);
        p2.add(file);

        file.add(newitem);
        menubar.add(file);
        setJMenuBar(menubar);

        add(p1);
        add(p2);

    }

    public static void main(String[] args) {
        new Form();
    }

}
