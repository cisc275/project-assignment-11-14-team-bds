package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import controllers.Randoms;

public class Pond extends Collidable {
	private final int SPRITE = 1;
	private boolean alreadyColl = false;
	private int damage = 20;

	public Pond(int x, int y, int w, int h) {
		this(w,h);
		xPos = x;
		yPos = y;
	}
	public Pond(int w, int h) {
		super(0, 0, 150, 100,2);
		xPos = Randoms.getRandomInt((w - width) + (height/ 2));
		yPos = 0;
		this.SCREEN_MOVE = 2;
	}

	@Override
	public void onCollide(Collidable that) {
		if (that instanceof Bird) {
			pushBird((Bird)that);
		}
	}

	@Override
	public void render(Graphics g, List<Sprite> c) {
		//g.setColor(Color.BLUE);
		//g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.drawImage(c.get(2).getCurrentFrame(), xPos, yPos - height, this.width, this.height, null);
	    }
	

	public void pushBird(Bird bird) {
		if (bird.isDiving() && !alreadyColl) {
			bird.incHealth(damage);
			bird.incCount();
			alreadyColl = true;
		}
	}
}
