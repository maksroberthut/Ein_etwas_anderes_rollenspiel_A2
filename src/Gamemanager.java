public class Gamemanager {

    // Das ist unsere Klasse wo wir die ganze logic des Spiels haben

    private int gamestate = 1;
    int score = 0;
    private GUI gui;

    //Konstruktor
    public Gamemanager(GUI gui){
        this.gui = gui;


    }
    //Bei Buttonklick wird der Text geändert
    //jeder Case ist eine Kapitel in der Story
    public String userInput(int Input){

        scoremulti(Input);
        switch (gamestate){
            //Der Intro Text wird angezeigt
            case 1 : gamestate++;
            //ändert den Text der Buttons nach einem Gamestate
            gui.changeButtonLable("1","2","3","4");
            return Text.Intro;

            case 2 : gamestate++;


        }
        return "Fehler";
    }
    //Den Tasten einen Wert (Mutpunkte) zuweisen(jeweils die Arrays und auf score addiert
    public void scoremulti(int Input){

        int[] state1 = {0,4,2,3,1};

        switch (gamestate){

            case 1 : score += state1[Input]; break;
            }
        }

    }

