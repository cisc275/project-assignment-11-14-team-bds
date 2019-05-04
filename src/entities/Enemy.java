package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Collidable{

	public Enemy() {
		this(30,30,50,50);
	}
	public Enemy(int x, int y, int w, int h) {
		super(x,y,w,h);
	}
}
