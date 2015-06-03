package chessgame.pieces;

import chessgame.board.Pieces;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class knightTest {
    Pieces pieces;
    
    public knightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pieces = new Pieces();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void knightMovesCorrectly() {
        //Knight moved to the middle of the board
        pieces.move("B1", "E4");
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("C5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("C3"));
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D6"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("F6"));
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("G5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("G3"));
    }
}
