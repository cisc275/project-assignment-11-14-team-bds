package entities;


import java.awt.*;
import java.util.List;
import java.util.Random;

public class Tree extends Collidable {

	private final int SPRITE;
	private Sprite tempSprite;
	private int damage = 50;
	private boolean alreadyColl = false;
	
	public Tree(int w, int h) {
		super(0,0,100,175);
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;
		this.SCREEN_MOVE = 2;
		SPRITE = r.nextInt(2);
	}
	@Override
	public void onCollide(Collidable that) {
		//System.out.println("tree");
		if (that instanceof Bird) {
			decHealth((Bird)that);
		}
	}

	@Override
	public void render(Graphics g, List<Sprite> c) {
		g.drawImage(c.get(SPRITE).getCurrentFrame(), xPos, yPos, this.width, this.height, null);
	}
	
	public void decHealth(Bird bird) {
		if (!alreadyColl) {
			bird.decHealth(damage);
			alreadyColl = true;
		}
	}
}
