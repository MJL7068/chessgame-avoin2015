package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.Rook;
import java.util.ArrayList;

public class Pieces {

    private ArrayList<Piece> pieces;

    public Pieces() {
        this.pieces = new ArrayList<Piece>();
        
        generatePieces();
    }

    void generatePieces() {
        Rook rook = new Rook(1, 1);
        pieces.add(rook);
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
