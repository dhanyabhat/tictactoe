import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import model.*;
import controller.*;
import view.*;

public class ControllerTest {
    @Test
    public void testGameState() {
		Controller c = new Controller();  
		Model m = new Model();  
		View v = new View();
		m.registerView(v);
		c.setModel(m);
		ArrayList<Integer> pos = new ArrayList<Integer>();
		pos.add(0);
		pos.add(0);
		c.setRequest(pos);
		// test if model is updated correctly
		assertEquals ('X', m.getBoard()[0][0]);
    }
}