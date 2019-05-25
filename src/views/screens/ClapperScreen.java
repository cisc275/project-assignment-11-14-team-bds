package views.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import entities.Sprite;
import views.ImageHandler;
import views.View;

public class ClapperScreen extends Screen{


	private final String BG_IMAGE_PATH = "res/ClapperRailBG.png";
	private BufferedImage background;
	Collection<Collidable> entities = new ArrayList<>();



	private Sprite sprite = new Sprite(1, "res/stick.png");

	Sprite t1 = new Sprite(1,1,"res/ClapperInstro1.png");
	Sprite t2 = new Sprite(1,1,"res/ClapperInstro2.png");
	Sprite t3 = new Sprite(1,1,"res/ClapperInstro3.png");
	/*
	* Builds the screen by the size w and h
	* */
	public ClapperScreen(int w, int h) {
		super(w,h);
		background= ImageHandler.loadImage(BG_IMAGE_PATH);
	}

	/*
	* called once to redraw the list
	 */
	@Override
	public void render(List<Collidable> list) {
		entities = list;
		this.repaint();
	}
	/*
	*  Overrides the JPane, how to draw the screen
	* */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(0,255,0));
		g.drawImage(background, 0,0,FRAME_WIDTH, FRAME_HEIGHT, null);
		if (entities == null) {
			return;
		}
		for (Collidable c : entities) {
			c.render(g);
		}
		if  (! flag1) {
			g.drawImage(t1.getCurrentFrame(),700,550,500,200,null);
		}
		if (flag1 && !flag2) {
			g.drawImage(t2.getCurrentFrame(),701,550,500,200,null);
		}
		if (flag3) {
			g.drawImage(t3.getCurrentFrame(),702,550,500,200,null);
		}

	}
}
