package views.screens;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import controllers.Controller;
import entities.Collidable;
import models.ClapperRailModel;
import models.OspreyModel;
import views.View;

public class MenuScreen extends View{
	
	private ArrayList<JButton> buttons;
	private Controller controller;
	
	public MenuScreen(Controller c) {
		buttons = new ArrayList<JButton>();
		addButtons(buttons);
		frame = buildFrame(FRAME_WIDTH, FRAME_HEIGHT);
		setScreen(frame);
		controller = c;
	}
	
	@Override
	public void render() {
	}
	
	@Override
	public void setScreen(JFrame frame) {
		frame.setLayout(new FlowLayout());
		for (JButton b : buttons)
			frame.add(b);
	}
	
	private void buttonFactory(ArrayList<JButton> list, String name, ActionListener a)  {
		JButton b = new JButton(name);
		b.addActionListener(a);
		list.add(b);
	}
	
	private void addButtons(ArrayList<JButton> list) {
		buttonFactory(buttons, "Osprey", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
				System.out.println("Osprey");
				controller.switchInstance(new OspreyModel() , new OspreyLandScreen(frame));
			}
		});
		buttonFactory(buttons, "Clapper Rail", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
				System.out.println("clap");
				controller.switchInstance(new ClapperRailModel(), new ClapperScreen(frame));
			}
		});
		buttonFactory(buttons, "Exit", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
				System.exit(0);
			}
		});
	}

	@Override
	public void draw(List<Collidable> list) {
		// TODO Auto-generated method stub
		
	}

}
