import org.junit.Test;
import static org.junit.Assert.*;
import view.*;
import model.*;

public class ModelTest {
    @Test
    public void testGameState() {
		View v = new View();
		Model m = new Model();
		m.registerView(v);

		// Make a move for player 1 on the upper left corner of board
		m.PlayMove(0,0);
		// test value of moves count
		assertEquals (8, m.getMovesCount());
		// test value of the tile on the board
        assertEquals ('X', m.getBoard()[0][0]);
        // test reset model
        m.ResetModel();
        // get count of moves
        assertEquals (9, m.getMovesCount());

    }
}