import javax.swing.*;


public class Frame_object extends JFrame {
    Frame_object(){
        setTitle("Instantiation");
        setVisible(true);
        setSize(400,400);
        setLocation(500,300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args){
        Frame_object f =  new Frame_object();
    }
}
