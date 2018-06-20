import javax.swing.*;
import java.awt.*;

public class GUI {

   public static JFrame frame;
   public static JPanel panel;

   public static JLabel hintergrund;

   public static JLabel character;

   public static JTextField textfeld;

   public static JButton btn1;
   public static JButton btn2;
   public static JButton btn3;
   public static JButton btn4;


    public static void initialize(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(50,50,1000,600);

        panel = new JPanel ();
        panel.setVisible(true);
        frame.add(panel);

        character = new JLabel("charakter");
        character.setVisible(true);
        panel.add(character);
        character.setBounds(1,1,250,290);
        character.setBackground(Color.BLUE);
        character.setOpaque(true);

        hintergrund = new JLabel("hintergrund");
        panel.add(hintergrund);
        hintergrund.setOpaque(true);
        hintergrund.setBackground(Color.ORANGE);
        hintergrund.setBounds(270,1,700,290);



        textfeld = new JTextField();
        textfeld.setVisible(true);
        panel.add(textfeld);
        textfeld.setBounds(0,300,1000,180);
        textfeld.setEditable(false);

        btn1 = new JButton("Antwort 1");
        panel.add(btn1);
        btn1.setVisible(true);
        btn1.setBounds(30,495,200,50);

        btn2 = new JButton("Antwort 2");
        panel.add(btn2);
        btn2.setVisible(true);
        btn2.setBounds(270,495,200,50);

        btn3 = new JButton("Antwort 3");
        panel.add(btn3);
        btn3.setVisible(true);
        btn3.setBounds(510,495,200,50);

        btn4 = new JButton("Antwort 4");
        panel.add(btn4);
        btn4.setVisible(true);
        btn4.setBounds(750,495,200,50);


    }



}
