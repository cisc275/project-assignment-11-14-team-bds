package entities;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

public abstract class Collidable implements Comparable<Collidable>, Serializable {
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected int renderPriority = 1;
    protected int SCREEN_MOVE = 10;
    protected boolean toBeRemoved = false;
    
    public Collidable() {
        this(0,0,0,0,1);
    }
    
    public Collidable(int renderPriority) {
    	this(0,0,0,0,renderPriority);
    }
    
    public Collidable(int x, int y, int w, int h, int renderPriority) {
        this.xPos = x;
        this.yPos = y;
        this.width = w;
        this.height = h;
        this.renderPriority = renderPriority;
    }
    public boolean collideWith(Collidable that) {
        if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
            if (this.getY() < that.getY() && this.getY() > (that.getY() - that.getHeight())) {
                return true;
            }
        }
        return false;

    }

    public void onCollideBird(Bird b) {
    }
    public void onCollide(Collidable that) {
        //System.out.println("Overload this collision");
    }

    public boolean inBounds(int w, int h) {
        return xPos > 0 && xPos + width < w && yPos > -250 && yPos < h + 250;
    }

    public void render(Graphics g, List<Sprite> c) {
        render(g);
    }

    public void render(Graphics g) {
        int left = xPos - (width/2);
        int top = yPos - (height/2);
        g.setColor(new Color(255,0,0));
        g.fillOval(left, top, width, height);
    }
    public void update() {
        this.yPos += SCREEN_MOVE;
    }
    public int getX() {
        return this.xPos;
    }
    public int getY(){
        return this.yPos;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public boolean shouldBeRemoved() {
    	return toBeRemoved;
    }
    
    @Override
    public int compareTo(Collidable c) {
    	return c.renderPriority - this.renderPriority;
    }
    
}
