package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Pond extends Collidable {
	private final int SPRITE = 1;
	private boolean alreadyColl = false;
	private int damage = 20;
	
	public Pond(int w, int h) {
		super(0, 0, 100, 100);
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;
	}

	@Override
	public void onCollide(Collidable that) {
		if (that instanceof Bird) {
			pushBird((Bird)that);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	    }
	

	public void pushBird(Bird bird) {
		if (bird.isDiving() && !alreadyColl) {
			bird.incHealth(damage);
			bird.incCount();
			alreadyColl = true;
		}
	}
}
