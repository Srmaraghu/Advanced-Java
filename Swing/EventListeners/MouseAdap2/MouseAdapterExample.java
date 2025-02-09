package EventListeners.MouseAdap2;
//here there are JLabel and JButton both responds to mouse events and we need to distinguish between the JLabel and JButton
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class     MouseAdapterExample extends MouseAdapter {

   public MouseAdapterExample() {
      // Set up the frame
      JFrame frame = new JFrame();

      frame.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 4));

      // Create a label and add the mouse adapter
      JLabel label = new JLabel("Click the label");
      label.addMouseListener(this);
      frame.add(label);

      // Create a button and add the mouse adapter
      JButton button = new JButton("Click the button");
      button.addMouseListener(this);
      frame.add(button);


      frame.setSize(500, 500);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // Override the methods for label and button mouse events
   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getSource() instanceof JLabel) {
         System.out.println("Mouse Clicked on the label");
      } else if (e.getSource() instanceof JButton) {
         System.out.println("Mouse Clicked on the button");
      }
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      if (e.getSource() instanceof JLabel) {
         System.out.println("Mouse Entered the label");
      } else if (e.getSource() instanceof JButton) {
         System.out.println("Mouse Entered the button");
      }
   }


   //different way to do it



   // Create a label and add a separate mouse adapter
   // JLabel label = new JLabel("Click the label");
   // label.addMouseListener(new MouseAdapter() {
   //    @Override
   //    public void mouseClicked(MouseEvent e) {
   //       System.out.println("Mouse Clicked on the label");
   //    }

   //    @Override
   //    public void mouseEntered(MouseEvent e) {
   //       System.out.println("Mouse Entered the label");
   //    }
   // });
   // frame.add(label);

   // Create a button and add a separate mouse adapter
   // JButton button = new JButton("Click the button");
   // button.addMouseListener(new MouseAdapter() {
   //    @Override
   //    public void mouseClicked(MouseEvent e) {
   //       System.out.println("Mouse Clicked on the button");
   //    }

   //    @Override
   //    public void mouseEntered(MouseEvent e) {
   //       System.out.println("Mouse Entered the button");
   //    }
   // });
   // frame.add(button);



   public static void main(String[] args) {
      new MouseAdapterExample();
   }
}