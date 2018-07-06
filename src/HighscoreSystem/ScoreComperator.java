package HighscoreSystem;

import java.util.Comparator;

/**Diese Klasse sagt Java wie sie zwei Objekte vom Typen Score vergeleichen soll
 * Diese Klasse wurde von Maksymilian Robert Hutyra
 *
 */

public class ScoreComperator implements Comparator <Highscores> {

    public int compare (Highscores score1,Highscores score2) {

        return score1.getScore() - score2.getScore();
    }



}
