public class Bird{
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


}
