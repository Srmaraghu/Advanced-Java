import java.awt.*;
import javax.swing.*;

public class GridLayoutFrame extends JFrame {
    JPanel p1, p2, p3, p4, p5;

    GridLayoutFrame() {
        setTitle("GridLayout Example");

        setLayout(new GridLayout());

        // Initialize panels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        // Set background colors
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.GREEN);
        p4.setBackground(Color.YELLOW);
        p5.setBackground(Color.ORANGE);

        // Add panels to the frame
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        // Frame settings
        setSize(600, 600);
        setLocation(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutFrame();
    }
}
