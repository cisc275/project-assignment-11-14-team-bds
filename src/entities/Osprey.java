package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import views.ImageHandler;

public class Osprey extends Bird {
	//time for animation to go to next frame in milliseconds
	private final int ANIMATION_STEP_TIME = 500;
	private Sprite tempSprite;

	public Osprey() {
		this.width = 100;
		this.height = 100;
		tempSprite = new Sprite(4, ANIMATION_STEP_TIME, "res/bird-temp.png");
	}
	
	@Override
    public void render(Graphics g, List<Sprite> l) {
		int top = this.xPos - (this.width /2);
		int left = this.yPos - (this.height /2);
		float saturation = Math.max((float)health/(float)MAX_HEALTH, 0f);
		//g.drawImage(ImageHandler.applySaturationFilter(tempSprite.getCurrentFrame(), saturation), top, left, this.width, this.height, null);
		g.drawImage(ImageHandler.applySaturationFilter(l.get(4).getCurrentFrame(), saturation), top, left, this.width, this.height, null);
    }

    @Override
	public void update() {
		if (diving) {
			this.xPos += this.xDir * .5;
			this.yPos -= 20;
		} else {
			super.update();
		}
	}
	public void Dive(){}
	public boolean isAlive() {return true; }	
}

