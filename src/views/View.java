package views;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.smartcardio.Card;
import javax.swing.*;

import entities.Collidable;
import views.screens.*;

public class View {
	protected int FRAME_WIDTH = 640;
	protected int FRAME_HEIGHT = 480;

	public static final String MENU = "menu";
	public static final String OSPREY = "osprey";
	public static final String RAIL = "rail";
	public static final String OSPREY_WIN = "osprey_win";
	public static final String RAIL_WIN = "rail_win";
	public static final String QUIZ = "quiz";

	private Map<String, Screen> map = new HashMap<>();

	private  JFrame frame;
	private JPanel layer;
	private CardLayout layout;
	private  Screen screen;

	public View() {
		frame = buildFrame(FRAME_WIDTH, FRAME_HEIGHT);
		layout = buildLayout();
		layer = buildLayer();
		layer.setLayout(layout);
		frame.add(layer);
		layer.revalidate();
		screen = map.get(MENU);
	}
	/*
	* Asks the current screen to render the collection of entities
	* @params c, Collection of entities to render
	* */
	public void render(Collection<Collidable> c) {
		screen.render(c);
	}
	/*
	* Should be called once, creates the frame that contains the game
	* @params w, width of the frame
	* @param h, height of the frame
	* @return a new jFrame that displays the game
	* */
	private JFrame buildFrame(int w, int h) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(w, h);
		f.setFocusable(true);
		f.setVisible(true);
		return f;
	}
	/*
	* Builds teh card cardlayout to change screens easily
	* */
	private CardLayout buildLayout() {
		CardLayout c = new CardLayout();
		map.put(MENU, new MenuScreen(FRAME_WIDTH,FRAME_HEIGHT));
		c.addLayoutComponent(map.get(MENU), MENU);
		map.put(OSPREY, new OspreyLandScreen(FRAME_WIDTH,FRAME_HEIGHT));
		c.addLayoutComponent(map.get(OSPREY), OSPREY);
		map.put(RAIL, new ClapperScreen(FRAME_WIDTH,FRAME_HEIGHT));
		c.addLayoutComponent(map.get(RAIL), RAIL);
		map.put(OSPREY_WIN, new OspreyWinScreen(FRAME_WIDTH, FRAME_HEIGHT));
		c.addLayoutComponent(map.get(OSPREY_WIN), OSPREY_WIN);
		return c;
	}
	/*
	* Builds the initial JPane that sits in the JFrame
	* */
	private JPanel buildLayer() {
		JPanel layer = new JPanel();
		layer.add(map.get(MENU), MENU);
		layer.add(map.get(OSPREY), OSPREY);
		layer.add(map.get(RAIL), RAIL);
		layer.add(map.get(OSPREY_WIN), OSPREY_WIN);
		return layer;
	}
	/*
	* Return the JFrame to add listener hooks
	* @return the current JFrame
	* */
	public JFrame getFrame() {
		return this.frame;
	}

	/*
	* Returns buttons to add listeners
	* @return list of JButtons
	* */
	public List<JButton> getJButtion() {return screen.getButtons(); }

	/*
	* Sends an event to change to the proper screen
	* @params s a static constant defined in the View class
	* */
	public void changePanel(String s) {
		layout.show(layer, s);
		screen = map.get(s);
	}
}
