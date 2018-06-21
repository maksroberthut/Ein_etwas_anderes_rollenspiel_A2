public class Story {

    public static int kapitel=0;

    public static int getKapitel(){
        return kapitel;
    }

    public static void setKapitel(int k){
        kapitel = k;
    }


    Inhalt inhalt = new Inhalt();

    public void storyVerlauf(){

        inhalt.intro();

    }


}
