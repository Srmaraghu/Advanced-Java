 import java.awt.*;
import javax.swing.*;

public class FlowLayoutFrame extends JFrame {
    JPanel p1, p2, p3, p4, p5;

    FlowLayoutFrame() {
        setTitle("FlowLayout Example");

        // Set FlowLayout with leading alignment and horizontal and vertical gaps
        setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 20));

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

        // Set preferred sizes for panels
        // p1.setPreferredSize(new Dimension(100, 50));
        // p2.setPreferredSize(new Dimension(100, 50));
        // p3.setPreferredSize(new Dimension(100, 50));
        // p4.setPreferredSize(new Dimension(100, 50));
        // p5.setPreferredSize(new Dimension(100, 50));

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
        FlowLayoutFrame f= new FlowLayoutFrame();
    }
}
 
    
