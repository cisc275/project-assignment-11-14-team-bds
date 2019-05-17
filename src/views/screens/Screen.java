package views.screens;

import entities.Collidable;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

public abstract class Screen extends JPanel {

    public final int FRAME_HEIGHT;
    public final int FRAME_WIDTH;

    /*
    * Sets the size of the frame
    * @param w, frame width
    * @param h, frame height
    * */
    public Screen(int w, int h) {
        FRAME_WIDTH = w;
        FRAME_HEIGHT = h;
    }
  
    /*
    * Must be overridden
    * How the screen renders the entities
    * */
    public abstract void render(List<Collidable> c);
  
    /*
    * returns a list of buttons
    * returns null if there are no buttons on the screen
    * */
    public List<JButton> getButtons() {return null; }
}
