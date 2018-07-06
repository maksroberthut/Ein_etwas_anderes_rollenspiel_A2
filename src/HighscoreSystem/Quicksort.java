package HighscoreSystem;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Inn dieser Klasse findet man den Haupalgorithmus unseres spiels
 * Eine Quicksort, der die highscores aufsteigend sortiert
 * Diese Kalssse wurde von Maksymilian Robert Hutyra erstellt
 */

public class Quicksort {

   public static ArrayList<Highscores> quicksort(ArrayList<Highscores> list){

       if (list.size()<=1)
           return list;
       ArrayList<Highscores> sorted = new ArrayList<Highscores>();
       ArrayList<Highscores> lesser = new ArrayList<Highscores>();
       ArrayList<Highscores> greater = new ArrayList<Highscores>();
       Highscores pivot = list.get(list.size()-1);

       for (int i = 0 ; i <list.size()-1;i++){

           if ((list.get(i).compareTo(pivot)<0))
               lesser.add(list.get(i));
           else
               greater.add(list.get(i));
       }
       lesser =quicksort(lesser);
       greater = quicksort(greater);

       lesser.add(pivot);
       lesser.addAll(greater);
       sorted = lesser;

       return sorted;

   }

}
