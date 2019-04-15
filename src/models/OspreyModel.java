package models;

import java.util.*;

import entities.Bird;
import entities.Collidable;
import entities.Enemy;
import entities.Osprey;
import entities.Path;

public class OspreyModel extends Model {
	private Bird player = new Osprey();
	private List<Collidable> entities = new ArrayList<>();
	
	private Path lastPath = new Path(300, 0, 100, 20);
	
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
			player.setYVelocity(2);
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
					c.onCollide(player);
				}
			}
		}
		spawnEnemy();
		spawnPath(lastPath);
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
	
	private void spawnPath(Collidable prev) {
		Random r = new Random();
		int offset = r.nextInt(100) - 50;
		Path p = new Path(prev.getX() + offset, 0, 150, 10);
		if (p.getX() > this.WIDTH) {
			p = new Path(this.WIDTH, p.getY(), p.getWidth(), p.getHeight());
		}
		else if (p.getX() < 0) {
			p = new Path(0, p.getY(), p.getWidth(), p.getHeight());
		}
		entities.add(p);
		lastPath = p;
	}
}
