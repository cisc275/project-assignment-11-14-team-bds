package entities;
public class Bird implements Collidable{
	int health;
	Object powerUp;
	int xPos;
	int yPos;
	Bird(){
		this.health = 100;
		this.xPos = 0;
		this.yPos = 0;
	}
	public void move(int x, int y){
		xPos += x;
		yPos += y;
	}
	public void eat(){
		health += 15;
	}
	public int getHealth(){
		return health;
	}
	public void updatePowerUp(Object power_up){
		powerUp = power_up;
	}

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

}
