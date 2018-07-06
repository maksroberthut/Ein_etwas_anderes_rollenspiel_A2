package HighscoreSystem;

import java.util.ArrayList;
import java.util.Comparator;

public class Quicksort {

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

        //Wenn ein positiver inteeger rauskommt wird die bedingung ausgeführt und der rechte index auch angepasst
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
