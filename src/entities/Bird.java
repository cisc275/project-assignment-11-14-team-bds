package entities;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Bird extends Collidable {
	private int health;
	private boolean invincible = false;
	
	protected int xDir;
	protected int yDir;
	private float speedMultiplier = 1f;
	
	public Bird(){
		super(320, 400, 30,30);
		this.health = 100;
	}
	public void setXVelocity(int x) {
		this.xDir = x;
	}
	public void setYVelocity(int y) {
		this.yDir = y;
	}
	
	public void setYVelocity() {
		this.yDir = 2;
	}
	public void setXVelocity() {
		this.xDir = 0;
	}
	
	public void pushBird(int direction, int moveDis) {
		switch (direction) {
		case 0: //north
			yPos -= moveDis;
			System.out.println("north");
			break;
		case 1: //south
			yPos += moveDis;
			System.out.println("south");
			break;
		case 2: //east
			xPos += moveDis;
			System.out.println("east");
			break;
		case 3: //west
			System.out.println("west");
			xPos -= moveDis;
			break;
		
		}
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
    public void onCollide(Collidable that){
    	System.out.println("Collision: Bird");
        return;
    }
    @Override
    public void update() {
        this.xPos += this.xDir * speedMultiplier;
        this.yPos += this.yDir * speedMultiplier;
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
