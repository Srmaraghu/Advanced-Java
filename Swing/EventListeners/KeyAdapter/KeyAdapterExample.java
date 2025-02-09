package EventListeners.KeyAdapter;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyAdapterExample extends KeyAdapter {

   public KeyAdapterExample() {
      // Set up the frame
      JFrame frame = new JFrame();
      frame.setSize(500, 500);
      frame.setVisible(true);
      frame.setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a text field and add the key adapter
      JTextField textField = new JTextField(20);
      textField.addKeyListener(this);
      frame.add(textField);
   }

   // Override only the methods that are needed
   @Override
   public void keyTyped(KeyEvent e) {
      System.out.println("Key Typed: " + e.getKeyChar());
   }

   @Override
   public void keyPressed(KeyEvent e) {
      System.out.println("Key Pressed: " + e.getKeyCode());
   }



   public static void main(String[] args) {
      new KeyAdapterExample();
   }
}
