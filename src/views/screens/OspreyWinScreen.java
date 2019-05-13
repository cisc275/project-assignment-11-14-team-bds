package views.screens;

import entities.Collidable;

import java.awt.*;
import java.util.Collection;

public class OspreyWinScreen extends Screen{

    /*
    * Builds the screen
    * @param w, width of the screen
    * @param h, height of the screen
    * */
    public OspreyWinScreen(int w, int h) {
        super(w,h);
    }
    /*
    * Override the JPanel paintComponent method
    * Draws the screen to display a win state
    * */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Osprey Win Screen \n \n woo1", 300,200);
    }

    /*
    * Renders the entities
    * no entities should be rendered on this screen
    * */
    @Override
    public void render(Collection<Collidable> c ) {}


}
