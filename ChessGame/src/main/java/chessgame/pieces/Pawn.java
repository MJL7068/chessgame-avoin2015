package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class Pawn extends Piece {
    
    public Pawn(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public ImageIcon getImage() {
        return null;
    }
    
    public String toString() {
        return "Pawn, " + super.toString();
    }

    @Override
    public HashSet<String> returnPossibleSquares(Pieces pieces) {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        HashSet<String> squares = new HashSet<String>();
        int column = super.getColumn();
        int row = super.getRow();

        if (super.getColor().equals("white")) {
            if (pieces.getPiece(columns[column - 1] + (row + 1)) == null) {
            squares.add(columns[column - 1] + (row + 1));
            }
            if (row == 2) {
                if (pieces.getPiece(columns[column - 1] + (row + 2)) == null) {
                squares.add(columns[column - 1] + (row + 2));
                }
            }
            if (column > 1 && pieces.getPiece(columns[column - 2] + (row + 1)) != null) {
                if (!pieces.getPiece(columns[column - 2] + (row + 1)).getColor().equals(super.getColor())) {
                squares.add(columns[column - 2] + (row + 1));
                }
            }
            if (column < 8 && pieces.getPiece(columns[column] + (row + 1)) != null) {
                if (!pieces.getPiece(columns[column] + (row + 1)).getColor().equals(super.getColor())) {
                squares.add(columns[column] + (row + 1));
                }
            }
        }

        if (super.getColor().equals("black")) {
            if (pieces.getPiece(columns[column - 1] + (row - 1)) == null) {
            squares.add(columns[column - 1] + (row - 1));
            }
            if (row == 7) {
                if (pieces.getPiece(columns[column - 1] + (row - 2)) == null) {
                squares.add(columns[column - 1] + (row - 2));
                }
            }
            if (column > 1 && pieces.getPiece(columns[column - 2] + (row - 1)) != null) {
                if (!pieces.getPiece(columns[column - 2] + (row - 1)).getColor().equals(super.getColor())) {
                squares.add(columns[column - 2] + (row - 1));
                }
            }
            if (column < 8 && pieces.getPiece(columns[column] + (row - 1)) != null) {
                if (!pieces.getPiece(columns[column] + (row - 1)).getColor().equals(super.getColor())) {
                squares.add(columns[column] + (row - 1));
                }
            }
        }

        return squares;
    }
    
}
