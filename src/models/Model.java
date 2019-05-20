package models;

import java.util.*;
import entities.*;


public abstract class Model {
	protected int WIDTH = 1280;
	protected int HEIGHT = 760;

	protected boolean flag1 = false;
	protected boolean flag2 = false;
	protected boolean flag3 = false;
	
	protected final int ONESECOND = 1000;
	protected long initialTime = System.currentTimeMillis();
	
	private boolean hasOccured = false;

	protected boolean ending = false;
	
	public abstract void setPlayerX(int x);
	public abstract void setPlayerY(int y);
	public abstract void dive();
	public abstract void unDive();
	public abstract void place();
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
	public void endGame() {

	}
	
	public int getCount() {
		return -1;
	}

	public int calcScore() {
		return 0;
	}

	public boolean getf1() {return flag1; }
	public boolean getf2() {return flag2; }
	public boolean getf3() {return flag3; }

}