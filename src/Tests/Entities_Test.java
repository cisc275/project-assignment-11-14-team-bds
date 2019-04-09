package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.*;
import views.*;
class Entities_Test {

	@Test
	void test_collidWith1() {
		Osprey o = new Osprey();
		Fish f = new Fish();
		assertTrue(f.collideWith(o));
	}
	@Test
	void test_collidWith2() {
		Osprey o = new Osprey();
		Cloud c = new Cloud();
		assertFalse(o.collideWith(c));
	}
	@Test
	void test_collidWith3() {
		Grass g = new Grass();
		Fish f = new Fish();
		assertFalse(f.collideWith(g));
	}
	
	@Test
	void test_onCollide1() {
		Osprey o = new Osprey();
		Fish f = new Fish();
		f.onCollide(o);
		assertTrue(o.isAlive());
	}
	@Test
	void test_onCollide2() {
		Osprey o = new Osprey();
		Cloud c = new Cloud();
		o.onCollide(c);
		assertFalse(o.isAlive());
	}
	@Test
	void test_onCollide3() {
		Grass g = new Grass();
		Fish f = new Fish();
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
	void test_update4() {
		Collidable o = new Osprey();
		backgroundElement b = new marsh();
		o.update();
		assertTrue(o.getX() < b.getWidth());
	}
	
	@Test
	void test_update5() {
		Collidable o = new Osprey();
		o.update();
		assertTrue(o.getY() > 0);
	}
	
	@Test
	void test_update6() {
		Collidable o = new Osprey();
		backgroundElement b = new marsh();
		o.update();
		assertTrue(o.getX() < b.getHeight());
	}
	
	@Test
	void test_collidWith5() {
		Osprey o = new Osprey();
		Collidable p = new Path();
		o.update();
		assertTrue(o.getY() < p.getX() + 50);
	}



}
