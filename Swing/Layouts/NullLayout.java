import java.awt.*;
import javax.swing.*;

public class NullLayout extends JFrame {
    JPanel p1, p2, p3, p4, p5;
    

    NullLayout () {
      setTitle("Raghu");

        // setLayout(null);

        setLayout(new CardLayout());

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

      
        

        //for null layout
        // p1.setBounds(400,100,30,40); //x coordinate, y coordinate, width, height
        // p2.setBounds(20,30,90,40);
        // p3.setBounds(40,40,30,40);
        // p4.setBounds(10,20,30,40);
        // p5.setBounds(80,80,30,40);

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
      NullLayout  fr = new NullLayout ();
  }
}

