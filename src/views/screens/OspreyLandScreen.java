package views.screens;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.View;

public class OspreyLandScreen extends View{
	
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
	
	private JPanel buildScreen() {
		JPanel p = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(new Color(255,0,0));
				g.drawString("This is the Osprey Game", FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
			}
		};
		return p;
	}

}
