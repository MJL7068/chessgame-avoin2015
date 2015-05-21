package chessgame.board;

import chessgame.board.Board;
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
    }

}
