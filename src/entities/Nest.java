package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Nest extends Collidable {
	
	private Sprite tempSprite;

	public Nest(int x, int y) {
		super(x, y, 50, 50, 1);
		tempSprite = new Sprite(1,1, "res/Nest.png");
	}

	@Override
	public boolean collideWith(Collidable that) {
		return false;
	}

	@Override
	public void onCollide(Collidable that) {
		return;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tempSprite.getCurrentFrame(), xPos, yPos - height, this.width, this.height, null);
	}

	@Override
	public void update() {
	}
}
