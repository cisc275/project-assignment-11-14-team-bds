package views.screens;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Collidable;
import views.ImageHandler;
import views.View;

public class OspreyLandScreen extends View{
	
	List<Collidable> entities = new ArrayList<>();
	
	private int backgroundScrollAmount = 0;
	private final String BG_IMAGE_PATH = "res/bg.png";
	private BufferedImage backgroundImage;
	private int backgroundScrollSpeed = 2;
	
	public OspreyLandScreen(JFrame f) {
		backgroundImage = ImageHandler.loadImage(BG_IMAGE_PATH);
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
				//draw background first
				//draw it twice, one above and one below
				if(backgroundScrollAmount < FRAME_HEIGHT) { //probably not the best place for this to be
					backgroundScrollAmount += backgroundScrollSpeed;
				} else {
					backgroundScrollAmount = 0;
				}
				
				g.drawImage(backgroundImage, 0, backgroundScrollAmount-FRAME_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT * 3, null);
				g.drawImage(backgroundImage, 0, backgroundScrollAmount, FRAME_WIDTH, FRAME_HEIGHT * 3, null);
				
				for (Collidable c : entities) {
					c.render(g);
				}
			}
		};
		return p;
	}

}
