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
    }
    
    @Test
    public void rookExists() {
        pieces.move("A1", "D4");
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
        pieces.move("A1", "A3");
        assertTrue(true == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("A7"));
    }
    
    @Test
    public void rookCanMoveDown() {
        pieces.move("A8", "A6");
        assertTrue(true == pieces.getPiece("A6").returnPossibleSquares(pieces).contains("A2"));
    }
    
    @Test
    public void rookCanMoveLeft() {
        pieces.move("A1", "A3");
        pieces.move("A7", "H3");
        assertTrue(true == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("H3"));
    }
    
    @Test
    public void rookCanMoveRight() {
        pieces.move("H8", "H6");
        pieces.move("A2", "A6");
        assertTrue(true == pieces.getPiece("H6").returnPossibleSquares(pieces).contains("A6"));
    }
    
    @Test
    public void returNotationWorks() {
        assertEquals("R", pieces.getPiece("A1").returnNotation());
        assertEquals("r", pieces.getPiece("A8").returnNotation());
    }

}
