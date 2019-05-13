package views;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageHandler {
    /*
    * Given an filepath, return the image in an array
    * @param filePath, string path to the resource
    * @return the image loaded into an array, null if file could not be found
    * */
	public static BufferedImage loadImage(String filePath) {
		BufferedImage bufferedImage;
		File file = new File(filePath);
        try {
            bufferedImage = ImageIO.read(file);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
