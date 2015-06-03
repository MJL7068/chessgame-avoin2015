package chessgame.pieces;


import chessgame.board.Pieces;
import chessgame.pieces.Rook;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    Pieces pieces;
    
    public RookTest() {
    }
    
    @Before
    public void setUp() {        
        pieces = new Pieces();
        
        pieces.move("A1", "D4");
    }
    
    @Test
    public void rookExists() {
        assertEquals("Rook, white: D4", pieces.getPiece("D4").toString());
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
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("D6"));
    }
    
    @Test
    public void rookCanMoveDown() {
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("D3"));
    }
    
    @Test
    public void rookCanMoveLeft() {
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("A4"));
    }
    
    @Test
    public void rookCanMoveRight() {
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("H4"));
    }   

}
