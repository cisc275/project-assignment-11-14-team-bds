package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Stick extends Collidable {
	
	private static Sprite sprite = new Sprite(1, "res/stick.png");
	private static int counter = 0;
	
	public Stick(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = 50;
		this.height = 20;
	}
  
	public void update(){};
	
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite.getCurrentFrame(), this.xPos, this.yPos, this.width, this.height, null);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(counter), this.xPos, this.yPos); //temp
	}
	
	public void onCollide(Collidable c) {
		incrementCounter();
		this.toBeRemoved = true;
	}
	
	public void onCollideBird(Bird b) {
    }
	
	public static void resetCounter() {
		counter = 0;
	}
	
	public static void incrementCounter() {
		counter++;
	}
	
	public static int getCount() {
		return counter;
	}
}
