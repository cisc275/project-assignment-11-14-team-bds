package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tree extends Collidable {


	public Tree(int w, int h) {
		super(0,0,50,50);
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;

	}
	@Override
	public void onCollide(Collidable that) {
		System.out.println("tree");
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(xPos, yPos, width, height);
	}
}
