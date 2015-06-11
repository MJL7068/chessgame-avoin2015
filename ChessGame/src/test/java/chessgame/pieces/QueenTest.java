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

    @Test
    public void queenCanAttackEnemyPieces() {
        //Queen moved to the middle of the board
        pieces.move("D1", "E4");
        
        //Pieces moved from the way
        pieces.removePiece("C2");
        pieces.removePiece("B1");
        pieces.removePiece("G2");
        pieces.removePiece("H1");
        pieces.removePiece("B7");
        pieces.removePiece("E2");
        pieces.removePiece("E7");
        
        //Enemy pieces moved to position
        pieces.move("A7", "B1");
        pieces.move("G7", "H1");
        pieces.move("D7", "E2");
        pieces.move("B8", "A4");
        pieces.move("G8", "H4");
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("B1"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("H1"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("A8"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("H7"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("E2"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("E7"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("A4"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("H4"));
    }
    @Test
    public void returNotationWorks() {
        assertEquals("Q", pieces.getPiece("D1").returnNotation());
        assertEquals("q", pieces.getPiece("D8").returnNotation());
    }
    
}
