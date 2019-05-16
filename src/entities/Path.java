package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Path extends Collidable {

	public Path(int x, int y, int w, int h) {
		super(x,y,w,h,1);
		this.SCREEN_MOVE = 5;
	}

	@Override
	public void onCollide(Collidable c) {

	}

	public void render(Graphics g) {
		g.setColor(new Color(0,0,255,100));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
