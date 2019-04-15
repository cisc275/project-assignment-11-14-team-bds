package models;

import java.util.*;

import entities.Bird;
import entities.Collidable;
import entities.Enemy;
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
		if (x != 0)
			player.setXVelocity(x);
		else
			player.setXVelocity();
	}
	
	@Override
	public void setPlayerY(int x) {
		if (x != 0)
			player.setYVelocity(x);
		else 
			player.setYVelocity();
	}
	@Override
	public void updateCollidables() {
		Iterator<Collidable> i = entities.iterator();
		while (i.hasNext()) {
			Collidable c = i.next();
			c.update();
			
			if (checkBounds(c)) {
				i.remove();
			}
			
			if (!player.equals(c)) {
				if (player.collideWith(c)) {
					player.onCollide(c);
				}
			}
		}
		spawnEnemy();
	}
	@Override
	public List<Collidable> getEntities() {return entities;};
	
	private boolean checkBounds(Collidable c) {
		//This really needs to be implemented later
		return false;
	}
	
	private void spawnEnemy() {
		Random r = new Random();
		int a = r.nextInt(20);
		if (a == 0) {
			entities.add(new Enemy(r.nextInt(400), 0, 125, 100));
		}
	}
}
