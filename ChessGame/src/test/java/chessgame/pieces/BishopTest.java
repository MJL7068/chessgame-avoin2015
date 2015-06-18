package chessgame.pieces;

import chessgame.board.Pieces;
import javax.swing.ImageIcon;
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
        
        //Pieces on the way removed
        pieces.removePiece("A1");
        pieces.removePiece("B2");
        pieces.removePiece("A7");
        pieces.removePiece("G7");
        pieces.removePiece("F2");
        pieces.removePiece("G1");
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("A1"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("A7"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("G1"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("H8"));
        
        pieces.move("D4", "D5");
        pieces.removePiece("G2");
        pieces.removePiece("H1");
        
        assertTrue(true == pieces.getPiece("D5").returnPossibleSquares(pieces).contains("H1"));
    }
    
    @Test
    public void bishopCanAttackEnemyPieces() {
        //Bishop moved in to position
        pieces.move("C1", "D4");
        
        //Enemy pieces moved into position
        pieces.move("A7", "C3");
        pieces.move("B7", "E3");
        pieces.move("C7", "C5");
        pieces.move("D7", "E5");
        
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C3"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("E3"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C5"));
        assertTrue(true == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("E5"));
    }    
    
    @Test
    public void returNotationWorks() {
        assertEquals("B", pieces.getPiece("C1").returnNotation());
        assertEquals("b", pieces.getPiece("C8").returnNotation());
    }
    
    @Test
    public void getImageWorks() {
        ImageIcon whiteBishopImage = pieces.getPiece("C1").getImage();
        assertEquals("bishopWhite.png", whiteBishopImage.getDescription());
        
        ImageIcon blackBishopImage = pieces.getPiece("C8").getImage();
        assertEquals("bishopBlack.png", blackBishopImage.getDescription());
    } 

}
