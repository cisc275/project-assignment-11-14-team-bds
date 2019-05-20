package views.screens;

import entities.Collidable;
import views.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.List;

public class OspreyWinScreen extends Screen{


    private String SCORE = "";
    private final String path = "res/Win.jpg";
    private BufferedImage background;
    /*
    * Builds the screen
    * @param w, width of the screen
    * @param h, height of the screen
    * */

    public void getScore(int a) {
        SCORE = Integer.toString(a);
    }
    public OspreyWinScreen(int w, int h) {
        super(w,h);
        background = ImageHandler.loadImage(path);
    }
    /*
    * Override the JPanel paintComponent method
    * Draws the screen to display a win state
    * */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawString("Osprey Win Screen \n \n woo1", 300,200);
        g.drawImage(background, 0, 0, FRAME_WIDTH, 600, null);
        g.setFont(new Font("SansSerif",Font.BOLD, 40));
        g.setColor(Color.BLACK);
        g.drawString(SCORE, 200, 650);
    }

    /*
    * Renders the entities
    * no entities should be rendered on this screen
    * */
    @Override
    public void render(List<Collidable> c ) {}


}
