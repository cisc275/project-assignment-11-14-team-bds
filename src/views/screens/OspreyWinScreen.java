package views.screens;

import entities.Collidable;

import java.awt.*;
import java.util.Collection;

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
    public void render(Collection<Collidable> c ) {}


}
