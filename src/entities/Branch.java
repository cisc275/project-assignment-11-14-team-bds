package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import controllers.Randoms;

public class Branch extends Collidable {
	public Branch() {
	  super(0,0,50,50,1);
		this.xPos = Randoms.getRandomInt(500);
		this.yPos =0;
	}
	@Override
	public boolean collideWith(Collidable that) {
		if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
    		if (this.getY() > that.getY() && this.getY() < (that.getY() + that.getHeight())) {
    			return true;
    			}
    		}
		return false;
	}

	@Override
	public void onCollide(Collidable that) {
			System.out.println("Collided with Branch");
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(xPos, yPos - height, width, height);
	}

	@Override
	public void update() {}
}
