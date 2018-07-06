import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Images {

    public static BufferedImage CharakterFaultier;
    public static BufferedImage CharakterHeld;
    public static BufferedImage hintergrundStartbild;
    public static BufferedImage hintergrundWohnzimmer;
    public static BufferedImage PaketInhalt;
    public static BufferedImage textfeldHintergrund;
    public static BufferedImage TuerBaelle;
    public static BufferedImage TuerGeist;
    public static BufferedImage TuerHuenchenPaket;
    public static BufferedImage TuerOma;
    public static BufferedImage ZettelToDo;
    public static BufferedImage AutoFaultier;
    public static BufferedImage BobbycarMensch;
    public static BufferedImage BobbycarFaultier;
    public static BufferedImage AutoWahl;
    public static BufferedImage RestaurantAussen;
    public static BufferedImage RestaurantInnen;
    public static BufferedImage RestaurantOma;
    public static BufferedImage WaldEnde;



    public void loadingImages(){


        try {
            CharakterFaultier = ImageIO.read(getClass().getResource("/resources/CharakterFaultier.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            CharakterHeld = ImageIO.read(getClass().getResource("/resources/CharakterHeld.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hintergrundStartbild = ImageIO.read(getClass().getResource("/resources/hintergrundStartbild.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hintergrundWohnzimmer = ImageIO.read(getClass().getResource("/resources/hintergrundWohnzimmer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PaketInhalt = ImageIO.read(getClass().getResource("/resources/PaketInhalt.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            textfeldHintergrund = ImageIO.read(getClass().getResource("/resources/textfeldHintergrund.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TuerBaelle = ImageIO.read(getClass().getResource("/resources/TuerBaelle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            TuerGeist = ImageIO.read(getClass().getResource("/resources/TuerGeist.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TuerHuenchenPaket = ImageIO.read(getClass().getResource("/resources/TuerHuenchenPaket.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TuerOma = ImageIO.read(getClass().getResource("/resources/TuerOma.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ZettelToDo = ImageIO.read(getClass().getResource("/resources/ZettelToDo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }









    }
}

