package controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.*;

import entities.Sprite;
import models.*;
import views.screens.Quiz;
import views.View;

public class Controller {

	private Model model;
	private View view;
	
	private final int BIRD_X = 8;
	private final int BIRD_Y = 10;
    private final int GAME_DURATION = 65;
    private final int SWITCH_GAME_STATE = 4;
    private final int REQ_STICK_AMOUNT = 3;

    private int cutscene = 380;
    private int count = 0;
    private boolean cuts = false;

	/**
		@desc Constructor for controller
		@param m - instance of model
		@param v - instance of view
	 */
	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;

		List<JButton> buttons = this.view.getJButtion();
		buttons.get(0).addActionListener((e) -> {
				OspreyModel player = new OspreyModel();
				setInstance(player, View.OSPREY);
			}
		);
		buttons.get(1).addActionListener((e) -> {
				ClapperRailModel player = new ClapperRailModel();
				setInstance(player, View.RAIL);
			}
		);
		setKeyListener(this.view);
	}

	/**
		@desc Switch for controller, takes in model and view and sets a keyListener to the view
		@param m - instance of model
		@param  s - string representing the view to switch to
		@return void
	 */
	public void setInstance(Model m, String s) {
		this.model = m;
		this.view.changePanel(s);
	}
	/**
		@desc Starts the game loop with a timer set to take actions every 50 ms
	 * 	Every time an action is performed the model's updateCollidables is called
	 * 	the view draws the list of entities from the model, and then the render function is called
	 	@return void
	*/
	public void start() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer time = new Timer(50, new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	if (model.checkGameState(GAME_DURATION)) {
                        		//setInstance(model, View.OSPREY_WIN);
								model.endGame();
								cuts = true;
								count = 0;
                        	};
                        	//model.checkGameState(SWITCH_GAME_STATE);
                            if (! view.getCurrentScreen().equals(View.QUIZ)) {
                                model.updateCollidables();
                                if (cuts) {
									count++;
								}
                            }
                            view.setf1(model.getf1());
                            view.setf2(model.getf2());
                            view.setf3(model.getf3());
							view.render(model.getEntities());
							if (count > cutscene) {
                            	count = 0;
                            	cuts = false;
                            	setInstance(model, View.OSPREY_WIN);
                            	view.getCurrentScreen().getScore(model.calcScore());
							}
                        }
                    });
                time.start();
            }
		});
	}
	/**
	 * @desc Sets up a key listener to the view which increases the speed of the bird in the model
	 * depending on which key is pressed and then resets it back to 0 when you let go
	 * @param v - instance of view to display
	 * @return void
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
					case KeyEvent.VK_SPACE:
						model.dive();
						break;
					//case KeyEvent.VK_SHIFT:
					//	model.place();
					//	break;
					case KeyEvent.VK_ESCAPE:
						setInstance(new MenuModel(), View.MENU);
						break;
					case KeyEvent.VK_SHIFT:
						if (model.getCount() >= REQ_STICK_AMOUNT) {
							model.place();
							setInstance(model, View.QUIZ);
						}
						break;
					case KeyEvent.VK_1:
						try {
							FileOutputStream f = new FileOutputStream("save.ser");
							ObjectOutputStream o = new ObjectOutputStream(f);
							o.writeObject(model);
							o.close();
						} catch (Exception except) {
							except.printStackTrace();
						}
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
				case KeyEvent.VK_SPACE:
					model.unDive();
					break;
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}	
		});
	}
	
	public int getKeyPress() {return 0;};
	public int getMouseLoc() {return 0;};
	
	 /**
	 	 @desc - creates a controller with the model and view of the menu from where
		 the switch is called depending on which game is clicked and then the game
		 starts
		 @param args
		 @return void
	  */
	public static void main(String[] args) {
		Model m = new MenuModel();
		View v = new View();
		Controller c = new Controller(m,v);
		c.setInstance(m, View.MENU);
		c.start();
	}
}
