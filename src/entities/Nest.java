package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Nest extends Collidable {

	public Nest(int x, int y) {
		super(x, y, 50, 50, 1);
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
		int left = getX() - (getWidth() / 2);
		int top = getY() - (getHeight() / 2);
		g.setColor(Color.BLACK);
		g.fillRect(left, top, this.width, this.height);
	}

	@Override
	public void update() {
	}
}
