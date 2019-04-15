package controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.Timer;
import javax.swing.AbstractAction;


import models.*;
import views.*;
import views.screens.*;

public class Controller {

	private Model model;
	private View view;
	
	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
	}
	
	public void switchInstance(Model m, View v) {
		this.model = m;
		this.view = v;
	}
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer time = new Timer(100, new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	view.render();
                        }
                    });
                time.start();
            }
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
