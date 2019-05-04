package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Path extends Collidable {

	public Path(int x, int y, int w, int h) {
		super(x,y,w,h);
		this.SCREEN_MOVE = 5;
	}
	public void render(Graphics g) {
		g.setColor(new Color(0,255,0,30));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
