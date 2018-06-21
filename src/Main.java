import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        Gamemanager gamemanager = new Gamemanager();
        gui.initialize(gamemanager);
    }
}
