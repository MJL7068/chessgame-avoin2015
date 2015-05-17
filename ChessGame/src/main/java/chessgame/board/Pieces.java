package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Pieces {
    private ArrayList<Piece> pieces;

    public Pieces() {
        this.pieces = new ArrayList<Piece>();
        
        generatePieces();
    }

    void generatePieces() {
        Rook rookOne = new Rook(1, 1);
        pieces.add(rookOne);
        Rook rookTwo = new Rook(8, 1);
        pieces.add(rookTwo);
        
        Knight knightOne = new Knight(2, 1);
        pieces.add(knightOne);
        Knight knightTwo = new Knight(7, 1);
        pieces.add(knightTwo);
        
        Bishop bishopOne = new Bishop(3, 1);
        pieces.add(bishopOne);
        Bishop bishopTwo = new Bishop(6, 1);
        pieces.add(bishopTwo);
        
        Queen queen = new Queen(4, 1);
        pieces.add(queen);
        
        King king = new King(5, 1);
        pieces.add(king);
        
        for (int i = 1; i <= 8; i++) {
            Pawn pawn = new Pawn(i, 2);
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
