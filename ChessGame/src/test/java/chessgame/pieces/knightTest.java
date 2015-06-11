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
    
    @Test
    public void knightCanMoveOnEnemySquare() {
        //Knight moved to the center of the board
        pieces.move("B1", "E4");
        //Opponents pieces moved into position
        pieces.move("A7", "F6");
        pieces.move("A8", "D2");
        pieces.move("B7", "D6");
        pieces.move("C7", "C5");
        pieces.move("D7", "C3");
        pieces.move("E7", "G5");
        pieces.move("F7", "G3");
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("F6"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D2"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D6"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("C5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("C3"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("G5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("G3"));
    }
    
    @Test
    public void knightAttacksFromTheSide() {
        //Knight moved into position
        pieces.move("B1", "H6");
        
        assertTrue(true == pieces.getPiece("H6").returnPossibleSquares(pieces).contains("F7"));
        assertTrue(true == pieces.getPiece("H6").returnPossibleSquares(pieces).contains("G8"));
        
        //Other knight moved into position
        pieces.move("G1", "A6");
        
        assertTrue(true == pieces.getPiece("A6").returnPossibleSquares(pieces).contains("B8"));
        assertTrue(true == pieces.getPiece("A6").returnPossibleSquares(pieces).contains("C7"));
    }
    
    @Test
    public void blackKnightAttacksFromTheSide() {
        //Knight moved into position
        pieces.move("B8", "A3");
        assertTrue(true == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("B1"));
        assertTrue(true == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("C2"));
        
        //Other knight moved into position
        pieces.move("G8", "H3");        
        assertTrue(true == pieces.getPiece("H3").returnPossibleSquares(pieces).contains("G1"));
        assertTrue(true == pieces.getPiece("H3").returnPossibleSquares(pieces).contains("F2"));
    }
    
    @Test
    public void returNotationWorks() {
        assertEquals("N", pieces.getPiece("B1").returnNotation());
        assertEquals("n", pieces.getPiece("B8").returnNotation());
    }
}
