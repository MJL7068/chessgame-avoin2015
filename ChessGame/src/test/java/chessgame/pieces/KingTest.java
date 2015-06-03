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
}
