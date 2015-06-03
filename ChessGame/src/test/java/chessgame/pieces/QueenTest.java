package chessgame.pieces;

import chessgame.board.Pieces;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {
    Pieces pieces;
    
    public QueenTest() {
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
    public void queenMovesCorrectly() {
        //Queen moved to the middle of the board
        pieces.move("D1", "D4");
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("B6"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("D6"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("F6"));
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("B4"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("F4"));
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C3"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("E3"));
    }
}
