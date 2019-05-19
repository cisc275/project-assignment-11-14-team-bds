package models;

import java.util.*;

import controllers.Randoms;
import entities.Bird;
import entities.Collidable;
import entities.Osprey;
import entities.Powerup;
import entities.PathHandler;
import entities.Tree;
import entities.Wind;
import entities.Pond;

public class OspreyModel extends Model {
	protected Bird player = new Osprey();
	protected List<Collidable> entities = new ArrayList<>();
	
	PathHandler pathHandler = new PathHandler(666);

	protected int prevX;
	protected int prevY;
	public OspreyModel() {
		super();
		entities.add(player);
		//entities.add(new Powerup());
		entities.add(pathHandler);
	}
	
	public void dive() {
		player.dive();
	}
	
	public void unDive() {
		player.unDive();
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
		Collections.sort(entities);
		prevX = player.getX();
		prevY = player.getY();
		Iterator<Collidable> i = entities.iterator();
		while (i.hasNext()) {
			Collidable c = i.next();
			c.update();

			if (!inBounds(c)) {
				if (player.equals(c)) {
					player.setLoc(prevX, prevY);
				} else if(c != pathHandler) {
					i.remove();
					continue;
				}
			}

			if (!player.equals(c)) {
				if (player.collideWith(c)) {
					player.onCollide(c);
				}
			}
		}
		spawnEnemy();
		pathHandler.generatePath();
	}
	
	@Override
	public List<Collidable> getEntities() {return entities;};
	
	private boolean inBounds(Collidable c) {
		return 	(c.getX() > 0 && c.getX() < WIDTH) && (c.getY() > 0 && c.getY() < HEIGHT );
	}
	
	private void spawnEnemy() {
		int a = Randoms.getRandomInt(120);
		if (a == 2) {
			//entities.add(new Enemy(r.nextInt(WIDTH), 5, 125, 100));
		} else if (a == 1) {
			entities.add(new Tree(WIDTH, HEIGHT));
		}
		else if (a == 3) {
			entities.add(new Wind(Randoms.getRandomInt(WIDTH), 5, 50,50));
		}
		else if (a == 4) {
			entities.add(new Pond(WIDTH, HEIGHT));
		}
		
	}

	@Override
	public void place() {
		// TODO Auto-generated method stub
		
	}
}
