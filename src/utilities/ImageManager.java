package utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageManager {

    // this may need modifying
    public final static String path = "images/";
    public final static String ext = ".png";

    public static Map<String, Image> images = new HashMap<String, Image>();

    public static Image getImage(String s) {
        return images.get(s);
    }

    public static Image UPDOOT, DOWNDOOT;
    public static BufferedImage BUF_UPDOOT, BUF_DOWNDOOT;

    static {
        try {
            UPDOOT = ImageManager.loadImage("upvote");
            BUF_UPDOOT = loadBufferedImage("upvote");
            DOWNDOOT = ImageManager.loadImage("downvote");
            BUF_DOWNDOOT = loadBufferedImage("downvote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image loadImage(String fname) throws IOException {
        BufferedImage img = loadBufferedImage(fname);
        //img = ImageIO.read(new File(path + fname + ext));
        images.put(fname, img);
        return img;
    }

    public static BufferedImage loadBufferedImage(String fname) throws IOException{
        BufferedImage img = null;
        img = ImageIO.read(new File(path + fname + ext));
        return img;
    }

    public static Image loadImage(String imName, String fname) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(new File(path + fname + ext));
        images.put(imName, img);
        return img;
    }

    public static void loadImages(String[] fNames) throws IOException {
        for (String s : fNames)
            loadImage(s);
    }

    public static void loadImages(Iterable<String> fNames) throws IOException {
        for (String s : fNames)
            loadImage(s);
    }

}