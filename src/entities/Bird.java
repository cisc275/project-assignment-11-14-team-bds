package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Bird implements Collidable{
	private int health;
	protected int xPos;
	protected int yPos;
	
	protected int width = 20;
	protected int height = 20;
	
	protected int xDir;
	protected int yDir;
	
	public Bird(){
		this.health = 100;
		this.xPos = 0;
		this.yPos = 0;
	}
	public void setXVelocity(int x) {
		this.xDir = x;
	}
	public void setYVelocity(int x) {
		this.yDir = x;
	}
	
	public void setYVelocity() {
		this.yDir = 2;
	}
	public void setXVelocity() {
		this.xDir = 0;
	}

    @Override
    public boolean collideWith(Collidable that){
    	if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
    		if (this.getY() > that.getY() && this.getY() < (that.getY() + that.getHeight())) {
    			return true;
    		}
    	}
        return false;
    }
    @Override
    public void onCollide(Collidable that){
    	System.out.println("Collided");
        return;
    }
    @Override
    public void render(Graphics g) {
    	g.setColor(new Color(255,0,0));
        g.fillOval(xPos, yPos, width, height);
    }
    @Override
    public void update() {
        this.xPos += this.xDir;
        this.yPos += this.yDir;
    }
    @Override
    public int getX(){
        return xPos;
    }
    @Override
    public int getY() {
        return yPos;
    }
	@Override
	public int getWidth() {
		return this.width;
	}
	@Override
	public int getHeight() {
		return this.height;
	}

}
