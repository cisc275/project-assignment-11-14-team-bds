package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.*;
import views.*;

class View_Test {

	@Test
	void test_aspect_ratio() {
		BackgroundElement b = new Marsh();
		assertEquals(b.getWidth(), b.getHeight() );
	}
	
	@Test
	void test() {
		Marsh marsh1 = new Marsh();
		BackgroundElement marsh2 = marsh1;
		Pond pond1 = new Pond(0, 0);
		assertEquals(marsh1,marsh2);
		assertEquals(0,pond1.fish());
	}
	
	@Test
	void test_hud() {
		MiniMap map = new MiniMap();
		Stick sticks = new Stick(0, 0);
		Powerup powUp = new Powerup();
		
		HUD Hud = new HUD(map, sticks, powUp);
		MiniMap map2 = Hud.getMap();
		Stick sticks2 = Hud.getSticks();
		Powerup powUp2 = Hud.getPowUp();
		
		assertEquals(map, map2);
		assertEquals(sticks, sticks2);
		assertEquals(powUp, powUp2);
	}

}
