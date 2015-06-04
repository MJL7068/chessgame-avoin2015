package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.*;
import java.util.HashMap;

/**
 *
 * @author mattilei
 */
public class Pieces {
    private HashMap<String, Piece> pieces;
    
    private Piece whiteKing;
    private Piece blackKing;

    /**
     * This class stores all the pieces. Constructor generates all the pieces used
     * in the game. Methods are used to return and remove pieces and to alter the
     * state of the pieces in play.
     */
    public Pieces() {
        this.pieces = new HashMap<String, Piece>();
        
        this.whiteKing = null;
        this.blackKing = null;
        
        generatePieces("white");
        generatePieces("black");        
    }

    /**
     * Generates a set of pieces for one player
     * @param color is used to set which color the pieces are
     */
    public void generatePieces(String color) {
        int firstRow = 0, secondRow = 0;
        
        if (color.equals("white")) {
            firstRow = 1;
            secondRow = 2;
        } else if (color.equals("black")) {
            firstRow = 8;
            secondRow = 7;
        }
        
        Rook rookOne = new Rook(1, firstRow, color);
        pieces.put(rookOne.getLocation(), rookOne);
        Rook rookTwo = new Rook(8, firstRow, color);
        pieces.put(rookTwo.getLocation(), rookTwo);
        
        Knight knightOne = new Knight(2, firstRow, color);
        pieces.put(knightOne.getLocation(), knightOne);
        Knight knightTwo = new Knight(7, firstRow, color);
        pieces.put(knightTwo.getLocation(), knightTwo);
        
        Bishop bishopOne = new Bishop(3, firstRow, color);
        pieces.put(bishopOne.getLocation(), bishopOne);
        Bishop bishopTwo = new Bishop(6, firstRow, color);
        pieces.put(bishopTwo.getLocation(), bishopTwo);
        
        Queen queen = new Queen(4, firstRow, color);
        pieces.put(queen.getLocation(), queen);
        
        King king = new King(5, firstRow, color);
        pieces.put(king.getLocation(), king);
        if (color.equals("white")) {
            this.whiteKing = king;
        } else if (color.equals("black")) {
            this.blackKing = king;
        }
        
        for (int i = 1; i <= 8; i++) {
            Pawn pawn = new Pawn(i, secondRow, color);
            pieces.put(pawn.getLocation(), pawn);
        }

    }
    
    /**
     * Alters the row and column of a piece
     * @param oldPlace location of the piece that is being moved
     * @param newPlace location of the square where the piece is being moved
     */
    public void move(String oldPlace, String newPlace) {
        Piece movable = pieces.get(oldPlace);

        removePiece(newPlace);
        
        movable.move(newPlace);
     
        pieces.remove(oldPlace);
        pieces.put(movable.getLocation(), movable);
    }

    /**
     * Used to get the piece from location
     * @param location where the searched piece is
     * @return returns the piece which location matches the parameter
     */
    public Piece getPiece(String location) {
        return pieces.get(location);
    }
    
    /**
     * 
     * @param color
     * @return
     */
    public Piece getKing(String color) {
        if (color.equals("white")) {
            return whiteKing;
        } else if (color.equals("black")) {
            return blackKing;
        }
        
        return null;
    }
    
    /**
     * Removes a piece from location
     * @param location
     */
    public void removePiece(String location) {
        if (pieces.get(location) == null) {
            return;
        }
        
        if (location.equals(getKing("white").getLocation())) {
            whiteKing = null;
        }
        if (location.equals(getKing("black").getLocation())) {
            blackKing = null;
        }
        
        System.out.println("Piece " + pieces.get(location) + " removed!");
        pieces.remove(location);   
    }
    
    /**
     *
     */
    public void printPieces() {
        for (Piece piece : pieces.values()) {
            System.out.println(piece);
        }
    }
}
