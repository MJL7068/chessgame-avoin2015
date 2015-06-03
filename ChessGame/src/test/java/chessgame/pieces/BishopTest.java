package chessgame.pieces;

import chessgame.board.Pieces;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {
    Pieces pieces;
    
    public BishopTest() {
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
    public void bishopMovesCorrectly() {
        //Bishop set in the middle of the board
        pieces.move("C1", "D4");
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("B6"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("F6"));
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C3"));
    }

}
