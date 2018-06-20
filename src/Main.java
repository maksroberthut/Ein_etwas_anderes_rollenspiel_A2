import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        Images images = new Images();

        images.loadImages();
        gui.initialize();

    }
}
