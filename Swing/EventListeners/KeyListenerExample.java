package EventListeners;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class KeyListenerExample implements KeyListener {

   public KeyListenerExample() {
      // Set up the frame
      JFrame frame = new JFrame();
      frame.setSize(500, 500);
      frame.setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a text field and add the key listener
      JTextField textField = new JTextField(20);
      textField.addKeyListener(this);
      frame.add(textField);


      frame.setVisible(true);
   }

   // Implement EventListeners.KeyListener methods
   @Override
   public void keyTyped(KeyEvent e) {
      System.out.println("Key Typed: " + e.getKeyChar());
   }

   @Override
   public void keyPressed(KeyEvent e) {
      System.out.println("Key Pressed: " + e.getKeyCode());
   }

   @Override
   public void keyReleased(KeyEvent e) {
      System.out.println("Key Released: " + e.getKeyCode());
   }

   public static void main(String[] args) {
      new KeyListenerExample();
   }
}
