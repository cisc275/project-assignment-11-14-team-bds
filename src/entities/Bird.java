package entities;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Bird implements Collidable {
	private int health;
	private boolean invincible = false;
	
	protected int xPos;
	protected int yPos;
	
	protected int width = 20;
	protected int height = 20;
	
	protected int xDir;
	protected int yDir;
	private float speedMultiplier = 1f;
	
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

	public void giveTimedPowerup(BirdProperties prop, int timeActive) {
		//add a timer to this somehow, return to default state after done
		setProperties(prop);
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer time = new Timer(timeActive, new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	System.out.println("powerup ran out!");
                        	setProperties(BirdProperties.DEFAULT);
                        }
                    });
                time.setRepeats(false); //only perform action once
                time.start();
            }
		});
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
		int left = xPos - (width/2);
		int top = yPos - (height/2);
    	g.setColor(new Color(255,0,0));
        g.fillOval(left, top, width, height);
    }
    @Override
    public void update() {
        this.xPos += this.xDir * speedMultiplier;
        this.yPos += this.yDir * speedMultiplier;
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

	public int getXVel() { return xDir; }
	public int getYVel() { return yDir; }

	public void setLoc(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	//Sets properties to match given BirdProperties
	private void setProperties(BirdProperties prop) {
		invincible = prop.invincible;
		speedMultiplier = prop.speedMultiplier;
	}

}
