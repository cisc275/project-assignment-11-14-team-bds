package entities;

import java.awt.Graphics;

public interface Collidable {
    public boolean collideWith(Collidable that);
    public void onCollide(Collidable that);
    public void render(Graphics g);
    public void update();
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
}
