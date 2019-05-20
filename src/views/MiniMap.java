package views;

import java.awt.image.BufferedImage;

import entities.Sprite;

public class MiniMap {
	
	private int step = 1;
	private Sprite sprite;
	
	protected int width = 250;
	protected int height = 250;
	
	public static final int STEPS = 12;
	public static final BufferedImage[] images = {
			ImageHandler.loadImage("res/Maps/map00.jpg"),
			ImageHandler.loadImage("res/Maps/map01.jpg"),
			ImageHandler.loadImage("res/Maps/map02.jpg"),
			ImageHandler.loadImage("res/Maps/map03.jpg"),
			ImageHandler.loadImage("res/Maps/map04.jpg"),
			ImageHandler.loadImage("res/Maps/map05.jpg"),
			ImageHandler.loadImage("res/Maps/map06.jpg"),
			ImageHandler.loadImage("res/Maps/map07.jpg"),
			ImageHandler.loadImage("res/Maps/map08.jpg"),
			ImageHandler.loadImage("res/Maps/map09.jpg"),
			ImageHandler.loadImage("res/Maps/map10.jpg"),
			ImageHandler.loadImage("res/Maps/map11.jpg")
	};
	
	public MiniMap() {
		sprite = new Sprite(images);
	}
	
	public void advance() {
		if(step < STEPS) {
			step++;
			sprite.nextFrame();
		}
	}
	
	public BufferedImage getCurrentImage() {
		return sprite.getCurrentFrame();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isFinished() {
		return step == STEPS;
	}
}
