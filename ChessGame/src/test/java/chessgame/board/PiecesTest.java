package chessgame.board;

import chessgame.board.Pieces;
import chessgame.pieces.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiecesTest {
    Pieces pieces;
    
    public PiecesTest() {
    }
    
    @Before
    public void setUp() {
        pieces = new Pieces();
    }
    
    @Test
    public void generatesWhiteQueenCorrectly() {
        Piece queen = pieces.getPiece("D1");
        assertEquals("Queen, white: D1", queen.toString());
    }
    
    @Test
    public void generatesWhiteKingCorrectly() {
        Piece king = pieces.getKing("white");
        assertEquals("King, white: E1", king.toString());
    }
    
    @Test
    public void generatesWhitePawnsCorrectly() {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "G"};
        for (int i = 0; i < 8; i++) {
            Piece pawn = pieces.getPiece(columns[i] + "2");
            assertEquals("Pawn, white: " + columns[i] + "2", pawn.toString());
        }
    }
    
    @Test
    public void generatesWhiteRooksCorrectly() {
        Piece leftRook = pieces.getPiece("A1");
        assertEquals("Rook, white: A1", leftRook.toString());
        
        Piece rightRook = pieces.getPiece("H1");
        assertEquals("Rook, white: H1", rightRook.toString());
    }
    
    @Test
    public void generatesWhiteKnightsCorrectly() {
        Piece leftKnight = pieces.getPiece("B1");
        assertEquals("Knight, white: B1", leftKnight.toString());
        
        Piece rightKnight = pieces.getPiece("G1");
        assertEquals("Knight, white: G1", rightKnight.toString());
    }
    
    @Test
    public void generatesWhiteBishopsCorrectly() {
        Piece leftBishop = pieces.getPiece("C1");
        assertEquals("Bishop, white: C1", leftBishop.toString());
        
        Piece rightBishop = pieces.getPiece(("F1"));
        assertEquals("Bishop, white: F1", rightBishop.toString());
    }
    
    
    @Test
    public void generatesBlackQueenCorrectly() {
        Piece queen = pieces.getPiece("D8");
        assertEquals("Queen, black: D8", queen.toString());
    }
    
    @Test
    public void generatesBlackKingCorrectly() {
        Piece king = pieces.getKing("black");
        assertEquals("King, black: E8", king.toString());
    }
    
    @Test
    public void generatesBlackPawnsCorrectly() {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "G"};
        for (int i = 0; i < 8; i++) {
            Piece pawn = pieces.getPiece(columns[i] + "7");
            assertEquals("Pawn, black: " + columns[i] + "7", pawn.toString());
        }
    }
    
    @Test
    public void generatesBlackRooksCorrectly() {
        Piece leftRook = pieces.getPiece("A8");
        assertEquals("Rook, black: A8", leftRook.toString());
        
        Piece rightRook = pieces.getPiece("H8");
        assertEquals("Rook, black: H8", rightRook.toString());
    }
    
    @Test
    public void generatesBlackKnightsCorrectly() {
        Piece leftKnight = pieces.getPiece("B8");
        assertEquals("Knight, black: B8", leftKnight.toString());
        
        Piece rightKnight = pieces.getPiece("G8");
        assertEquals("Knight, black: G8", rightKnight.toString());
    }
    
    @Test
    public void generatesBlackBishopsCorrectly() {
        Piece leftBishop = pieces.getPiece("C8");
        assertEquals("Bishop, black: C8", leftBishop.toString());
        
        Piece rightBishop = pieces.getPiece(("F8"));
        assertEquals("Bishop, black: F8", rightBishop.toString());
    }
    
    @Test
    public void removePieceWorksCorrectly() {
        pieces.removePiece("A2");
        
        assertEquals(null, pieces.getPiece("A2"));
    }
    
    @Test
    public void moveWorksCorrectly() {
        pieces.move("D2", "D7");       
        assertEquals("Pawn, white: D7", pieces.getPiece("D7").toString());
        
        pieces.move("D7", "D5");
        assertEquals("Pawn, white: D5", pieces.getPiece("D5").toString());        
    }
        
}
