package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.*;
import views.*;

class View_Test {

	@Test
	void test_aspect_ratio() {
		backgroundElement b = new marsh();
		assertEquals(b.getWidth(), b.getHeight() );
	}
	
	@Test
	void test() {
		marsh marsh1 = new marsh();
		backgroundElement marsh2 = marsh1;
		pond pond1 = new pond();
		assertEquals(marsh1,marsh2);
		assertEquals(0,pond1.fish());
	}
	@Test
	void test_hud() {
		miniMap map = new miniMap();
		stick sticks = new stick();
		Powerup powUp = new Powerup();
		
		hud Hud = new hud(map, sticks, powUp);
		miniMap map2 = Hud.getMap();
		stick sticks2 = Hud.getSticks();
		Powerup powUp2 = Hud.getPowUp();
		
		assertEquals(map, map2);
		assertEquals(sticks, sticks2);
		assertEquals(powUp, powUp2);
	}

}
