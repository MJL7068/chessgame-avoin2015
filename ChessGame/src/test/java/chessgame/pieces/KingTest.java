/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.pieces;

import chessgame.board.Pieces;
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
    public void returNotationWorks() {
        assertEquals("K", pieces.getPiece("E1").returnNotation());
        assertEquals("k", pieces.getPiece("E8").returnNotation());
    }
}
