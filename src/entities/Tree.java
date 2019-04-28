package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tree extends Enemy {


	public static final int MOVE_SPEED = 10;


	public Tree(int w, int h) {
		width = 100;
		height = 50;
		Random r = new Random();
		xPos = r.nextInt(w - width) + (height/ 2);
		yPos = 0;

	}
	@Override
	public void onCollide(Collidable that) {
		// TODO Auto-generated method stub
		System.out.println("tree");
	}

	@Override
	public void render(Graphics g) {
		int left = xPos - (width/2);
		int top = yPos - (height/2);
		g.setColor(Color.GREEN);
		g.fillRect(left, top, width, height);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		yPos += MOVE_SPEED;
	}
}
