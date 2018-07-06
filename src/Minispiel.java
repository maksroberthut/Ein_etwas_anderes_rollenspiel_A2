import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;


public class Minispiel {

    private JButton[][] buttons = new JButton[9][9];
    private int[][] spielfeld = new int[9][9];
    private JFrame minesweeper = new JFrame("Minesweeper");
    int win = 0;
    private int minigameState = 1; //0 = verloren, 1 = laufend, 2 = gewonnen
    private MouseAdapter clickAdapter;

    public Minispiel(){
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
        clickAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON3){//Rechtsklick
                    if(e.getComponent().getBackground()==Color.RED){
                        e.getComponent().setBackground(Color.WHITE);
                    }
                    else if (e.getComponent().getBackground()!=Color.LIGHT_GRAY) {
                        e.getComponent().setBackground(Color.RED);
                    }
                } else { //Linksklick
                    for (int x = 0; x < 9; x++)
                    {
                        for (int y = 0; y < 9; y++)  {
                            if (e.getSource() == buttons[x][y]) {
                                freilegen(x, y);
                            }
                        }
                    }
                }
                return;
            }
        };

        for(int y = 0;y<9;y++) {
            for(int x = 0;x<9;x++) {
                buttons[x][y]= new JButton();
                spiel.add(buttons[x][y]);
                buttons[x][y].setVisible(true);
                buttons[x][y].addMouseListener(clickAdapter);
                buttons[x][y].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[x][y].setBackground(Color.WHITE);
            }
        }
    }

    private void freilegen(int x,int y){
        if (minigameState != 1) return;
        if(spielfeld[x][y]==10) {
            //auf Bombe geklickt
            for(int k = 0;k<9;k++) {
                for (int l = 0; l < 9; l++) {
                    if (spielfeld[k][l]==10){
                        buttons[k][l].setBackground(Color.BLACK);
                        minigameState = 0;
                    }
                }
            }
            JOptionPane.showMessageDialog(minesweeper,"Leider Verloren! Punktzahl: " + win);
            minesweeper.dispatchEvent(new WindowEvent(minesweeper, WindowEvent.WINDOW_CLOSING));
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
                    if(x + n < 9 && x + n > -1 && y + m < 9 && y + m > -1 && buttons[x+n][y+m].getBackground()!=Color.LIGHT_GRAY) {
                        freilegen(x + n, y + m);
                    }
                }
            }
        }
        if(win==71){
            minigameState= 2;
            for(int k = 0;k<9;k++) {
                for (int l = 0; l < 9; l++) {
                    buttons[k][l].setBackground(Color.GREEN);
                }
            }
            JOptionPane.showMessageDialog(minesweeper,"Gewonnen!");
            minesweeper.dispatchEvent(new WindowEvent(minesweeper, WindowEvent.WINDOW_CLOSING));
        }
    }
    public int zustand(){
        return minigameState;
    }
}