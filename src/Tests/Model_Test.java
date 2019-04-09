package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import models.*;
class Model_Test {

	@Test
	void test_update() {
		ClapperRailModel c = new ClapperRailModel();
		Collection s = c.getEntities();
		c.updateCollidables();
		assertEquals(c.getEntities() , s);
	}

}
