package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import entities.*;
import views.*;
class Entities_Test {

	
	@Test
	void test_Path() {
		Path p = new Path(0, 0, 0, 0);
	}
	
	@Test
	void test_collidWith1() {
		Osprey o = new Osprey();
		Fox f = new Fox(0, 0, 0, 0);
		assertTrue(f.collideWith(o));
	}
	@Test
	void test_collidWith2() {
		Osprey o = new Osprey();
		Wind c = new Wind(0, 0, 0, 0);
		assertFalse(o.collideWith(c));
	}
	@Test
	void test_collidWith3() {
		Grass g = new Grass();
		Fox f = new Fox(0, 0, 0, 0);
		assertFalse(f.collideWith(g));
	}
	
	@Test
	void test_onCollide1() {
		Osprey o = new Osprey();
		Fox f = new Fox(0, 0, 0, 0);
		f.onCollide(o);
		assertTrue(o.isAlive());
	}
	@Test
	void test_onCollide2() {
		Osprey o = new Osprey();
		Wind c = new Wind(0, 0, 0, 0);
		o.onCollide(c);
		assertFalse(o.isAlive());
	}
	@Test
	void test_onCollide3() {
		Grass g = new Grass();
		Fox f = new Fox(0, 0, 0, 0);
		f.onCollide(g);
		assertFalse(f.getX() != 0 && f.getY() != 0);
	}
	
	@Test
	void test_update() {
		Grass g = new Grass();
		Grass d = new Grass();
		g.update();
		assertFalse(g.getX() == d.getX());
	}
	@Test
	void test_update2() {
		Osprey o = new Osprey();
		int temp = o.getY();
		o.update();
		assertEquals(o.getY(), temp+5);
	}
	@Test
	void test_update3() {
		Collidable o = new Osprey();
		o.update();
		assertTrue(o.getX() > 0);
	}
	
	@Test
	void test_update5() {
		Collidable o = new Osprey();
		o.update();
		assertTrue(o.getY() > 0);
	}
	
	@Test
	void test_collidWith5() {
		Osprey o = new Osprey();
		Collidable p = new Path(0, 0, 0, 0);
		o.update();
		assertTrue(o.getY() < p.getX() + 50);
		assertFalse(p.collideWith(o));
	}
	
	@Test
	void test_collidWith6() {
		Osprey o = new Osprey();
		Enemy c = new Enemy();
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith7() {
		Osprey o = new Osprey();
		Nest c = new Nest(0, 0);
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith8() {
		Osprey o = new Osprey();
		Powerup c = new Powerup();
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith9() {
		Osprey o = new Osprey();
		Branch c = new Branch();
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith10() {
		Osprey o = new Osprey();
		Stick c = new Stick(0, 0);
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith11() {
		Osprey o = new Osprey();
		Pond c = new Pond(0, 0);
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith12() {
		Osprey o = new Osprey();
		Tree c = new Tree(0, 0);
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith13() {
		Osprey o = new Osprey();
		Grass c = new Grass();
		assertFalse(c.collideWith(o));
	}
	
	@Test
	void test_collidWith14() {
		Osprey o = new Osprey();
		ClapperRail c = new ClapperRail();
		assertFalse(c.collideWith(o));
	}
	
}


