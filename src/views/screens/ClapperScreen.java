package views.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import views.View;

public class ClapperScreen extends View{

	List<Collidable> entities = new ArrayList<>();
	
	public ClapperScreen(JFrame f) {
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
				g.setColor(new Color(0,255,0));
				g.drawString("This is the Clapper Rail Game", FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
				
				for (Collidable c : entities) {
					c.render(g);
				}
			}
		};
		return p;
	}


}
