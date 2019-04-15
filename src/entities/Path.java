package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Path implements Collidable {

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	public Path(int x, int y, int w, int h) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}
	@Override
	public boolean collideWith(Collidable that) {
		return false;
	}

	@Override
	public void onCollide(Collidable that) {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(0,255,0,30));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void update() {
		yPos += 10;
		
	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
