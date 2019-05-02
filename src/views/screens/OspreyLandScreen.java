package views.screens;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import views.View;

public class OspreyLandScreen extends View{
	
	List<Collidable> entities = new ArrayList<>();
	
	public OspreyLandScreen(JFrame f) {
		frame = f;
		setScreen(frame);
	}

	@Override
	public void render() {
		frame.repaint();
	}

	@Override
	public void setScreen(JFrame frame) {
		frame.setLayout(null);
		frame.setContentPane(buildScreen());
		frame.setVisible(true);
	}
	
	public void draw(List<Collidable> list) {
		entities = list;
	}
	
	private JPanel buildScreen() {
		JPanel p = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.setColor(new Color(255,0,0));
				g.drawString("This is the Osprey Game", FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
				
				for (Collidable c : entities) {
					c.render(g);
				}
			}
		};
		return p;
	}

}
