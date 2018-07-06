import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;


public class Minispiel implements ActionListener {

    private JButton[][] buttons = new JButton[9][9];
    private int[][] spielfeld = new int[9][9];
    private JFrame minesweeper = new JFrame("Minesweeper");
    int win = 0;
    private int spielLäuft = 1;
    public Spiel(){
        for(int i = 0;i<10;i++){
            int x;
            int y;
            do {
                x = (int) (Math.random() * 9);
                y = (int) (Math.random() * 9);
            } while(spielfeld[x][y]>9);
            spielfeld[x][y] = 10;
            for (int m = -1;m<2;m++){
                for (int n = -1;n<2;n++){
                    if(x + n < 9 && x + n > -1 && y + m < 9 && y + m > -1 && spielfeld[x + n][y + m]<10) {
                        spielfeld[x + n][y + m]++;
                    }
                }
            }
        }
        minesweeper.setSize(560,560);
        minesweeper.setVisible(true);
        JPanel spiel = new JPanel();
        minesweeper.add(spiel);
        spiel.setVisible(true);
        spiel.setLayout(new GridLayout(9,9,2,2));
        spiel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(int y = 0;y<9;y++) {
            for(int x = 0;x<9;x++) {
                buttons[x][y]= new JButton();
                spiel.add(buttons[x][y]);
                buttons[x][y].setVisible(true);
                buttons[x][y].addActionListener(this);
                buttons[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(e.getButton()==MouseEvent.BUTTON3){
                            if(e.getComponent().getBackground()==Color.RED){
                                e.getComponent().setBackground(Color.WHITE);
                            }
                            else if (e.getComponent().getBackground()!=Color.LIGHT_GRAY) {
                                e.getComponent().setBackground(Color.RED);
                            }
                        }
                    }
                });
                buttons[x][y].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[x][y].setBackground(Color.WHITE);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        for(int y = 0;y<9;y++) {
            for (int x = 0; x < 9; x++) {
                if (e.getSource() == this.buttons[x][y]) {
                    freilegen(x,y);
                }
            }
        }
    }
    private void freilegen(int x,int y){
        if(spielfeld[x][y]==10) {
            for(int k = 0;k<9;k++) {
                for (int l = 0; l < 9; l++) {
                    if (spielfeld[k][l]==10){
                        buttons[k][l].setBackground(Color.BLACK);
                        spielLäuft = 0;
                    }
                }
            }
            //minesweeper.dispatchEvent(new WindowEvent(minesweeper, WindowEvent.WINDOW_CLOSING));
        }
        if(spielfeld[x][y]>0 && spielfeld[x][y]<10 && buttons[x][y].getBackground()!=Color.LIGHT_GRAY){
            buttons[x][y].setText(Integer.toString(spielfeld[x][y]));
            buttons[x][y].setBackground(Color.LIGHT_GRAY);
            win++;
        }
        if (spielfeld[x][y]==0 && buttons[x][y].getBackground()!=Color.LIGHT_GRAY){
            buttons[x][y].setBackground(Color.LIGHT_GRAY);
            win++;
            for (int m = -1;m<2;m++){
                for (int n = -1;n<2;n++){
                    System.out.println("wubbuu");
                    if(x + n < 9 && x + n > -1 && y + m < 9 && y + m > -1 && buttons[x+n][y+m].getBackground()!=Color.LIGHT_GRAY) {
                        freilegen(x + n, y + m);
                        System.out.println("mmmm");
                    }
                }
            }
        }
        if(win==71){
            for(int k = 0;k<9;k++) {
                for (int l = 0; l < 9; l++) {
                    buttons[k][l].setBackground(Color.GREEN);
                    spielLäuft= 2;
                }
            }
        }
    }
    public int zustand(){
        return spielLäuft;
    }
}
