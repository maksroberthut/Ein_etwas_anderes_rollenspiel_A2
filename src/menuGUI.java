import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuGUI {

    static GUI gui = new GUI();

    public static JFrame menuframe;
    public static JPanel panel;
    public static JLabel menuHintergrund;
    public static JLabel titel;
    public static JButton btnStart;
    public static JButton btnExit;

    public void initializeMenu() {
        menuframe = new JFrame("Ein etwas anderes Rollenspiel");
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuframe.setBounds(200, 100, 626, 500);
        menuframe.setBackground(Color.BLACK);
        menuframe.getContentPane().setBackground(Color.black);
        menuframe.setVisible(true);

        panel = new JPanel();
        menuframe.add(panel);
        panel.setSize(626, 626);
        panel.setLayout(null);

        titel = new JLabel("Ein etwas anderes Rollenspiel");
        titel.setBounds(200, 20, 300, 50);
        titel.setBackground(Color.white);
        titel.setVisible(true);
        titel.setForeground(Color.DARK_GRAY);
        Font font1 = new Font("Century Gothic", Font.BOLD, 20);
        titel.setFont(font1);
        panel.add(titel);

        menuHintergrund = new JLabel();
        menuHintergrund.setSize(600, 450);
        menuHintergrund.setVisible(true);
        panel.add(menuHintergrund);
        menuHintergrund.setSize(626, 500);

        btnStart = new JButton("Start");
        menuHintergrund.add(btnStart);
        btnStart.addActionListener(new Action());
        btnStart.setBounds(150, 200, 300, 30);
        btnStart.setVisible(true);


        btnExit = new JButton("Beenden");
        menuHintergrund.add(btnExit);
        btnExit.addActionListener(new Action());
        btnExit.setBounds(150, 300, 300, 30);
        btnExit.setVisible(true);
    }


    static class Action implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==btnStart){
                gui.initialize();
                menuframe.setVisible(false);
                menuframe.dispose();
            }
            else if(e.getSource()==btnExit){
                menuframe.setVisible(false);
                gui.frame.dispose();
                menuframe.dispose();
            }
        }
    }

}
