import javax.swing.*;
import java.awt.*;

public class GUI {
    Images images = new Images();

    public static JFrame frame;
    public static JPanel panel;

    public static JLayeredPane layeredPane;

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

        //Layered Pane ermöglicht überlappen von Components
        layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        hintergrund = new JLabel("hintergrund");
        layeredPane.add(hintergrund);
        layeredPane.setLayer(hintergrund,0);
        hintergrund.setOpaque(true);
        //hintergrund.setIcon(new ImageIcon(Images.hintergrundWohnzimmer));
        hintergrund.setBounds(0,0,1000,600);


        character = new JLabel("charakter");
        layeredPane.add(character);
        layeredPane.setLayer(character,1);
        character.setVisible(true);
        character.setBounds(1,1,250,600);
        character.setIcon(new ImageIcon(Images.CharakterFaultier));
        character.setOpaque(true);


        textfeld = new JTextField("Das ist ein Textfeld");
        layeredPane.add(textfeld);
        layeredPane.setLayer(textfeld,2);
        textfeld.setVisible(true);
        textfeld.setBounds(0,300,1000,180);
        textfeld.setEditable(false);

        btn1 = new JButton("Antwort 1");
        layeredPane.add(btn1);
        layeredPane.setLayer(btn1,2);
        btn1.setVisible(true);
        btn1.setBounds(30,495,200,50);

        btn2 = new JButton("Antwort 2");
        layeredPane.add(btn2);
        layeredPane.setLayer(btn2, 2);
        btn2.setVisible(true);
        btn2.setBounds(270,495,200,50);

        btn3 = new JButton("Antwort 3");
        layeredPane.add(btn3);
        layeredPane.setLayer(btn3,2);
        btn3.setVisible(true);
        btn3.setBounds(510,495,200,50);

        btn4 = new JButton("Antwort 4");
        layeredPane.add(btn4);
        layeredPane.setLayer(btn4,2);
        btn4.setVisible(true);
        btn4.setBounds(750,495,200,50);


    }



}
