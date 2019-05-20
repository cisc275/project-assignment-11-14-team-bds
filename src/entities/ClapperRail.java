package entities;

import java.awt.Graphics;

public class ClapperRail extends Bird{
	private int branches;
	private boolean invisible;
	private Sprite sprite;
	
	
	public ClapperRail() {
		this.width = 50;
		this.height = 50;
		sprite = new Sprite(1, "res/clapper-rail.png");
	}
	
	@Override
    public void render(Graphics g) {
		int top = this.xPos - (this.width /2);
		int left = this.yPos - (this.height /2 );
		g.drawImage(sprite.getCurrentFrame(), top, left, this.width, this.height, null);
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

