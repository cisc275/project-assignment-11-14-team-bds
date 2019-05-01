package models;

import java.util.*;

import entities.Bird;
import entities.Branch;
import entities.Collidable;
import entities.Enemy;
import entities.Osprey;
import entities.Powerup;
import entities.Path;
import entities.Tree;

public class OspreyModel extends Model {
	private Bird player = new Osprey();
	private List<Collidable> entities = new ArrayList<>();
	
	private Path lastPath = new Path(300, 0, 100, 20);
	
	public OspreyModel() {
		super();
		entities.add(player);
		entities.add(new Powerup());
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
			if (!inBounds(c)) {
				if (player.equals(c)) {
					player.setLoc(player.getX() - player.getXVel(), player.getY() - player.getYVel());
				} else {
					i.remove();
				}
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
	
	private boolean inBounds(Collidable c) {
		return 	(c.getX() > 0 && c.getX() < WIDTH) && (c.getY() > 0 && c.getY() < HEIGHT);
	}
	
	private void spawnEnemy() {
		Random r = new Random();
		int a = r.nextInt(40);
		if (a == 2) {
			entities.add(new Enemy(r.nextInt(WIDTH), 5, 125, 100));
		} else if (a == 1) {
			entities.add(new Tree(WIDTH, HEIGHT));
		}
		else if (a%2 == 0){
			entities.add(new Branch());
		}
	}
	
	private void spawnPath(Collidable prev) {
		Random r = new Random();
		int W = 200;
		int offset = r.nextInt(W/2) - (W/4);
		Path p = new Path(prev.getX() + offset, 0, W, 5);
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
