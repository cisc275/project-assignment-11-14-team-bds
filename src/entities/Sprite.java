package entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	public static String DEFAULT_SPRITE_PATH = "res/default.png";
	public static int DEFAULT_SPRITE_FRAMES = 1;
	
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int numFrames = 0;
	
	//Initialize a Sprite using the default graphics (see static variables at top of file)
	public Sprite() {
		numFrames = 1;
		frames = initializeFrames(loadImage(DEFAULT_SPRITE_PATH));
	}
	
	public Sprite(int numFrames, String imagePath) {
		this.numFrames = numFrames;
		frames = initializeFrames(loadImage(imagePath));
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[currentFrame];
	}
	
	public BufferedImage nextFrame() {
		currentFrame++;
		if(currentFrame >= numFrames) {
			currentFrame = 0;
		}
		return frames[currentFrame];
	}
	
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
	
	private BufferedImage[] initializeFrames(BufferedImage image) {
		BufferedImage[] splitImage = new BufferedImage[numFrames];
		if(numFrames == 1) {
			splitImage[0] = image;
		}
		else {
			int frameWidth = image.getWidth()/numFrames;
			for(int i = 0; i < numFrames; i++) {
				splitImage[i] = image.getSubimage(i*frameWidth, 0, frameWidth, image.getWidth());
			}
		}
		
		return splitImage;
	}
	
}
