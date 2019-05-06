package views.screens;

import entities.Collidable;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

public abstract class Screen extends JPanel {

    public final int FRAME_HEIGHT;
    public final int FRAME_WIDTH;

    public Screen(int w, int h) {
        FRAME_WIDTH = w;
        FRAME_HEIGHT = h;
    }
    public abstract void render(Collection<Collidable> c);

    public List<JButton> getButtons() {return null; }
}
