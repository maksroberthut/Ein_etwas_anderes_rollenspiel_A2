package HighscoreSystem;

import java.util.Comparator;

//Diese Klasse wird nur zum vergleiche von zwei Score Objekten benutzt

public class ScoreComperator implements Comparator <Highscores> {

    public int compare (Highscores score1,Highscores score2){

        int sc1 = score1.getScore();
        int sc2 = score2.getScore();

        if (sc1>sc2){
            return -1;
        }else if (sc1<sc2){
            return 1;
        }else{
            return 0;
        }


    }
}
