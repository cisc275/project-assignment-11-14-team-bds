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

	public ClapperScreen(int w, int h) {
		super(w,h);
	}

	@Override
	public void render(Collection<Collidable> list) {
		entities = list;
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(0,255,0));
		g.drawString("This is the Clapper Rail Game", FRAME_WIDTH / 2, FRAME_HEIGHT / 2);

		for (Collidable c : entities) {
			c.render(g);
		}
	}
}
