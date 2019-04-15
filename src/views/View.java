package views;

import javax.swing.JFrame;

public abstract class View {
	protected int FRAME_WIDTH = 640;
	protected int FRAME_HEIGHT = 480;
	
	protected JFrame frame;
	
	protected JFrame buildFrame(int w, int h) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(w, h);
		f.setVisible(true);
		return f;
	}
	
	public abstract void render();
	public abstract void setScreen(JFrame frame);
}
