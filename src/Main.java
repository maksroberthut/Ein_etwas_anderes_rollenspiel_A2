import HighscoreSystem.HighScoreManager;

import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        HighScoreManager hm = new HighScoreManager();
        Gamemanager gamemanager = new Gamemanager(gui,hm);

        gui.initialize(gamemanager);

        hm.addHighscores("Inga",15);




    }
}
