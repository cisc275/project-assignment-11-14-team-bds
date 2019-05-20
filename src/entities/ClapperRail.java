package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ClapperRail extends Bird {
	private int branches;
	private boolean invisible;
	   private Sprite sprite;
	   private List<Sprite> sprites;

	public ClapperRail() {
		this.width = 50;
		this.height = 50;
		sprites = new ArrayList<>();
		sprite = new Sprite(1, "res/clapper-rail.png");
		sprites.add(new Sprite(3, 100, "res/railleft.png"));
		sprites.add(new Sprite(3, 100, "res/railright.png"));
	}

	@Override
	public void render(Graphics g) {
		int top = this.xPos - (this.width / 2);
		int left = this.yPos - (this.height / 2);
		g.drawImage(sprites.get(getDirection()).getCurrentFrame(), xPos, yPos - height, this.width, this.height, null);
	}
	
    private int getDirection() {
   	if (xDir > 0) {
   		return 1;
	} else if (xDir < 0) {
   		return 0;
	}
   	return 0;
   }

	@Override
	public void update() {
		if (diving) {
			xPos += xDir * .5;
			yPos += yDir * .5;
		} else {
			super.update();
		}
	}

	public int getNumBranches() {
		return this.branches;
	}

	public void incBranches() {
		branches = branches + 1;
	}

}
