package models;

import java.util.*;
import entities.*;


public abstract class Model {
	protected int WIDTH = 640;
	protected int HEIGHT = 480;
	
	protected final int ONESECOND = 1000;
	protected long initialTime = System.currentTimeMillis();
	
	private boolean hasOccured = false;
	
	
	public abstract void setPlayerX(int x);
	public abstract void setPlayerY(int y);
	public abstract void dive();
	public abstract void unDive();
	public abstract void updateCollidables();
	public abstract List<Collidable> getEntities(); 

	public boolean checkGameState(int duration) {
		long timeElapsed = System.currentTimeMillis() - initialTime;
 		if (timeElapsed / ONESECOND >= duration && !hasOccured) {
			System.out.println("Method invoked");
			hasOccured = true;
			return true;
		}
		return false;
	}
}