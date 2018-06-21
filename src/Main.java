import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        //TODO löachen falls die BufferedImages in GUI KLasse kommen
        //Images images = new Images();
        menuGUI menugui = new menuGUI();

        menugui.initializeMenu();
        //TODO Methode freigeben, wenn BufferedImages funktionieren
       // gui.loadImages();


    }
}
