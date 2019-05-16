package entities;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Bird extends Collidable {
	public static final int MAX_HEALTH = 100;
	protected int health = 100;
	private int pathHealth = 100;
	private int counter = 0;
	private boolean invincible = false;
	private boolean wind = false;
	private boolean diving = false;
	private boolean hidden = false;
	
	protected int xDir;
	protected int yDir;
	private float speedMultiplier = 1f;
	
	public Bird(){
		super(320, 400, 30, 30, 0);
		this.health = 100;
	}
	public void setXVelocity(int x) {
		this.xDir = x;
	}
	public void setYVelocity(int y) {
		this.yDir = y;
	}
	
	public void setHidden(boolean h) {
		hidden = h;
	}
	
	public void setYVelocity() {
		this.yDir = 2;
	}
	public void setXVelocity() {
		this.xDir = 0;
	}
	
	public void incCount() {
		counter = counter + 1;
	}
	
	public void decCount(int dec) {
		counter = counter - dec;
		if (counter < 0)
			counter = 0;
	}
	
	public int getCount() {
		return counter;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public boolean isDiving() {
		return diving;
	}

	public void dive() {
		diving = true;
	}
	
	public void unDive() {
		diving = false;
	}
	
	public void decHealth(int damage) {
		health -= damage;
		System.out.println("Damage taken: " + damage);
		if (health <= 0) {
			System.out.println("Game Over!");
		}
	}
	
	public void incHealth(int damage) {
		health += damage;
		System.out.println("Damage healed: " + damage);
		if (health >= MAX_HEALTH) {
			health = MAX_HEALTH;
		}
	}
	
	public void pushBird(int direction, int moveDis, int time) {
		if (wind) {
			return;
		}
		Timer t = new Timer(time, (e) -> {
			setXVelocity();
			setYVelocity();
			wind = false;
		});
		t.setRepeats(false);
		t.start();

		switch (direction) {
			case 0: //north
				setYVelocity(-moveDis);
				System.out.println("north");
				break;
			case 1: //south
				setYVelocity(moveDis);
				System.out.println("south");
				break;
			case 2: //east
				setXVelocity(moveDis);
				System.out.println("east");
				break;
			case 3: //west
				System.out.println("west");
				setXVelocity(-moveDis);
				break;
		}
		wind  = true;
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
    	//System.out.println("Collision: Bird");
    	that.onCollide(this);
    	if (that instanceof Path) {
    		pathHealth = pathHealth + 5;
    		if (pathHealth > 100) {
    			pathHealth = 100;
    		}
    	}
    	if (!(that instanceof Grass) && !(that instanceof Enemy)) {
    		setHidden(false);
    	}
    	if (that instanceof Enemy) {
    		decCount(counter);
    	}
    }
    
    
    @Override
    public void update() {
        this.xPos += this.xDir * speedMultiplier;
        this.yPos += this.yDir * speedMultiplier;
        pathHealth = pathHealth - 1;
        //hidden = false;

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
