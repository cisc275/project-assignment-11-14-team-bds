package entities;

import java.awt.Graphics;
import java.util.List;

public class Fox extends Enemy {
   private int xDir = 0;
   private int yDir = 0;
   private int distance = 5;
   private Bird player;
   private Sprite sprite;
   
   public Fox(int x, int y, int w, int h) {
	   super(x,y,w,h);
	   sprite = new Sprite(1, "res/fox.png");
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
	public void render(Graphics g) {
		int left = xPos - (width/2);
        int top = yPos - (height/2);
		g.drawImage(sprite.getCurrentFrame(), left, top, this.width, this.height, null);
	}
	
	@Override
	public void update() {
		xPos += xDir;
		yPos += yDir;
		findBird(player);
	}
}
