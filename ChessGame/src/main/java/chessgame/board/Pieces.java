package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Pieces {
    private ArrayList<Piece> pieces;

    public Pieces() {
        this.pieces = new ArrayList<Piece>();
        
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
        pieces.add(rookOne);
        Rook rookTwo = new Rook(8, firstRow, color);
        pieces.add(rookTwo);
        
        Knight knightOne = new Knight(2, firstRow, color);
        pieces.add(knightOne);
        Knight knightTwo = new Knight(7, firstRow, color);
        pieces.add(knightTwo);
        
        Bishop bishopOne = new Bishop(3, firstRow, color);
        pieces.add(bishopOne);
        Bishop bishopTwo = new Bishop(6, firstRow, color);
        pieces.add(bishopTwo);
        
        Queen queen = new Queen(4, firstRow, color);
        pieces.add(queen);
        
        King king = new King(5, firstRow, color);
        pieces.add(king);
        
        for (int i = 1; i <= 8; i++) {
            Pawn pawn = new Pawn(i, secondRow, color);
            pieces.add(pawn);
        }

    }

    public Piece getPiece(String location) {
        for (Piece piece : pieces) {
            if (piece.getLocation().equals(location)) {
                return piece;
            }
        }

        return null;
    }
    
    public void printPieces() {
        for (Piece piece : pieces) {
            System.out.println(piece);
        }
    }
}
