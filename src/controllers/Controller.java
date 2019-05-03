package controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

import models.*;
import views.*;
import views.screens.*;

public class Controller {

	private Model model;
	private View view;
	
	private final int BIRD_X = 12;
	private final int BIRD_Y = 20;
	
	/*
	 * Constructor for the controller, takes in a model and a view
	 */
	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
	}
	
	/*
	 * Switch for controller, takes in model and view and sets a keyListener to the view
	 */
	public void switchInstance(Model m, View v) {
		this.model = m;
		this.view = v;
		setKeyListener(this.view);
	}
	/*
	 * Starts the game loop with a timer set to take actions every 50 ms
	 * Every time an action is performed the model's updateCollidables is called
	 * the view draws the list of entities from the model, and then the render function is called
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer time = new Timer(50, new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	model.updateCollidables();
                        	view.draw(model.getEntities());
                        	view.render();
                        }
                    });
                time.start();
            }
		});
	}
	/*
	 * Sets up a key listener to the view which increases the speed of the bird in the model
	 * depending on which key is pressed and then resets it back to 0 when you let go
	 */
	private void setKeyListener(View v) {
		JFrame frame = v.getFrame();
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e){
				int a = e.getKeyCode();
				switch(a) {
				case KeyEvent.VK_UP:
					model.setPlayerY(-BIRD_Y);
					break;
				case KeyEvent.VK_DOWN:
					model.setPlayerY(BIRD_Y);
					break;
				case KeyEvent.VK_LEFT:
					model.setPlayerX(-BIRD_X);
					break;
				case KeyEvent.VK_RIGHT:
					model.setPlayerX(BIRD_X);
					break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int a = e.getKeyCode();
				switch(a) {
				case KeyEvent.VK_UP:
					model.setPlayerY(0);
					break;
				case KeyEvent.VK_DOWN:
					model.setPlayerY(0);
					break;
				case KeyEvent.VK_LEFT:
					model.setPlayerX(0);
					break;
				case KeyEvent.VK_RIGHT:
					model.setPlayerX(0);
					break;
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}	
		});
	}
	
	public int getKeyPress() {return 0;};
	public int getMouseLoc() {return 0;};
	
	/*
	 * Creates a controller with the model and view of the menu from where
	 * the switch is called depending on which game is clicked and then the
	 * game gets started
	 */
	public static void main(String[] args) {
		Controller c = new Controller(null,null);
		Model m = new MenuModel();
		View v = new MenuScreen(c);
		c.switchInstance(m, v);
		c.start();
	}
}
