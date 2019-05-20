package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Stick extends Collidable {
	
	private static Sprite sprite = new Sprite(1, "res/stick.png");
	
	public Stick(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = 90;
		this.height = 60;
	}
  
	public void update(){};
	
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite.getCurrentFrame(), this.xPos, this.yPos - height, this.width, this.height, null);
		g.setColor(Color.BLACK);
		//g.drawString(Integer.toString(counter), this.xPos, this.yPos); //temp
	}
	
	public void onCollide(Collidable c) {
		if (c instanceof ClapperRail) {
			getStick((Bird)c);
		}
	}
	
	public void getStick(Bird c) {
		if (c.isDiving())
			this.toBeRemoved = true;
			 if (this.toBeRemoved == true) {
				 c.incCount();
			 }
	}
	
}
