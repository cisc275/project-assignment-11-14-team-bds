package models;

import java.util.*;
import entities.*;


public abstract class Model {
	protected int WIDTH = 640;
	protected int HEIGHT = 480;
	
	protected final int ONESECOND = 1000;
	protected final int GAMEDURATION = 90;
	protected long initialTime = System.currentTimeMillis();
	
	
	public abstract void setPlayerX(int x);
	public abstract void setPlayerY(int y);
	public abstract void dive();
	public abstract void unDive();
	public abstract void updateCollidables();
	public abstract List<Collidable> getEntities(); 
	
	public boolean checkGameOver() {
		if ((System.currentTimeMillis() - initialTime) / ONESECOND >= GAMEDURATION) {
			return true;
		}
		return false;
	}
}