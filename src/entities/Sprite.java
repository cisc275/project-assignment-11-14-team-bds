package entities;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Timer;

import views.ImageHandler;

public class Sprite {
	public static String DEFAULT_SPRITE_PATH = "res/default.png";
	public static int DEFAULT_SPRITE_FRAMES = 1;
	
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int numFrames = 0;
	private Timer timer = null;
	
	//Initialize a Sprite using the default graphics (see static variables at top of file)
	public Sprite() {
		numFrames = 1;
		frames = initializeFrames(ImageHandler.loadImage(DEFAULT_SPRITE_PATH));
	}
	
	public Sprite(int numFrames, String imagePath) {
		this.numFrames = numFrames;
		frames = initializeFrames(ImageHandler.loadImage(imagePath));
	}
	
	public Sprite(int numFrames, int frameStepTime, String imagePath) {
		this.numFrames = numFrames;
		frames = initializeFrames(ImageHandler.loadImage(imagePath));
		setFrameStepTime(frameStepTime);
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[currentFrame];
	}
	
	private void nextFrame() {
		currentFrame++;
		if(currentFrame >= numFrames) {
			currentFrame = 0;
		}
	}
	
	//Set how long in ms it takes to automatically advance to the next frame
	public void setFrameStepTime(int displayTime) {
		EventQueue.invokeLater(new Runnable() {
			@Override
            public void run() {
                Timer time = new Timer(displayTime, new AbstractAction() {
                	@Override
                    public void actionPerformed(ActionEvent e) {
                		nextFrame();
                    }
                });
                if(timer != null) { //stop previous timer
                	timer.stop();
                }
                timer = time;
                time.start();
            }
		});
	}
	
	private BufferedImage[] initializeFrames(BufferedImage image) {
		BufferedImage[] splitImage = new BufferedImage[numFrames];
		if(numFrames == 1) {
			splitImage[0] = image;
		}
		else {
			int frameWidth = image.getWidth()/numFrames;
			for(int i = 0; i < numFrames; i++) {
				splitImage[i] = image.getSubimage(i*frameWidth, 0, frameWidth, image.getHeight());
			}
		}
		
		return splitImage;
	}
	
}
