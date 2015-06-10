package chessgame.board;

import chessgame.board.Board;
import chessgame.userinterface.UserInterface;
import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    Board board;    
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
        board = new Board();
        UserInterface gui = new UserInterface(board);
        board.setInterface(gui);
        SwingUtilities.invokeLater(gui);
    }
    
//    @Test
//    public void resetWorksCorrectly() {
//        board.turnFirstPart("A2");
//        board.turnSecondPart("A4");
//        board.turnFirstPart("D2");
//        
//        board.reset();
//        assertEquals("", board.getStartingPoint());
//        assertEquals(null, board.getPiece("A4"));
//    }
    
//    @Test
//    public void turnFirstPartWorksCorrectly() {
//        board.turnFirstPart("D2");
//        
//        assertEquals("D2", board.getStartingPoint());
//        assertEquals(true, board.getTurnState());
//    }
   
//    @Test
//    public void turnSecondPartWorksCorrectly() {
//        board.turnFirstPart("D2");
//        board.turnSecondPart("D4");
//        
//        assertEquals("", board.getStartingPoint());
//        assertEquals(false, board.getTurnState());
//        assertEquals("Pawn, white: D4", board.getPiece("D4").toString());
//    }
    
    @Test
    public void lookForPieceWorksCorrectly() {
        assertTrue(true == board.lookForPiece("A1"));
    }
    
    @Test
    public void lookForPieceReturnsFalseCorrectly() {
        assertTrue(false == board.lookForPiece("D5"));
    }
    
    @Test
    public void checkForColorWorksCorrectly() {
        assertTrue(true == board.checkForColor("D2", "white"));
        
        assertTrue(false == board.checkForColor("H1", "black"));
    }
    
    @Test
    public void moveWorksCorrectly() {
        assertTrue(true == board.move("H2", "H4"));
        
        assertTrue(false == board.move("D5", "A4"));
    }
    
//    @Test
//    public void checkIfCheckReturnFalseCorrectly() {
//        assertTrue(false == board.checkIfCheck("A1"));        
//    }

}
