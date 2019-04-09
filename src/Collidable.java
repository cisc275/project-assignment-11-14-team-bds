public interface Collidable {
    public boolean collideWith(Collidable that);
    public void onCollide(Collidable that);
    public void render();
    public void update();
    public int getX();
    public int getY();
}
