package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Branch implements Collidable {
	public int xpos;
	public int ypos;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 10;
	public static final int MOVE_SPEED = 10;
	public Branch() {
		Random r1 = new Random();
		Random r2 = new Random();
		this.xpos = 0 + r1.nextInt(500);
		this.ypos =0;
		
	}
	@Override
	public boolean collideWith(Collidable that) {
		// TODO Auto-generated method stub
		if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
    		if (this.getY() > that.getY() && this.getY() < (that.getY() + that.getHeight())) {
    			return true;
    			}
    		}
		else{
			return false;
		}
		return false;
	}

	@Override
	public void onCollide(Collidable that) {
		// TODO Auto-generated method stub
		
			System.out.println("Branch");
			
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(xpos, ypos, WIDTH, HEIGHT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		ypos += this.MOVE_SPEED;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xpos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return ypos;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return WIDTH;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return HEIGHT;
	}

}
