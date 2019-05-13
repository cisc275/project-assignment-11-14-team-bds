package views;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageHandler {
	//For use in applySaturationFilter()
	private static int[] pixels = null;
	private static float[] hsb = null;
	
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
	
	/**
	 * Applies a saturation value from 0.0-1.0 to a BufferedImage. Goes pixel by pixel in O(n) time, so it's recommended to only use this for smaller images.
	 * 
	 * @param img the image to modify
	 * @param saturation the saturation value of the new image. Should be between 0.0-1.0 inclusive
	 * @return new image with modified saturation
	 */
	public static BufferedImage applySaturationFilter(BufferedImage img, float saturation) {
		BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		pixels = img.getRGB(0,0,img.getWidth(),img.getHeight(),null,0,img.getWidth());
		
		for(int i = 0; i < pixels.length; i++) {
			int pixel = pixels[i];
			hsb = Color.RGBtoHSB((pixel>>16) & 0xFF, (pixel>>8) & 0xFF, pixel & 0xFF, null);
			hsb[1] = saturation;
			pixels[i] = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
		}
		
		newImg.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
		return newImg;
	}
}
