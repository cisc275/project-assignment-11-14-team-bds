package entities;

import java.awt.Graphics;

public class Fish implements Collidable {
    @Override
    public boolean collideWith(Collidable that){
    	if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
    		if (this.getY() > that.getY() && this.getY() < (that.getY() + that.getHeight())) {
    			return true;
    		}
    	}
    	else {
    		return false;
    	}
    	return false;
    }
    @Override
    public void onCollide(Collidable that){
    	
    }
    @Override
    public void render(Graphics g) {
        return;
    }
    @Override
    public void update() {
        return;
    }
    @Override
    public int getX(){
        return 0;
    }
    @Override
    public int getY() {
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
