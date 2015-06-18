package chessgame.board;

import chessgame.board.Pieces;
import chessgame.pieces.Piece;
import java.util.HashMap;
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
        pieces.removePiece("E2");
        pieces.removePiece("E8");
        
        assertEquals(null, pieces.getPiece("A2"));
        assertEquals(null, pieces.getPiece("E2"));
        assertEquals(null, pieces.getPiece("E8"));
    }
    
    @Test
    public void getKingReturnsNullIfThereIsNoKing() {
        //Black king removed
        pieces.removePiece("E8");
        
        assertEquals(null, pieces.getKing("black"));
    }
    
    @Test
    public void getKingReturnsNullWithWrongParameter() {
        assertEquals(null, pieces.getKing("orange"));
    }
    
    @Test
    public void moveWorksCorrectly() {
        pieces.move("D2", "D7");       
        assertEquals("Pawn, white: D7", pieces.getPiece("D7").toString());
        
        pieces.move("D7", "D5");
        assertEquals("Pawn, white: D5", pieces.getPiece("D5").toString());        
    }
    
    @Test
    public void moveRemovesPieceCorrectly() {
        pieces.move("A2", "A7");
        assertEquals("Pawn, white: A7", pieces.getPiece("A7").toString());
        
        pieces.move("A7", "A6");
        assertEquals(null, pieces.getPiece("A7"));
    }
    
    @Test
    public void getRemovedPieceWorksCorrectly() {
        pieces.move("A2", "A8");
        assertEquals("Rook, black: A8", pieces.getRemovedPiece().toString());
    }
    
    @Test
    public void resetRemovedPieceWorksCorrectly() {
        pieces.move("A2", "A8");
        assertEquals("Rook, black: A8", pieces.getRemovedPiece().toString());
        
        pieces.resetRemovedPiece();
        assertEquals(null, pieces.getRemovedPiece());
    }
    
    @Test
    public void addPieceWorksCorrectly() {
        //White piece eats the black rook
        pieces.move("A2", "A8");       
        pieces.move("A8", "A6");
        assertEquals(null, pieces.getPiece("A8"));
        
        //Rook is returned to play
        pieces.addBackTheRemovedPiece();
        assertEquals("Rook, black: A8", pieces.getPiece("A8").toString());
        assertEquals(null, pieces.getRemovedPiece());
    }
    
    @Test
    public void piecesCanBeGeneratedWithFONNotation() {
        Pieces newPieces = new Pieces("RNBQKBNR/PPPPP2P/8/5PPq/4p3/8/pppp1ppp/rnb1kbnr/");       
        assertEquals("Pawn, white: F4", newPieces.getPiece("F4").toString());
        assertEquals("Queen, black: H4", newPieces.getPiece("H4").toString());
        
        Pieces oppositePieces = new Pieces("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/");
        assertEquals("King, black: E1", oppositePieces.getPiece("E1").toString());
        assertEquals("King, white: E8", oppositePieces.getPiece("E8").toString());
    }
    
    @Test
    public void getPiecesWorks() {
        HashMap<String, Piece> allPieces = pieces.getPieces();
        assertEquals(32, allPieces.size());
        assertEquals("King, white: E1", allPieces.get("E1").toString());
        assertEquals("Rook, black: H8", allPieces.get("H8").toString());
    }
        
}
