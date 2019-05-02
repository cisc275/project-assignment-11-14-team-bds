package views;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageHandler {
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
