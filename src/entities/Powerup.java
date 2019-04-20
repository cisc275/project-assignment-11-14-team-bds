package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Powerup implements Collidable {
    @Override
    public boolean collideWith(Collidable that){
        return false;
    }
    @Override
    public void onCollide(Collidable that){
    	// is there a better way of doing this?
    	if(that instanceof Bird) {
    		giveEffect((Bird)that);
    		
    	}
        return;
    }
    @Override
    public void render(Graphics g) {
    	g.setColor(Color.YELLOW);
    	g.fillOval(getX(), getY(), getWidth(), getHeight());
        return;
    }
    @Override
    public void update() {
        return;
    }
    @Override
    public int getX(){
    	//TEMP
        return 320;
    }
    @Override
    public int getY() {
    	//TEMP
        return 240;
    }
	@Override
	public int getWidth() {
		//temp?
		return 50;
	}
	@Override
	public int getHeight() {
		//temp?
		return 50;
	}
	
	public void giveEffect(Bird bird) {
		System.out.println("got speed powerup!");
		bird.giveTimedPowerup(BirdProperties.SPEEDUP, 5000);
	}
}
