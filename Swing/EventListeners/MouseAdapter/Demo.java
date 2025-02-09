package EventListeners.MouseAdapter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;


public class Demo extends MouseAdapter {

    Demo(){
        JFrame frame = new JFrame();

      frame.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 4));


      // Create a label and add the mouse adapter
      JLabel label = new JLabel("Click here");
      label.addMouseListener(this);

      // Add the label to the frame
      frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);


    }

     // Only implement the methods that are needed
   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("Mouse Clicked on the label");
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      System.out.println("Mouse Entered the label");
   }

   public static void main(String[] args) {
    new Demo();
   }

    
}
