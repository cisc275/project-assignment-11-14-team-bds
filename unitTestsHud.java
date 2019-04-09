import org.junit.Test;
import static org.junit.Assert.*;

public class unitTestsHud {
	miniMap map = new miniMap();
	stick sticks = new stick();
	powerUp powUp = new powerUp();
	
	hud Hud = new hud(map, sticks, powUp);
	miniMap map2 = Hud.getMap();
	stick sticks2 = Hud.getSticks();
	powerUp powUp2 = Hud.getPowUp();
	
	assertEquals(map, map2);
	assertEquals(sticks, sticks2);
	assertEquals(powUp, powUp2);
}
