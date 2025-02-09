package EventListeners.MouseListenerExamplee;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerExample implements MouseListener {
   public MouseListenerExample() {
      // Set up the frame
      JFrame frame = new JFrame();

      frame.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 4));

      // Create a label and add the mouse listener
      JLabel label = new JLabel("Click here");
      label.addMouseListener(this);

      // Add the label to the frame
      frame.add(label);


      frame.setSize(500, 500);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // Implement MouseListener methods
   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("Mouse Clicked on the label");
   }

   @Override
   public void mousePressed(MouseEvent e) {
      System.out.println("Mouse Pressed");
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      System.out.println("Mouse Released");
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      System.out.println("Mouse Entered the label");
   }

   @Override
   public void mouseExited(MouseEvent e) {
      System.out.println("Mouse Exited the label");
   }

   public static void main(String[] args) {
      new MouseListenerExample();
   }
}
