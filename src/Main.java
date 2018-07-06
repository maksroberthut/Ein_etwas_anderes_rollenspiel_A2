import HighscoreSystem.HighScoreManager;

import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        menuGUI menuGUI = new menuGUI();
        Gamemanager gamemanager = new Gamemanager(gui);
        HighScoreManager hm = new HighScoreManager();
        gui.initialize(gamemanager);


        hm.addHighscores("Louisa",12);


    }
}
