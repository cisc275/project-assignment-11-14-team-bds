package entities;

import java.awt.*;

public abstract class Collidable {
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected int SCREEN_MOVE = 10;
    public Collidable() {
        this(0,0,0,0);
    }
    public Collidable(int x, int y, int w, int h) {
        this.xPos = x;
        this.yPos = y;
        this.width = w;
        this.height = h;
    }
    public boolean collideWith(Collidable that) {
        if (this.getX() > that.getX() && this.getX() < (that.getX() + that.getWidth())) {
            if (this.getY() > that.getY() && this.getY() < (that.getY() + that.getHeight())) {
                return true;
            }
        }
        return false;

    }

    public void onCollideBird(Bird b) {
    }
    public void onCollide(Collidable that) {
        System.out.println("Overload this collision");
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
}
