package views.screens;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.*;

import entities.Collidable;

public class MenuScreen extends Screen {

	private ArrayList<JButton> buttons = new ArrayList<>();

	public MenuScreen(int w, int h) {
		super(w,h);
		this.setLayout(new FlowLayout());
		this.addButtons();
		for (JButton b : buttons) {
			this.add(b);
		}

		this.setVisible(true);
	}

	private void buttonFactory(ArrayList<JButton> list, String name, ActionListener a) {
		JButton b = new JButton(name);
		b.addActionListener(a);
		list.add(b);
	}

	private void addButtons() {
		buttonFactory(buttons, "Osprey", (e) -> {
				System.out.println("Osprey");
		});
		buttonFactory(buttons, "Clapper Rail",(e) -> {
				System.out.println("clap");
		});
		buttonFactory(buttons, "Exit", (e) -> {
				System.exit(0);
		});
	}

	@Override
	public List<JButton> getButtons() {
		return buttons;
	}

	@Override
	public void render(List<Collidable> c) {}
}
