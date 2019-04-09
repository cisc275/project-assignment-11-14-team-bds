import org.junit.Test;
import static org.junit.Assert.*;

public class unitTestsBackground {
	marsh marsh1 = new marsh();
	backgroundElement marsh2 = marsh1;
	pond pond1 = new pond();
	assertEquals(marsh1,marsh2);
	assertEquals(0,pond1.fish());
}
