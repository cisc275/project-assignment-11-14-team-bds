package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Fox extends Enemy {
   private int xDir = 0;
   private int yDir = 0;
   private int distance = 7;
   private Bird player;
   private Sprite sprite;
   private List<Sprite> sprites;
   
   public Fox(int x, int y, int w, int h) {
	   super(x,y,w,h);
	   sprites = new ArrayList<>();
	   sprite = new Sprite(1, "res/fox.png");
	   sprites.add(new Sprite(4, 100,"res/fox/FoxUp.png"));
	   sprites.add(new Sprite(4, 100,"res/fox/FoxRight.png"));
	   sprites.add(new Sprite(4, 100,"res/fox/FoxDown.png"));
	   sprites.add(new Sprite(4, 100,"res/fox/FoxLeft.png"));
   }
	public void findBird(Bird b) {
		if (!b.isHidden()) {
			xDir = (b.getX() - getX());
			yDir = (b.getY() - getY());
			//double euclidean = Math.sqrt((xDir * xDir + yDir * yDir));
			//xDir /= (euclidean / distance);
			//yDir /= (euclidean / distance);
			if (Math.abs(xDir) > Math.abs(yDir)) {
				xDir = xDir > 0 ? distance : -distance;
				yDir = 0;
			} else {
				xDir = 0;
				yDir = yDir > 0 ? distance : -distance;
			}
		}
		player = b;
		
   }

    private int getDirection() {
   	if (xDir > 0) {
   		return 1;
	} else if (xDir < 0) {
   		return 3;
	} else if (yDir > 0) {
   		return 2;
	} else if (yDir < 0) {
   		return 0;
	}
   	return 0;
   }
	
	@Override
	public void render(Graphics g) {
		int left = xPos - (width/2);
        int top = yPos - (height/2);
		g.drawImage(sprites.get(getDirection()).getCurrentFrame(), xPos, yPos - height, this.width, this.height, null);
	}
	
	@Override
	public void update() {
		xPos += xDir;
		yPos += yDir;
		//findBird(player);
	}
}
