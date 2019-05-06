package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import entities.Bird;
import entities.Clapper_Rail;
import entities.Collidable;
import entities.Fox;
import entities.Grass;
import entities.Osprey;

public class ClapperRailModel extends Model {
  
	private Bird player = new Clapper_Rail();
	private Fox enemy = new Fox(300,300, 75, 75);
	private List<Collidable> entities = new ArrayList<>() ;
	
	public ClapperRailModel() {
		super();
		entities.add(player);
		entities.add(enemy);
		entities.add(new Grass());
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
		Iterator<Collidable> i = entities.iterator();
		enemy.findBird(player);
		while (i.hasNext()) {
			Collidable c = i.next();
			c.update();
			
			if (checkBounds(c)) {
				i.remove();
			}
			
			if (!player.equals(c)) {
				if (player.collideWith(c)) {
					player.onCollide(c);
					c.onCollide(player);
				}
			}
		}
	}
	public void spawnGrass() {
		entities.add(new Grass());
	}
	
	private boolean checkBounds(Collidable c) {
		//This really needs to be implemented later
		return false;
	}
	
	@Override
	public List<Collidable> getEntities() {return entities;}

	@Override
	public void dive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unDive() {
		// TODO Auto-generated method stub
		
	};
  
}
