package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Fish extends Collidable {

	private int damage = 20;
	private boolean alreadyColl = false;

	public Fish(int x, int y, int w, int h) {
		super(x, y, w, h);
		Random r = new Random();
	}

	@Override
	public void onCollide(Collidable that) {
		if (that instanceof Bird) {
			incHealth((Bird) that);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void incHealth(Bird bird) {
		System.out.println("here be fish");
		if (!alreadyColl) {
			bird.incHealth(damage);
			alreadyColl = true;
		}
	}
}
