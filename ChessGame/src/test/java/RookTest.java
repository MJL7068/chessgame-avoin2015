
import chessgame.pieces.Rook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    Rook rook;
    
    public RookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rook = new Rook(1, 1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructorSetsVariablesCorrectly() {
        assertEquals("Rook: A1", rook.toString());
    }
    
    @Test
    public void moveWorksCorrectly() {
        rook.move("D1");
        assertEquals("Rook: D1", rook.toString());
    }
    
    @Test
    public void getLocationWorksCorrectly() {
        rook.move("A7");
        assertEquals("A7", rook.getLocation());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
