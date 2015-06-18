package chessgame.pieces;

import chessgame.board.Pieces;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {
    Pieces pieces;
    
    public KingTest() {
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
    public void kingMovesCorrectly() {
        //King moved in the middle of the board
        pieces.move("E1", "E5");
        
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("D6"));
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("E6"));
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("F6"));
        assertTrue(false == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("G6"));
        
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("D5"));
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("F5"));
        
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("D4"));
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("E4"));
        assertTrue(true == pieces.getPiece("E5").returnPossibleSquares(pieces).contains("F4"));
    }
    
    @Test
    public void kingCanAttackEnemyPieces() {
        //King moved to the middle of the board
        pieces.move("E1", "E4");
        
        //Enemy pieces moved into position
        pieces.move("A7", "D5");
        pieces.move("B7", "E5");
        pieces.move("C7", "F5");
        
        pieces.move("D7", "D4");
        pieces.move("E7", "F4");
        
        pieces.move("F7", "D3");
        pieces.move("G7", "E3");
        pieces.move("H7", "F3");
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("E5"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("F5"));
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D4"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("F4"));
        
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("D3"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("E3"));
        assertTrue(true == pieces.getPiece("E4").returnPossibleSquares(pieces).contains("F3"));
    }
    
    @Test
    public void returnsCorrectSquaresInTheCorner() {
        //pieces removed from the way
        pieces.removePiece("H1");
        pieces.removePiece("H2");
        pieces.removePiece("G1");
        pieces.removePiece("G2");
        
        pieces.move("E1", "H1");
        assertTrue(true == pieces.getPiece("H1").returnPossibleSquares(pieces).contains("H2"));
        assertTrue(true == pieces.getPiece("H1").returnPossibleSquares(pieces).contains("G1"));
        assertTrue(true == pieces.getPiece("H1").returnPossibleSquares(pieces).contains("G2"));
        
        pieces.removePiece("A1");
        pieces.removePiece("A2");
        pieces.removePiece("B1");
        pieces.removePiece("B2");
        
        pieces.move("H1", "A1");
        assertTrue(true == pieces.getPiece("A1").returnPossibleSquares(pieces).contains("A2"));
        assertTrue(true == pieces.getPiece("A1").returnPossibleSquares(pieces).contains("B1"));
        assertTrue(true == pieces.getPiece("A1").returnPossibleSquares(pieces).contains("B2"));
        
        pieces.removePiece("A7");
        pieces.removePiece("A8");
        pieces.removePiece("B7");
        pieces.removePiece("B8");
        
        pieces.move("A1", "A8");
        assertTrue(true == pieces.getPiece("A8").returnPossibleSquares(pieces).contains("A7"));
        assertTrue(true == pieces.getPiece("A8").returnPossibleSquares(pieces).contains("B8"));
        assertTrue(true == pieces.getPiece("A8").returnPossibleSquares(pieces).contains("B7"));
        
        pieces.removePiece("H8");
        pieces.removePiece("H7");
        pieces.removePiece("G8");
        pieces.removePiece("G7");
        
        pieces.move("A8", "H8");
        assertTrue(true == pieces.getPiece("H8").returnPossibleSquares(pieces).contains("H7"));
        assertTrue(true == pieces.getPiece("H8").returnPossibleSquares(pieces).contains("G7"));
        assertTrue(true == pieces.getPiece("H8").returnPossibleSquares(pieces).contains("G8"));
        
        pieces.move("H8", "H5");
        assertTrue(true == pieces.getPiece("H5").returnPossibleSquares(pieces).contains("H4"));
        assertTrue(true == pieces.getPiece("H5").returnPossibleSquares(pieces).contains("H6"));
        assertTrue(true == pieces.getPiece("H5").returnPossibleSquares(pieces).contains("G4"));
        assertTrue(true == pieces.getPiece("H5").returnPossibleSquares(pieces).contains("G5"));
        assertTrue(true == pieces.getPiece("H5").returnPossibleSquares(pieces).contains("G6"));
        
        pieces.move("H5", "A5");
        assertTrue(true == pieces.getPiece("A5").returnPossibleSquares(pieces).contains("A4"));
        assertTrue(true == pieces.getPiece("A5").returnPossibleSquares(pieces).contains("A6"));
        assertTrue(true == pieces.getPiece("A5").returnPossibleSquares(pieces).contains("B4"));
        assertTrue(true == pieces.getPiece("A5").returnPossibleSquares(pieces).contains("B5"));
        assertTrue(true == pieces.getPiece("A5").returnPossibleSquares(pieces).contains("B6"));
    }
    
    @Test
    public void returNotationWorks() {
        assertEquals("K", pieces.getPiece("E1").returnNotation());
        assertEquals("k", pieces.getPiece("E8").returnNotation());
    }
    
    @Test
    public void getImageWorks() {
        ImageIcon whiteKingImage = pieces.getPiece("E1").getImage();
        assertEquals("kingWhite.png", whiteKingImage.getDescription());
        
        ImageIcon blackKingImage = pieces.getPiece("E8").getImage();
        assertEquals("kingBlack.png", blackKingImage.getDescription());
    }
}
