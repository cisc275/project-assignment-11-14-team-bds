package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Grass extends Collidable {
	
	public Grass() {
	    super(320,240, 0,0);
		Random r3 = new Random();
		this.width = 40;
		this.height = 40;
		
	}
    @Override
    public boolean collideWith(Collidable that){
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
    public void onCollide(Collidable that){
        if (that instanceof Bird) {
        	System.out.println("Hidden");
        	hide((Bird)that);
        }
        
    }
    
    public void hide(Bird b) {
    	b.setHidden(true);
    }
    
    @Override
    public void render(Graphics g) {
    	int left = getX() - (getWidth()/2);
		int top = getY() - (getHeight()/2);
    	g.setColor(Color.cyan);
    	g.fillRect(left, top,this.width,this.height);}
    @Override
    public void update() {
    }
}
