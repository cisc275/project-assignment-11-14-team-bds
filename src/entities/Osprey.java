package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Osprey extends Bird {
	//time for animation to go to next frame in milliseconds
	private final int ANIMATION_STEP_TIME = 100;
	private Sprite tempSprite;
	
	public Osprey() {
		tempSprite = new Sprite(4, ANIMATION_STEP_TIME, "res/bird-temp.png");
	}
	
	@Override
    public void render(Graphics g) {
		int top = this.xPos - (this.width /2);
		int left = this.yPos - (this.height /2 );
		g.drawImage(tempSprite.getCurrentFrame(), top, left, this.width, this.height, null);
    }
	
	public void Dive(){}
	public boolean isAlive() {return true; }	
}

