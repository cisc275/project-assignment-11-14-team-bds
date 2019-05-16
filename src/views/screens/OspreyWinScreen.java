package views.screens;

import entities.Collidable;

import java.util.Collection;
import java.util.List;
import java.awt.Graphics;

public class OspreyWinScreen extends Screen{

    public OspreyWinScreen(int w, int h) {
        super(w,h);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Osprey Win Screen \n \n woo1", 300,200);
    }

    @Override
    public void render(List<Collidable> c ) {}


}
