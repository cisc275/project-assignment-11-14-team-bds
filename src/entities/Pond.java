package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Pond extends Collidable {
	
	private int numFish;
	Collection<Fish> fish = new ArrayList();
	
	
	public Pond(int w, int h) {
		super(0, 0, 100, 100);
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;
		numFish = r.nextInt(2) + 1;
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
	
	public void spawnFish() {
		Random w = new Random();
		int i = 0;
		while (i<numFish) {
			fish.add(new Fish(w.nextInt(this.width) + this.getX(), 
					w.nextInt(this.height) + this.getY(), 20, 20));
		}
	}
	
	public Collection getFish() {
		return fish;
	}

	public void pushBird(Bird bird) {
		if (bird.isDiving()) {
			
		}
	}
}
