package chessgame.pieces;


import chessgame.pieces.Rook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    Rook rook;
    
    public RookTest() {
    }
    
    @Before
    public void setUp() {
        rook = new Rook(1, 1, "white");
    }
    
    @Test
    public void constructorSetsVariablesCorrectly() {
        assertEquals("Rook, white: A1", rook.toString());
    }
    
    @Test
    public void moveWorksCorrectly() {
        rook.move("D1");
        assertEquals("Rook, white: D1", rook.toString());
    }
    
    @Test
    public void getLocationWorksCorrectly() {
        rook.move("A7");
        assertEquals("A7", rook.getLocation());
    }
    
    @Test
    public void toStringWorksCorrectly() {
        assertEquals("Rook, white: " + rook.getLocation(), rook.toString());
    }

}
