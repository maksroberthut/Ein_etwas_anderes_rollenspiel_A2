import javax.swing.*;

public class Main extends JFrame {

    public static void main (String[]args){

        GUI gui = new GUI();
        menuGUI menuGUI = new menuGUI();
        Gamemanager gamemanager = new Gamemanager(gui);
        gui.initialize(gamemanager);


    }
}
