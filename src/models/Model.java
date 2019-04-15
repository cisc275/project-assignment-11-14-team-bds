package models;

import java.util.*;
import entities.*;


public abstract class Model {
	protected int WIDTH = 640;
	protected int HEIGHT = 480;
	
	public abstract void setPlayerX(int x);
	public abstract void setPlayerY(int y);
	public abstract void updateCollidables();
	public abstract List<Collidable> getEntities(); 
  
}