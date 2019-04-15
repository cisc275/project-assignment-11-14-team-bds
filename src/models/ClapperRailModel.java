package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entities.Bird;
import entities.Clapper_Rail;
import entities.Collidable;
import entities.Osprey;

public class ClapperRailModel extends Model {
  
	private Bird player = new Clapper_Rail();
	private List<Collidable> entities = new ArrayList<>() ;
	
	public ClapperRailModel() {
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
