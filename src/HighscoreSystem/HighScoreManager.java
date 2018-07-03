package HighscoreSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class HighScoreManager{
    // Wir benutzen eine ArryList vom Typen score die in dieeser Klasse arbeiten
    private ArrayList<Highscores> highscores;

    //Der Name der binary File  wo  der Highscore gespeichert wird
    private static final String HIGHSCORE_FILE = "scores.dat";

    //Initializieren des outputSreams für die Arbeit mit der File
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

   //Konstruktor der Klasse
    public HighScoreManager(){
        highscores = new ArrayList<Highscores>();
    }

    public ArrayList<Highscores> getHighscores(){
        loadScoreFile();
        //quicksort();
        return highscores;
    }

    public void addHighscores(String name, int score){
        loadScoreFile();
        highscores.add(new Highscores(name,score));



    }

    //In dieser Methode läd die ArryList auf die HighScoreFile
    public void loadScoreFile(){
        try{
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            highscores = (ArrayList<Highscores>)((ObjectInputStream) inputStream).readObject();

        }catch(FileNotFoundException fnf1){

        }catch (IOException ioe){
            System.out.println("[Load] IOE-Error");

        }catch (ClassNotFoundException cnf){
            System.out.println("[Load] CNF-Error"+cnf.getMessage());

        }finally {
            try {
                if (outputStream != null){
                    outputStream.flush();
                    outputStream.close();
                }
            }catch(IOException ioe2){
                System.out.println("[Load IO-Error"+ioe2.getMessage() );
            }
        }
        }
    //In dieser Methode machen wir eigentlich das gleiche wie in der loadScore file Methode, wir schreiben nur auf die File anstatt sie zu lesen
    public void updateScoreFile(){
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(highscores);
        }catch(FileNotFoundException fnf){
            System.out.println("[Update] Error:"+fnf.getMessage());

        }catch(IOException ioe){
            System.out.println("[Update] Error:"+ioe.getMessage());

        }finally {
            try {
                if(outputStream != null){
                    outputStream.flush();
                    outputStream.close();
                }
            }catch(IOException ioe2){
                System.out.println("[Update] Error:"+ioe2.getMessage());
            }
        }
    }
    //  Die Highscores aus der File in Strings convertieren um sie Später im Textfeld anzuzeeigen
    public String highScoreString(){
          String highScoreString = "";
          int max = 12;

          ArrayList<Highscores> scores;
          scores = getHighscores();

          int i = 0;
          int s = scores.size();

          if (s>max){
              s = max;
          }
          while (i<s){
              highScoreString += (i+1)+".\t"+scores.get(i).getName()+"\t\t"+scores.get(i).getScore()+"\n";
              i++;
          }
          return highScoreString;




    }
    public ArrayList<Highscores> quicksort(ArrayList <Highscores> list){

        // Wenn sie schon geordnet sind
        if (highscores.size()<=1)
            return highscores;

        ArrayList<Highscores> sorted = new ArrayList<Highscores>();
        ArrayList<Highscores> lesser = new ArrayList<Highscores>();
        ArrayList<Highscores> greater = new ArrayList<Highscores>();
        Highscores pivot = list.get(list.size()-1);//Nehme den letzten Highscore als pivot

        for (int i =0;i< list.size()-1;i++){


        }
        return sorted;



    }

}
