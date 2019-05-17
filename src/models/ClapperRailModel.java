package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.Bird;
import entities.ClapperRail;
import entities.Collidable;
import entities.Fox;
import entities.Grass;
import entities.Osprey;
import entities.Stick;
import entities.Nest;

public class ClapperRailModel extends Model {
  
	private Bird player = new ClapperRail();
	private Fox enemy = new Fox(300,300, 75, 75);
	private List<Collidable> entities = new ArrayList<>();
	private int sticksMap = 0;
	private int nestCost = 20;
	
	public ClapperRailModel() {
		super();
		entities.add(player);
		entities.add(enemy);
		entities.add(new Grass());
	}
	
	/**
	 @desc sets the players x velocity
	 @param int x - number of pixels to travel for x velocity
	 @return void
	 */
	@Override
	public void setPlayerX(int x) {
		player.setXVelocity(x);
	}

	/**
	 @desc sets the players y velocity
	 @param int y - number of pixels to travel for y velocity
	 @return void
	 */
	@Override
	public void setPlayerY(int x) {
		player.setYVelocity(x);
	}

	/**
	@desc handles collisions between game objects
	@return void
	 */
	@Override
	public void updateCollidables() {
		Collections.sort(entities);
		System.out.println(player.getCount());
		Iterator<Collidable> i = entities.iterator();
		enemy.findBird(player);
		while (i.hasNext()) {
			Collidable c = i.next();
			c.update();
			
			if (checkBounds(c) || c.shouldBeRemoved()) {
				i.remove();
				if (c instanceof Stick) {
					decSticksMap();
				}
			}
			
			if (!player.equals(c)) {
				if (player.collideWith(c)) {
					player.onCollide(c);
					c.onCollide(player);
				}
			}
		}
		spawnStick();
	}
	
	/**
	 @desc handles generation of sticks
	 @return void
	 */
	public void spawnStick() {
		Random r = new Random();
		if(r.nextInt(100) < 91 && sticksMap < 5) { //5% chance of spawn
			System.out.println("Stick spawned");
			entities.add(new Stick(r.nextInt(640), r.nextInt(480)));
			sticksMap = sticksMap + 1;
		}
	}
	
	/**
	 @desc decrement sticksMap value by 1
	 @return void
	 */
	public void decSticksMap() {
		sticksMap = sticksMap--;
	}
	
	/**
	 @desc spawns grass objects on screen
	 @return void
	 */
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
		player.dive();
		
	}

	@Override
	public void unDive() {
		player.unDive();
		
	}

	@Override
	public void place() {
		if (player.getCount() >= nestCost) {
			entities.add(new Nest(player.getX(), player.getY()));
			player.decCount(nestCost);
		}
	};
  
}
