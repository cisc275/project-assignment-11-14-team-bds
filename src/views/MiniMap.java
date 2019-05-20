package views;

import java.awt.image.BufferedImage;

import entities.Sprite;

public class MiniMap {
	
	private int step = 0;
	private Sprite sprite;
	
	public static final int STEPS = 12;
	
	public MiniMap() {
		sprite = new Sprite(STEPS, "res/map00.jpg");
	}
	
	public void advance() {
		if(step <= STEPS) {
			step++;
			sprite.nextFrame();
		}
	}
	
	public BufferedImage getCurrentImage() {
		return sprite.getCurrentFrame();
	}
}
