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
	
	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
	}
	
	public void switchInstance(Model m, View v) {
		this.model = m;
		this.view = v;
		setKeyListener(this.view);
	}
	
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
	
	public static void main(String[] args) {
		Controller c = new Controller(null,null);
		Model m = new MenuModel();
		View v = new MenuScreen(c);
		c.switchInstance(m, v);
		c.start();
	}
}
