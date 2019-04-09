package entities;
public class Powerup implements Collidable {
    @Override
    public boolean collideWith(Collidable that){
        return false;
    }
    @Override
    public void onCollide(Collidable that){
        return;
    }
    @Override
    public void render() {
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

    public void giveEffect(Collidable that) {
        return;
    }
}
