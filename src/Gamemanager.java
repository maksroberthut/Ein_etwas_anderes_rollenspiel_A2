
import java.io.Serializable;
import HighscoreSystem.Highscores;
import HighscoreSystem.HighScoreManager;

public class Gamemanager {

    // Das ist unsere Klasse wo wir die ganze logic des Spiels haben

    private int gamestate = 1;
    private int score = 0;
    private GUI gui;
    HighScoreManager highScoreManager = new HighScoreManager();

    public int getScore() {
        return score;
    }


    //Konstruktor
    public Gamemanager(GUI gui) {
        this.gui = gui;


    }

    public int getGamestate() {
        return gamestate;
    }

    public void setGamestate(int g) {
        gamestate = g;
    }

    //Bei Buttonklick wird der Text geändert
    //jeder Case ist eine Kapitel in der Story
    public String userInput(int Input) {

        scoremulti(Input);
        switch (gamestate) {
            //Der Intro Text wird angezeigt
            case 1:
                gamestate++;
                //ändert den Text der Buttons nach einem Gamestate
                gui.changeButtonLable("weiter", "", "", "");
                gui.changeButtonVisibility(true, false, false, false);
                return Text.Intro;

            case 2:
                gamestate++;
                gui.changeButtonLable("weiter", "", "", "");

                return Text.Intro2;

            case 3:
                gamestate++;
                return Text.Intro3;

            case 4:
                gamestate++;
                return Text.Chap1_1;

            case 5:
                gamestate++;
                return Text.Chap1_2;

            case 6:
                gamestate++;
                gui.changeButtonLable("Oma", "Monster", "Huhn", "Blobs");
                gui.changeButtonVisibility(true, true, true, true);
                return Text.Chap1_Auswahl;

            case 7:
                gamestate++;
                gui.changeButtonLable("weiter", "", "", "");
                gui.changeButtonVisibility(true, false, false, false);
                return Text.Chap2_1;

            case 8:
                gamestate++;
                gui.changeButtonVisibility(true, false, false, false);
                gui.changeButtonLable("weiter", "", "", "");
                return Text.Chap2_1;

            case 9:
                gamestate++;
                gui.changeButtonVisibility(true, true, false, false);
                gui.changeButtonLable("Ne jetzt nicht!", "Zocken?", "", "");

                return Text.Chap2_2;

            case 10:
                gamestate++;
                return Text.Chap3_1;

            case 11:
                gamestate++;
                return Text.Chap2_1;

            case 12:
                gamestate++;
                return Text.Chap2_1;

            case 13:
                gamestate++;
                return Text.Chap2_1;


        }
        return "Fehler";
    }
    //Den Tasten einen Wert (Mutpunkte) zuweisen(jeweils die Arrays und auf score addiert
    public void scoremulti(int Input){

        int[] state1 = {0,0,0,0,0,4,2,3,1};

        switch (gamestate){

            case 1 : score += state1[Input]; break;
        }
    }

}
