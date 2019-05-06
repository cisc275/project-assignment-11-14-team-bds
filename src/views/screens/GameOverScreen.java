package views.screens;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.Controller;
import entities.Collidable;
import models.ClapperRailModel;
import models.OspreyModel;
import views.View;

public class GameOverScreen extends View{
	
	private Controller controller;
	
	public GameOverScreen(Controller c) {
		frame = buildFrame(FRAME_WIDTH, FRAME_HEIGHT);
		setScreen(frame);
		controller = c;
	}
	
	@Override
	public void render() {
		//frame.add(new JLabel("You Win"));
	}
	
	@Override
	public void setScreen(JFrame frame) {
		frame.setLayout(new FlowLayout());
	}
	
	
	@Override
	public void draw(List<Collidable> list) {
		// TODO Auto-generated method stub
		
	}

}
