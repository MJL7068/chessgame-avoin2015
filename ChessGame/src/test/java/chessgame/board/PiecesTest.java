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
    public void generatesQueenCorrectly() {
        Piece queen = pieces.getPiece("D1");
        assertEquals("Queen: D1", queen.toString());
    }
    
    @Test
    public void generatesKingCorrectly() {
        Piece king = pieces.getPiece("E1");
        assertEquals("King: E1", king.toString());
    }
    
    @Test
    public void generatesPawnsCorrectly() {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "G"};
        for (int i = 0; i < 8; i++) {
            Piece pawn = pieces.getPiece(columns[i] + "2");
            assertEquals("Pawn: " + columns[i] + "2", pawn.toString());
        }
    }
    
    @Test
    public void generatesRooksCorrectly() {
        Piece leftRook = pieces.getPiece("A1");
        assertEquals("Rook: A1", leftRook.toString());
        
        Piece rightRook = pieces.getPiece("H1");
        assertEquals("Rook: H1", rightRook.toString());
    }
    
    @Test
    public void generatesKnightsCorrectly() {
        Piece leftKnight = pieces.getPiece("B1");
        assertEquals("Knight: B1", leftKnight.toString());
        
        Piece rightKnight = pieces.getPiece("G1");
        assertEquals("Knight: G1", rightKnight.toString());
    }
    
    @Test
    public void generatesBishopsCorrectly() {
        Piece leftBishop = pieces.getPiece("C1");
        assertEquals("Bishop: C1", leftBishop.toString());
        
        Piece rightBishop = pieces.getPiece(("F1"));
        assertEquals("Bishop: F1", rightBishop.toString());
    }
}
