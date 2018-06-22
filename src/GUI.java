import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private Gamemanager gamemanager;

    public  JFrame frame;


    public static JLayeredPane layeredPane;

    public  JLabel hintergrund;

    public  JLabel character;

    public  JTextField textfeld;

    public JButton btn1;
    public JButton btn2;
    public JButton btn3;
    public JButton btn4;


    public void initialize(Gamemanager p) {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(50, 50, 1000, 600);

        layeredPane = new JLayeredPane();
        layeredPane.setVisible(true);
        frame.add(layeredPane);

        hintergrund = new JLabel("hintergrund");
        layeredPane.add(hintergrund);
        layeredPane.setLayer(hintergrund, 0);
        hintergrund.setOpaque(true);
        //nur zu Testzwecken eingefärbt
        hintergrund.setBackground(Color.ORANGE);
        hintergrund.setBounds(270, 1, 1000, 600);

        character = new JLabel("charakter");
        character.setVisible(true);
        layeredPane.add(character);
        layeredPane.setLayer(character, 1);
        character.setBounds(1, 1, 300, 600);
        character.setBackground(Color.BLUE);
        character.setOpaque(true);

        textfeld = new JTextField();
        textfeld.setVisible(true);
        layeredPane.add(textfeld);
        layeredPane.setLayer(textfeld,2);
        textfeld.setBounds(0, 300, 1000, 180);
        textfeld.setEditable(false);


        btn1 = new JButton("Antwort 1");
        btn1.addActionListener(this);
        layeredPane.add(btn1);
        layeredPane.setLayer(btn1,2);
        btn1.setVisible(true);
        btn1.setBounds(30, 495, 200, 50);

        btn2 = new JButton("Antwort 2");
        btn2.addActionListener(this);
        layeredPane.add(btn2);
        layeredPane.setLayer(btn2,2);
        btn2.setVisible(true);
        btn2.setBounds(270, 495, 200, 50);

        btn3 = new JButton("Antwort 3");
        btn3.addActionListener(this);
        layeredPane.add(btn3);
        layeredPane.setLayer(btn3,2);
        btn3.setVisible(true);
        btn3.setBounds(510, 495, 200, 50);

        btn4 = new JButton("Antwort 4");
        btn3.addActionListener(this);
        layeredPane.add(btn4);
        layeredPane.setLayer(btn4,2);
        btn4.setVisible(true);
        btn4.setBounds(750, 495, 200, 50);

        gamemanager = p;


    }
    //Änderung des Textes auf dem Buttons
    public void changeButtonLable(String a,String b,String c, String d){
        btn1.setText(a);
        btn2.setText(b);
        btn3.setText(c);
        btn4.setText(d);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //Buttonevent um den Text (String) im Textfeld zu zeigen
        if (e.getSource() == btn1) {
            textfeld.setText(gamemanager.userInput(1));
        }else if(e.getSource()==btn2){
            textfeld.setText(gamemanager.userInput(2));
        }else if(e.getSource()==btn3){
            textfeld.setText(gamemanager.userInput(3));
        }else if(e.getSource()==btn4){
            textfeld.setText(gamemanager.userInput(4));
        }



        }

    }

