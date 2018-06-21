import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {

    public static BufferedImage CharakterFaultier;
    public static BufferedImage CharakterHeld;
    public static BufferedImage hintergrundStartbild;
    public static BufferedImage hintergrundWohnzimmer;
    public static BufferedImage PaketInhalt;
    public static BufferedImage textfeldHintergrund;
    public static BufferedImage TuerBaelle;
    public static BufferedImage TuerGeist;
    public static BufferedImage TuerHuenchen;
    public static BufferedImage TuerHuenchenPaket;
    public static BufferedImage TuerOma;
    public static BufferedImage ZettelToDo;

    public void loadingImages(){

        //TODO Die BufferedImages werden nicht gefunden
        try {
                CharakterFaultier = ImageIO.read(getClass().getResource("/CharakterFaultier.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                CharakterHeld = ImageIO.read(getClass().getResource("/CharakterHeld.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

