package chessgame.pieces;

import chessgame.pieces.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceTest {
    Piece piece;
    
    public PieceTest() {
    }
    
    @Before
    public void setUp() {
        piece = new Pawn(1, 2);
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(1, piece.getColumn());
        assertEquals(2, piece.getRow());
    }
    
    @Test
    public void getLocationWorks() {
        assertEquals("A2", piece.getLocation());
    }
    
    @Test
    public void moveWorksCorrectly() {
        piece.move("A4");
        assertEquals("A4", piece.getLocation());
        
        piece.move("C4");
        assertEquals("C4", piece.getLocation());
    }
}
