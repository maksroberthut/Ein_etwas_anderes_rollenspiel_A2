package HighscoreSystem;

import java.util.ArrayList;
import java.util.Comparator;

public class Quicksort extends HighScoreManager{

    private static void quicksort(ArrayList<Highscores> list, int leftIndex, int righIndex, Comparator<Highscores> comparator){

        if (leftIndex>=righIndex){
            return;
        }
        //Index und pivot bestimmen
        int i = leftIndex;
        int j = righIndex-1;
        Highscores pivot = list.get(righIndex);

        do{
            while (i<righIndex&&comparator.compare(list.get(i),pivot)<=0){
                i++;
            }while (i>leftIndex&&comparator.compare(list.get(i),pivot)>=0){
                j--;
            }if (i<j){
                Highscores temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);

            }
        }while (i<j);

        if (comparator.compare(list.get(i),pivot)>0){

            Highscores temp = list.get(i);
            list.set(i,list.get(righIndex));
            list.set(righIndex,temp);

        }
        quicksort(list,leftIndex,i-1,comparator);
        quicksort(list,i+1,righIndex,comparator);

    }

    public void highscorequicksort(ArrayList<Highscores> highscores) {
        Comparator<Highscores> comp = new ScoreComperator();
        quicksort(highscores, 0, highscores.size() - 1, comp);


    }
}
