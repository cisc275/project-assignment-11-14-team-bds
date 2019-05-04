package entities;

import java.awt.Graphics;

public class Nest extends Collidable {
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
}
