package views.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import views.View;

public class ClapperScreen extends Screen{

	Collection<Collidable> entities = new ArrayList<>();
	/*
	* Builds the screen by the size w and h
	* */
	public ClapperScreen(int w, int h) {
		super(w,h);
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
		g.drawString("This is the Clapper Rail Game", FRAME_WIDTH / 2, FRAME_HEIGHT / 2);

		if (entities == null) {
			return;
		}
		for (Collidable c : entities) {
			c.render(g);
		}
	}
}
