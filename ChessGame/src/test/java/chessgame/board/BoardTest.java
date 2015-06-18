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
//        board.firstPartOfTheTurn("D2");
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
        assertEquals("Not your pieces!", board.getNotification());
    }
    
    @Test
    public void checkForColorReturnFalseIfThereIsnoPieceOnTheSquare() {
        assertTrue(false == board.checkForColor("D5", "black"));
    }
    
    @Test
    public void moveWorksCorrectly() {
        assertTrue(true == board.move("H2", "H4"));
        
        assertTrue(false == board.move("D5", "A4"));
    }
    
    @Test
    public void moveReturnFalseCorrectly() {
        assertTrue(false == board.move("A2", "B8"));
    }
    
    public void playerNamesCanBeSet() {
        board.setWhitePlayerName("White player");
        String whitePlayerName = board.getWhitePlayerName();
        assertEquals("White player", whitePlayerName);
        
        board.setBlackPlayerName("Black player");
        String blackPlayerName = board.getBlackPlayerName();
        assertEquals("Black player", blackPlayerName);
    }
    
    @Test
    public void getPiecceWorksCorrectly() {
        assertEquals("Pawn, black: G7", board.getPiece("G7").toString());
    }
    
    @Test
    public void getTurnStateReturnsTheRightBoolean() {
        assertTrue(false == board.getTurnState());
    }
    
    @Test
    public void getTurnColorWorksCorrectly() {
        assertEquals("white", board.getTurnColor());
        board.increaseTurnCount();
        assertEquals("black", board.getTurnColor());
    }
    
    @Test
    public void getOpposingTurnColorWorksCorrectly() {
        assertEquals("black", board.getOpposingTurnColor());
        board.increaseTurnCount();
        assertEquals("white", board.getOpposingTurnColor());
    }
    
    public void getNotificationWorksCorrectly() {
        board.setNotification("A1 moved to A5");
        assertEquals("A1 moved to A5", board.getNotification());
    }
    
    @Test
    public void getTurnWorksCorrectly() {
        assertEquals(1, board.getTurns());
        board.increaseTurnCount();
        board.increaseTurnCount();
        assertEquals(3, board.getTurns());
    }
    
    @Test
    public void getCheckWorksCorrectly() {
        assertTrue(false == board.getCheck());
    }
    
    @Test
    public void getGameOverWorksCorrectly()  {
        assertEquals("empty", board.getGameOver());
    }
    
    @Test
    public void setStartingPointWorksCorrectly() {
        board.setStartingPoint("A4");
        assertEquals("A4", board.getStartingPoint());
    }

}
