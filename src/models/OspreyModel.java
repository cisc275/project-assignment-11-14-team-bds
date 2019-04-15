package models;

import java.util.*;

import entities.Bird;
import entities.Collidable;
import entities.Osprey;

public class OspreyModel extends Model {
	private Bird player = new Osprey();
	private List<Collidable> entities = new ArrayList<>() ;
	
	public OspreyModel() {
		super();
		entities.add(player);
	}
	
	@Override
	public void setPlayerX(int x) {
		player.setXVelocity(x);
	}
	
	@Override
	public void setPlayerY(int x) {
		player.setYVelocity(x);
	}
	@Override
	public void updateCollidables() {
		for (Collidable c : entities) {
			c.update();
		}
	}
	@Override
	public List<Collidable> getEntities() {return entities;};
}
