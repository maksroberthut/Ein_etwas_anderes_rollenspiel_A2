package HighscoreSystem;

import java.io.Serializable;

/**
 * Diese Klasse richtet ein einfaches Highscoreobjekt ein
 * Diese Klasse wurde von Maksymilian Hutyra verfasst
 */

public class Highscores implements Serializable {

    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Highscores(String name, int score){
        this.score = score;
        this.name = name;

    }

    public int compareTo(Highscores score2){
        if (getScore() < score2.getScore()){
            return -1;
        }else if (getScore() > score2.getScore()){
            return +1;
        }else {
            return 0;
        }
    }
}
