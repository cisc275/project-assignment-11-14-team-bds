package entities;
import java.awt.Graphics;

public class Cloud implements Collidable {
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
    	return 0;
    }
    @Override
    public int getHeight() {
    	return 0;
    }
}

