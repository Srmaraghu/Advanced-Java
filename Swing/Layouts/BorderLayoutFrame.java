import java.awt.*;
import javax.swing.*;

public class BorderLayoutFrame extends JFrame {
    JPanel p1, p2, p3, p4, p5;

    BorderLayoutFrame() {
        setTitle("BorderLayout Example");

        // Set BorderLayout with horizontal and vertical gaps
        setLayout(new BorderLayout(12,1));

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

        // Adding panels into the BorderLayout
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
        add(p3, BorderLayout.EAST);
        add(p4, BorderLayout.WEST);
        add(p5, BorderLayout.CENTER);

    
        //  // Set preferred sizes for the panels
        //  p1.setPreferredSize(new Dimension(100, 50)); // NORTH panel height = 50
        //  p2.setPreferredSize(new Dimension(100, 50)); // SOUTH panel height = 50
        //  p3.setPreferredSize(new Dimension(75, 100)); // EAST panel width = 75
        //  p4.setPreferredSize(new Dimension(75, 100)); // WEST panel width = 75


         // CENTER panel size is determined by the frame size minus other panels
 


        // Frame settings
        setSize(600, 600);
        setLocation(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
      BorderLayoutFrame b = new BorderLayoutFrame();
    }
}
