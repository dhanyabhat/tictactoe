import org.junit.Test;
import static org.junit.Assert.*;

import view.*;
import controller.*;

public class ViewTest {
    @Test
    public void testGameState() {
		Controller c = new Controller();  
		View v = new View();  
		v.setActionListener(c);
		v.update(0,0,'x',"'O':  Player 2");
		assertEquals ("x", v.getButtonText(0,0));
    }

}