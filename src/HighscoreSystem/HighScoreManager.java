package HighscoreSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        return highscores;
    }

    public void addHighscores(String name, int score){
        loadScoreFile();
        highscorequicksort(highscores);
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
    private static void quicksort(ArrayList<Highscores> list, int leftIndex, int righIndex, Comparator<Highscores> comparator){

        //Bounce Check
        if (leftIndex>=righIndex){
            return;
        }
        //Definiere Marker und Pivot
        int i = leftIndex;
        int j = righIndex-1;
        Highscores pivot = list.get(righIndex);

        do{
            //Die Indexe aufeinander zulaufen lassen
            while (i<righIndex&&comparator.compare(list.get(i),pivot)<=0){
                i++;//
            }while (i>leftIndex&&comparator.compare(list.get(i),pivot)>=0){
                j--;
            }if (i<j){
                Highscores temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);
            }

            //Teilen der Arraylist
        }while (i<j);

        if (comparator.compare(list.get(i),pivot)>0){

            Highscores temp = list.get(i);
            list.set(i,list.get(righIndex));
            list.set(righIndex,temp);

        }
        quicksort(list,leftIndex,i-1,comparator);
        quicksort(list,i+1,righIndex,comparator);

    }

    public static void highscorequicksort(ArrayList<Highscores> list) {
        Comparator<Highscores> comp = new ScoreComperator();
        quicksort(list, 0, list.size() - 1, comp);


    }












}
