package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.*;
import java.util.HashMap;

public class Pieces {
    private HashMap<String, Piece> pieces;
    
    private Piece whiteKing;
    private Piece blackKing;

    public Pieces() {
        this.pieces = new HashMap<String, Piece>();
        
        this.whiteKing = null;
        this.blackKing = null;
        
        generatePieces("white");
        generatePieces("black");        
    }

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
    
    public void move(String oldPlace, String newPlace) {
        Piece movable = pieces.get(oldPlace);

        removePiece(newPlace);
        
        movable.move(newPlace);
     
        pieces.remove(oldPlace);
        pieces.put(movable.getLocation(), movable);
    }

    public Piece getPiece(String location) {
        return pieces.get(location);
    }
    
    public Piece getKing(String color) {
        if (color.equals("white")) {
            return whiteKing;
        } else if (color.equals("black")) {
            return blackKing;
        }
        
        return null;
    }
    
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
    
    public void printPieces() {
        for (Piece piece : pieces.values()) {
            System.out.println(piece);
        }
    }
}
