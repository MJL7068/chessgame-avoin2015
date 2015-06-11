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

/**
 *
 * @author mattilei
 */
public class PawnTest {
    Pieces pieces;
    
    public PawnTest() {
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
    public void PawnCanMoveTwoStepsAtStart() {
        //Options include a square two steps away from the pawns location
        assertTrue(true == pieces.getPiece("A2").returnPossibleSquares(pieces).contains("A4"));
        
        assertTrue(true == pieces.getPiece("H7").returnPossibleSquares(pieces).contains("H5"));
    }
    
    @Test
    public void PawnMovesNormallyJustOneSquare() {
        //Pawn set one step forward before testing
        pieces.move("A2", "A3");
        
        //Options include a square one step away from the pawns location
        assertTrue(true == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("A4"));
        //Options don't include a square two steps away from pawns location
        assertTrue(false == pieces.getPiece("A3").returnPossibleSquares(pieces).contains("A5"));
    }
    
    @Test
    public void PawnWontMoveSideWaysOrBackwards() {
        pieces.move("A2", "D4");
        
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("D3"));
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C4"));
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("E4"));
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C3"));
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("C5"));
        assertTrue(false == pieces.getPiece("D4").returnPossibleSquares(pieces).contains("E5"));
    }
    
    @Test
    public void WhitePawnCantMoveForwardIfThereIsAPieceInTheWay() {
        //White piece moved in white pawns way
        pieces.move("A1", "A3");
        //Pawn can't move on the piece in front of it
        assertTrue(false == pieces.getPiece("A2").returnPossibleSquares(pieces).contains("A3"));
        
        //Black piece moved in white pawns way
        pieces.move("C8", "B2");
        //Pawn can't move on the piece in front of it
        assertTrue(false == pieces.getPiece("B2").returnPossibleSquares(pieces).contains("B3"));
    }
    
    @Test
    public void BlackPawnCantMoveForwardIfThereIsAPieceInTheWay() {
        //Black piece moved in black pawns way
        pieces.move("A8", "A6");
        //Pawn can't move on the piece in front of it
        assertTrue(false == pieces.getPiece("A7").returnPossibleSquares(pieces).contains("A6"));
        
        //White piece moved in white pawns way
        pieces.move("A1", "B6");
        //Pawn can't move on the piece in front of it
        assertTrue(false == pieces.getPiece("B7").returnPossibleSquares(pieces).contains("B6"));
    }
    
    @Test
    public void WhitePawnCanEatOpposingPieces() {
        //White pawn moved forward
        pieces.move("B2", "B4");
        //Black pieces moved on position
        pieces.move("A7", "A5");
        pieces.move("C7", "C5");
        
        assertTrue(true == pieces.getPiece("B4").returnPossibleSquares(pieces).contains("A5"));
        assertTrue(true == pieces.getPiece("B4").returnPossibleSquares(pieces).contains("C5"));
    }
    
    @Test
    public void BlackPawnCanEatOpposingPieces() {
        //Black pawn moved forward
        pieces.move("B7", "B5");
        //White pieces moved on position
        pieces.move("A2", "A4");
        pieces.move("C2", "C4");
        
        assertTrue(true == pieces.getPiece("B5").returnPossibleSquares(pieces).contains("A4"));
        assertTrue(true == pieces.getPiece("B5").returnPossibleSquares(pieces).contains("C4"));
    }
    
    @Test
    public void returNotationWorks() {
        assertEquals("P", pieces.getPiece("A2").returnNotation());
        assertEquals("p", pieces.getPiece("A7").returnNotation());
    }
}
