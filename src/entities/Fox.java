package entities;

import java.awt.Graphics;

public class Fox extends Enemy {
   private int xDir = 0;
   private int yDir = 0;
   private int distance = 5;
   private Bird player;
   
   public Fox(int x, int y, int w, int h) {
	   super(x,y,w,h);
   }
	public void findBird(Bird b) {
		if (!b.isHidden()) {
	   xDir = (b.getX() - getX());
	   yDir = (b.getY() - getY());
	   double euclidean = Math.sqrt((xDir * xDir + yDir * yDir));
	   xDir /= (euclidean / distance);
	   yDir /= (euclidean / distance);
		}
		player = b;
		
   }
	
	@Override
	public void update() {
		xPos += xDir;
		yPos += yDir;
		findBird(player);
	}
}
