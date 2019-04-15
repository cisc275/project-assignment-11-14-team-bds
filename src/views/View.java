package views;

import java.util.List;

import javax.swing.JFrame;

import entities.Collidable;

public abstract class View {
	protected int FRAME_WIDTH = 640;
	protected int FRAME_HEIGHT = 480;
	
	protected JFrame frame;
	
	protected JFrame buildFrame(int w, int h) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(w, h);
		f.setFocusable(true);
		f.setVisible(true);
		return f;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public abstract void draw(List<Collidable> list);
	public abstract void render();
	public abstract void setScreen(JFrame frame);
}
