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

	private int STARTX = WIDTH/2;
	private int STARTY = (int)(HEIGHT * .75);
	protected Bird player = new Osprey();
	protected List<Collidable> entities = new ArrayList<>();
	
	PathHandler pathHandler = new PathHandler(666);

	protected int prevX;
	protected int prevY;

	private long total = 0;
	private long score = 0;

	private int counter = 0;
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
		if (ending) {
			endUpdate();
		} else {
			Collections.sort(entities);
			prevX = player.getX();
			prevY = player.getY();
			Iterator<Collidable> i = entities.iterator();
			while (i.hasNext()) {
				Collidable c = i.next();
				c.update();

				if (!c.inBounds(WIDTH,HEIGHT)) {
					if (player.equals(c)) {
						player.setLoc(prevX, prevY);
					} else if (c != pathHandler) {
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
			total++;
			if (pathHandler.collideWith(player)) {
				score++;
				System.out.println("fixed this");
			}
			spawnEnemy();
			pathHandler.generatePath();
		}
	}

	private void endUpdate() {
		int xDir = STARTX - player.getX();
		int yDir = STARTY - player.getY();
		double euclid = Math.sqrt(xDir * xDir + yDir * yDir);
		if (euclid > 5) {
			xDir /= (euclid / 5);
			yDir /= (euclid / 5);
		}
		player.setXVelocity(xDir);
		player.setYVelocity(yDir);
		for (Collidable c : entities) {
			c.update();
		}
	}

	@Override
	public void endGame() {
		ending = true;
		entities.add(new Tree(WIDTH/2 - 50,-240, WIDTH, HEIGHT));
		//bird fly to tree
		//end screen
	}

	@Override
	public List<Collidable> getEntities() {return entities;};

	private boolean inBounds(Bird c) {
		return c.getX() > 0 && c.getX() < WIDTH && c.getY() > 0 && c.getY() + c.getHeight() < HEIGHT;
	}
	private boolean inBounds(Collidable c) {
		return 	(c.getX() > 0 && c.getX() < WIDTH) && (c.getY() > -250 && c.getY() < HEIGHT + 200 );
	}
	
	private void spawnEnemy() {
		int a = Randoms.getRandomInt(120);
		if (a == 2) {
			//entities.add(new Enemy(r.nextInt(WIDTH), 5, 125, 100));
		} else if (a == 1) {
			entities.add(new Tree(Randoms.getRandomInt(WIDTH), 5, WIDTH, HEIGHT));
		}
		else if (a == 3) {
			entities.add(new Wind(Randoms.getRandomInt(WIDTH), 5, 125,75));
		}
		else if (a == 4) {
			entities.add(new Pond(Randoms.getRandomInt(WIDTH), 5, WIDTH, HEIGHT));
		}
		
	}

	@Override
	public void place() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcScore() {
		int s = player.getScore();
		return (int) (s * (double) (score) / total);
	}
}
