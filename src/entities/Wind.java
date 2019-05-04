package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Wind extends Collidable {
	
	private final int moveDis = 20;
	private int direction;
	static final int time = 500;
	
	public Wind(int x, int y, int w, int h) {
		super(x,y,w,h);
		Random r = new Random();
		direction = r.nextInt(4);

	}

	private String directionString(int d) {
		String s = "";
		switch (direction) {
			case 0:
				s = "North";
			break;
			case 1:
				s = "South";
			break;
			case 2:
				s = "East";
			break;
			case 3:
				s = "West";
			break;
		}
		return s;
	}
	@Override
	public void onCollide(Collidable that) {
		if (that instanceof Bird) {
			pushBird((Bird)that);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	    g.setColor(Color.BLACK);
		g.drawString(directionString(direction), getX(), getY() + 20);
	}

	public void pushBird(Bird bird) {
		bird.pushBird(direction, moveDis, time);
	}
}
