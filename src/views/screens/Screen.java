package views.screens;

import entities.Collidable;
import views.View;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

public abstract class Screen extends JPanel {

    public final int FRAME_HEIGHT;
    public final int FRAME_WIDTH;
    protected View view;

    protected boolean flag1;
    protected boolean flag2;
    protected boolean flag3;
    /*
    * Sets the size of the frame
    * @param w, frame width
    * @param h, frame height
    * */
    public Screen(int w, int h, View v) {
        this(w,h);
        view = v;
    }

    public Screen(int w, int h) {
        FRAME_HEIGHT = h;
        FRAME_WIDTH = w;
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


    public void getScore(int a) {}

    public void setf1(boolean b) {
        flag1 = b;
    }
    public void setf2(boolean b) { flag2 = b; }
    public void setf3(boolean b) { flag3 = b; }
}
