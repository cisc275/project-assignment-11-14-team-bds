package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy implements Collidable{

	protected int xPos;
	protected int yPos;
	
	protected int width;
	protected int height;
	
	public Enemy() {
		this(20,20,20,20);
	}
	
	public Enemy(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
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
		int left = getX() - (getWidth()/2);
		int top = getY() - (getHeight()/2);
		g.setColor(new Color(0,0,255));
		g.fillRect(left, top, getWidth(), getHeight());
	}

	@Override
	public void update() {
		this.yPos += 10;
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
