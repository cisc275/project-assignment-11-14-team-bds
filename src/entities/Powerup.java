package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Powerup extends Collidable {
	public Powerup() {
		super(320,240,50,50,2);
	}
	@Override
    public void onCollide(Collidable that){
    	// is there a better way of doing this?
    	if(that instanceof Bird) {
    		giveEffect((Bird)that);
    	}
    }
    @Override
    public void render(Graphics g) {
    	g.setColor(Color.YELLOW);
    	g.fillOval(getX(), getY() - height, getWidth(), getHeight());
    }

    @Override
    public void update() {
    }

	public void giveEffect(Bird bird) {
		System.out.println("got speed powerup!");
		bird.giveTimedPowerup(BirdProperties.SPEEDUP, 5000);
	}
}
