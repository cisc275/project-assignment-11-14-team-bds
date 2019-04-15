package entities;

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
	public void eat(){
		health += 15;
	}
	public int getHealth(){
		return health;
	}

    @Override
    public boolean collideWith(Collidable that){
        return false;
    }
    @Override
    public void onCollide(Collidable that){
        return;
    }
    @Override
    public void render(Graphics g) {
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
