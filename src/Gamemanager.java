public class Gamemanager {

    private int gamestate = 1;
    Text Story;

    //Konstruktor
    public Gamemanager(){

    }

    public String userInput(int Input){

        switch (gamestate){

            case 1 : gamestate++;
            return Text.Intro;

        }
        return "Fehler";
    }
}
