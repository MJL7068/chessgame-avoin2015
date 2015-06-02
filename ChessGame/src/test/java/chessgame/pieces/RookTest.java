package chessgame.pieces;


import chessgame.board.Pieces;
import chessgame.pieces.Rook;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    Rook rook;
    Pieces pieces;
    
    public RookTest() {
    }
    
    @Before
    public void setUp() {
        rook = new Rook(4, 4, "white");
        pieces = new Pieces();
    }
    
    @Test
    public void constructorSetsVariablesCorrectly() {
        assertEquals("Rook, white: D4", rook.toString());
    }
//    
//    @Test
//    public void moveWorksCorrectly() {
//        rook.move("D1");
//        assertEquals("Rook, white: D1", rook.toString());
//    }
//    
//    @Test
//    public void getLocationWorksCorrectly() {
//        rook.move("A7");
//        assertEquals("A7", rook.getLocation());
//    }
//    
//    @Test
//    public void toStringWorksCorrectly() {
//        assertEquals("Rook, white: " + rook.getLocation(), rook.toString());
//    }
    
    @Test
    public void rookCanMoveUp() {        
        assertTrue(true == rook.returnPossibleSquares(pieces).contains("D6"));
    }
    
    @Test
    public void rookCanMoveDown() {
        assertTrue(true == rook.returnPossibleSquares(pieces).contains("D3"));
    }
    
    @Test
    public void rookCanMoveLeft() {
        assertTrue(true == rook.returnPossibleSquares(pieces).contains("A4"));
    }
    
    @Test
    public void rookCanMoveRight() {
        assertTrue(true == rook.returnPossibleSquares(pieces).contains("H4"));
    }

}
