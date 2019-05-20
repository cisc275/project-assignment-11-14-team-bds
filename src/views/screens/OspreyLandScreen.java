package views.screens;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import entities.Sprite;
import views.ImageHandler;
import views.View;

public class OspreyLandScreen extends Screen{

	List<Collidable> entities;
	List<Sprite> sprites = new ArrayList<>();

	private int backgroundScrollAmount = 0;
	private final String BG_IMAGE_PATH = "res/bg.png";
	private BufferedImage backgroundImage;
	private int backgroundScrollSpeed = 2;

	private Sprite TREE1 = new Sprite(1, 1, "res/tree1.png");
	private Sprite TREE2 = new Sprite(1,1,"res/tree2.png");
	private Sprite LAKE = new Sprite(1,1,"res/lake.png");
	private Sprite CLOUD = new Sprite(1,1,"res/Cloud.png");
	private Sprite OSPREY = new Sprite(4,200, "res/Bird.png");
	/*
	* Builds the screen and adds the starting entities to the list
	* */
	public OspreyLandScreen(int w, int h) {
		super(w,h);
		backgroundImage = ImageHandler.loadImage(BG_IMAGE_PATH);

		sprites.add(TREE1);
		sprites.add(TREE2);
		sprites.add(LAKE);
		sprites.add(CLOUD);
		sprites.add(OSPREY);
	}

	/*
	* Redraws the collections, called once per tick
	* */
	@Override
	public void render(List<Collidable> c) {
		entities = c;
		this.repaint();
	}
	/*
	* Overrides the JPanel to specify how this screen should be drawn
	* */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draw background first
		//draw it twice, one above and one below
		if(backgroundScrollAmount < FRAME_HEIGHT) { //probably not the best place for this to be
			backgroundScrollAmount += backgroundScrollSpeed;
		} else {
			backgroundScrollAmount = 0;
		}

		g.drawImage(backgroundImage, 0, backgroundScrollAmount-FRAME_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT * 3, null);
		g.drawImage(backgroundImage, 0, backgroundScrollAmount, FRAME_WIDTH, FRAME_HEIGHT * 3, null);

		if (entities == null) {
			return;
		}
		
		for(Collidable c : entities) {
			c.render(g,sprites);
		}
		
		
	}
}
