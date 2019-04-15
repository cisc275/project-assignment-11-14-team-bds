package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Tree implements Collidable {

	public static final int WIDTH = 150;
	public static final int HEIGHT = 50;
	public static final int MOVE_SPEED = 10;
	private int x = 0;
	private int y = 0;
	
	@Override
	public boolean collideWith(Collidable that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCollide(Collidable that) {
		// TODO Auto-generated method stub
		System.out.println("tree");
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		y += MOVE_SPEED;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
