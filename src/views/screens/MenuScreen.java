package views.screens;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.*;

import entities.Collidable;
import views.ImageHandler;

public class MenuScreen extends Screen {

	private ArrayList<JButton> buttons = new ArrayList<>();
	/*
	* Builds the menu screen with the passed width and height
	* @param w, width of the screen
	* @param h, height of the screen
	* */
	public MenuScreen(int w, int h) {
		super(w,h);
		this.setLayout(new FlowLayout());
		this.addButtons();
		for (JButton b : buttons) {
			this.add(b);
		}

		this.setVisible(true);
	}
	/*
	* Build each Button, add an event listener to each button
	* */
	private void buttonFactory(ArrayList<JButton> list, String name, ActionListener a) {
		JButton b = new JButton(name);
		b.addActionListener(a);
		list.add(b);
	}
	
	/*
	* Build each Button, add an event listener to each button
	* */
	private void buttonFactory(ArrayList<JButton> list, BufferedImage image, ActionListener a) {
		JButton b = new JButton();
		b.setBorderPainted(false);
		b.setBorder(null);
		b.setMargin(new Insets(0, 0, 0, 0));
		b.setContentAreaFilled(false);
		b.setIcon(new ImageIcon(image));
		b.addActionListener(a);
		list.add(b);
	}
	
	/*
	* Called once, builds the necessary buttons for the screen
	* */
	private void addButtons() {
		buttonFactory(buttons, ImageHandler.loadImage("res/OspreyMenu.png"), (e) -> {
			System.out.println("Osprey");
		});
		buttonFactory(buttons, ImageHandler.loadImage("res/Clapper Menu.png"), (e) -> {
			System.out.println("clap");
		});
		buttonFactory(buttons, "Exit", (e) -> {
			System.exit(0);
		});
	}
	/*
	* Return a list of buttons
	* @return list of JButtons
	* */
	@Override
	public List<JButton> getButtons() {
		return buttons;
	}
	/*
	* No entities should be rendered on the menu screen
	 */
	@Override
	public void render(List<Collidable> c) {}
}
