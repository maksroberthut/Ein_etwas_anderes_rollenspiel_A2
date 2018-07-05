package HighscoreSystem;

import java.util.Comparator;

//Diese Klasse wird nur zum vergleiche von zwei Score Objekten benutzt

public class ScoreComperator implements Comparator <Highscores> {

    public int compare (Highscores score1,Highscores score2){

        return score1.getScore()-score2.getScore();
        }



}
