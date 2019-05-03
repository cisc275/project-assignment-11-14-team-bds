package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Wind extends Enemy {
	
	public static final int MOVE_SPEED = 10;
	final int moveDis = 75;
	static int direction;
	
	public Wind(int w, int h) {
		width = 100;
		height = 50;
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;
		direction = r.nextInt(4);

	}

	@Override
	public void onCollide(Collidable that) {
		if (that instanceof Bird) {
			pushBird((Bird)that);
		}
	}

	@Override
	public void render(Graphics g) {
		int left = getX() - (getWidth() / 2);
		int top = getY() - (getHeight() / 2);
		g.setColor(Color.WHITE);
		g.fillRect(left, top, getWidth(), getHeight());
	}

	@Override
	public void update() {
		yPos += MOVE_SPEED;
		return;
	}

	public void pushBird(Bird bird) {
		bird.pushBird(Wind.direction, moveDis);
	}
}
