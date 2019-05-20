package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import views.View;

public class PathHandler extends Collidable { //had to do this for rendering reasons

	Random r;
	private LinkedList<Path> paths = new LinkedList<Path>();
	private BufferedImage pathImage = null;
	
	public PathHandler() {
		super(0,0,View.FRAME_WIDTH,View.FRAME_HEIGHT,1);
		this.SCREEN_MOVE = 0;
		r = new Random();
	}

	public PathHandler(int seed) {
		this();
		r.setSeed(seed);
	}
	
/* OVERRIDDEN METHODS */
	/**
	 * Updates all of the Paths handled by this PathHandler, as well as the graphical connection lines between each path
	 */
	@Override
	public void update() {
		if(paths.size() > 0) {
			for(Path p : paths) {
				p.update();
			}
			
			if(!isInBounds(paths.getLast())) {
				removePath();
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		for(Path p : paths) {
			p.render(g);
		}
		g.drawImage(getPathImage(), this.xPos, this.yPos, this.width, this.height, null);
    }
	
	@Override
	public boolean collideWith(Collidable that) {
		return false;
    }
	
	@Override
    public void onCollideBird(Bird b) {
    }
	
	@Override
    public void onCollide(Collidable that) {
    	
    }
/* END OF OVERRIDDEN METHODS */
	
	private boolean isInBounds(Collidable c) {
		return c.yPos < View.FRAME_HEIGHT;
	}
	
	/**
	 * Adds a Path to the start of the list
	 * 
	 * @param path The path to be added
	 */
	public void addPath(Path path) {
		paths.addFirst(path);
		generatePathImage();
	}
	
	/**
	 * Generates a new path with smoothing based on the positions of previous paths
	 */
	public void generatePath() {
		if(paths.size() < 1) {
			addPath(new Path(640, 0, 100, 20));
		} 
		else {
			Path prev = paths.getFirst();
			int W = 200;
			int offset;
			do {
				offset = r.nextInt(W / 2) - (W / 4);
			} while (offset + prev.getX() < 100 || offset + prev.getX() > View.FRAME_WIDTH - 100 );
			Path p = new Path(prev.getX() + offset, 0, W, 5);
			addPath(p);
		}
	}
	
	/**
	 * Gets the head of the Path list
	 * 
	 * @return Head of the Path list
	 */
	public Path getHeadPath() {
		return paths.getFirst();
	}
	
	/**
	 * Returns the currently stored connecting image for Paths, or generates a new one if it doesn't already exist
	 * 
	 * @return Generated Path connecting image
	 */
	public BufferedImage getPathImage() {
		if(pathImage == null) {
			generatePathImage();
		}
		
		return pathImage;
	}
	
	/**
	 * Gets list of Paths
	 * 
	 * @return List of Paths
	 */
	public List<Path> getPathList() {
		return paths;
	}
	
	/**
	 * Removes a the first Path in the list
	 */
	private void removePath() {
		paths.removeLast();
		generatePathImage();
	}
	
	/**
	 * Generates an Image of arcs connecting the Paths currently in the list and assigns it to the pathImage variable.
	 */
	private void generatePathImage() {
		if(paths == null || paths.size() <= 1) {
			return;
		}
		
		BufferedImage img = new BufferedImage(View.FRAME_WIDTH, View.FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.RED);
		
		for(int i = 0; i < paths.size()-1; i++) {
			Path path1 = paths.get(i);
			Path path2 = paths.get(i+1);
			//int left = Math.min(path1.getX(), path2.getX()) - this.pathWidth/2;
			//int right = Math.max(path1.getX(), path2.getX()) - this.pathWidth/2;
			//g.drawArc(left, path1.getY() - pathHeight/2, right-left, pathHeight, 0, 45);
			g.drawLine(path1.xPos, path1.yPos, path2.xPos, path2.yPos);
			g.drawLine(path1.xPos + path1.width, path1.yPos, path2.xPos + path2.width, path2.yPos);
		}
		
		pathImage = img;
		g.dispose();
	}
}
