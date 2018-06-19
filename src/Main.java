import javax.swing.*;

public class Main extends JFrame {


    public static void main (String[]args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();

                frame.setTitle("Ein etwas anderes Rollenspiel");
                frame.setSize(1000,600);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            }
        });





    }
}
