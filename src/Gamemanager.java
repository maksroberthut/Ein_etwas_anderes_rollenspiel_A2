
import java.awt.*;
import java.io.Serializable;
import HighscoreSystem.Highscores;
import HighscoreSystem.HighScoreManager;
import HighscoreSystem.Highscores;

import javax.swing.*;

public class Gamemanager {

    /*In dieser Klasse befindet sich der Ablauf des Spiels.
     Diese Klasse wurde verfasst von Dennis Krahl, Louisa Spieckermann und Inga Müller.
     */

    private int gamestate = 1;
    private int score = 0;
    private GUI gui;
    HighScoreManager highScoreManager;
    Images images = new Images();
    String name;

    public int getScore() {
        return score;
    }


    //Konstruktor
    public Gamemanager(GUI gui,HighScoreManager highScoreManager) {
        this.gui = gui;
        this.highScoreManager = highScoreManager;


    }

    public int getGamestate() {
        return gamestate;
    }

    public void setGamestate(int g) {
        gamestate = g;
    }



    public String userInput(int Input) {

        scoremulti(Input);
        switch (gamestate) {
            //Die jedes Case stellt ein Abschnitt des Spiels dar.
            // Durch Drücken des Weiter-Buttons (btnWeiter) wird gamestate um 1 erhöht und es wird zum nachsten Case gesprungen

            case 1: gamestate++;
                gui.changeButtonVisibility(false, true,true,false,false);
                gui.changeButtonLable("","Faultier","Mensch","");
                gui.hintergrund.setIcon(new ImageIcon(images.Charaktere));
                return Text.Charakter;

            case 2:
                gamestate++;
                gui.hintergrund.setIcon(new ImageIcon(images.hintergrundStartbild));
                return Text.Intro;

            case 3 : gamestate++;
                return Text.Intro2;

            case 4 : gamestate++;
                gui.hintergrund.setBackground(Color.BLACK);
                return Text.Intro3;

            case 5 : gamestate++;
                gui.hintergrund.setIcon(new ImageIcon(images.hintergrundWohnzimmer));
                return Text.Chap1_1;

            case 6: gamestate++;
                gui.hintergrund.setIcon(new ImageIcon(images.ZettelToDo));
                return Text.Chap1_2;

            case 7: gamestate++;
                gui.changeButtonLable("Oma","Monster","Huhn","Blobs");
                gui.changeButtonVisibility(true, true, true, true, false);
                return Text.Chap1_Auswahl;

            case 8: gamestate++;

                if(gui.getTuerEntscheidung()==1){
                    gui.hintergrund.setIcon(new ImageIcon((images.TuerOma)));
                }
                else if(gui.getTuerEntscheidung()==2){
                    gui.hintergrund.setIcon(new ImageIcon((images.TuerGeist)));
                }
                else if(gui.getTuerEntscheidung()==3){
                    gui.hintergrund.setIcon(new ImageIcon((images.TuerHuenchenPaket)));
                }
                else if(gui.getTuerEntscheidung()==4){
                    gui.hintergrund.setIcon(new ImageIcon((images.TuerBaelle)));
                }
                return Text.Chap2_1;

            case 9: gamestate++;
                gui.changeButtonVisibility(true, true, false, false,false);
                gui.changeButtonLable("Ne jetzt nicht!", "Zocken?", "", "");
                return Text.Chap2_2;


            case 10: gamestate++;
                //gui.hintergrund.setIcon (new ImageIcon(AutoWahl));
                gui.changeButtonVisibility(true, true, true, true, false);
                gui.changeButtonLable("Pferd","Bobbycar", "Einrad", "Fettes Auto");
                return Text.Chap2_Auswahl2;

            case 11: gamestate++;
                //gui.hintergrund.setIcon (new ImageIcon(RestaurantAussen));
                gui.changeButtonVisibility(false, false, false, false, true);
                gui.btnWeiter.setText("Weiter");
                return Text.Chap3_2;

            case 12: gamestate++;
                return Text.Chap4_1;


            case 13: gamestate++;
                //gui.hintergund.setIcon (new ImageIcon(RestaurantInnen));
                return Text.Chap4_2;

            case 14: gamestate++;
                gui.changeButtonVisibility(true, true, true, true, false);
                gui.changeButtonLable("Auf Toilette ordentlich...","Kartenhaus bauen", "Ein Nickerchen", "Karaoke");
                return Text.Chap4_3;


            case 15: gamestate++;
                //gui.hintergund.setIcon (new ImageIcon(RestaurantOma));
                return Text.Chap5_1;


            case 16: gamestate++;
                gui.changeButtonVisibility(true, true, true, true, false);
                gui.changeButtonLable("Ab in den dunklen Wald","Wieder aufs Klo", "Über die Straße rennen", "Aus dem Resteraunt");
                return Text.Chap5_2;


            case 17: gamestate++;
                highScoreManager.addHighscores(name,score);
                gui.btnWeiter.setText("Und Tschüss!");
                return Text.Chap6_Ende +"\n\n"+ highScoreManager.highScoreString();

            case 18: gamestate++;
                gui.frame.dispose();




        }

        return "fehler";
    }

    public void setPlayername(String name){
        this.name = name;

    }
    //Den Tasten einen Wert (Mutpunkte) zuweisen(jeweils die Arrays und auf score addiert
    public void scoremulti(int Input){

        int[] state1 = {1,4,2,3};
        int[] state2 = {1,5};
        int[] state3 = {1,4,3,2};
        int[] state4 = {3,2,1,4};

        switch (gamestate){

            case 8 : score += state1[Input]; break;
            case 10: score += state2[Input];break;
            case 11: score += state3[Input];break;
            case 15: score += state4[Input];break;




        }
    }

}

