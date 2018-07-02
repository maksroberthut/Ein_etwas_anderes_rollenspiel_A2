package HighscoreSystem;

import java.io.Serializable;

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
}
