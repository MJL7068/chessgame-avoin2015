package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class Knight extends Piece {
    
    public Knight(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public ImageIcon getImage() {
        return null;
    }
    
    public String toString() {
        return "Knight, " + super.toString();
    }

    @Override
    public HashSet<String> returnPossibleSquares(Pieces pieces) {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        HashSet<String> squares = new HashSet<String>();
        int column = super.getColumn();
        int row = super.getRow();

        if (column <= 7 && row <= 6) {
            String squareId = columns[column] + (row + 2);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                squares.add(squareId);
            }
        }
        if (column <= 7 && row >= 3) {
            String squareId = columns[column] + (row - 2);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column] + (row - 2)).getColor().equals(super.getColor())) {
            squares.add(squareId);
            }
        }
        if (column <= 6 && row <= 7) {
            String squareId = columns[column + 1] + (row + 1);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column + 1] + (row + 1)).getColor().equals(super.getColor())) {
            squares.add(columns[column + 1] + (row + 1));
            }
        }
        if (column <= 6 && row >= 2) {
            String squareId = columns[column + 1] + (row - 1);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column + 1] + (row - 1)).getColor().equals(super.getColor())) {
            squares.add(columns[column + 1] + (row - 1));
            }
        }

        if (column >= 2 && row <= 6) {
            String squareId = columns[column - 2] + (row + 2);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column - 2] + (row + 2)).getColor().equals(super.getColor())) {
            squares.add(columns[column - 2] + (row + 2));
            }
        }
        if (column >= 2 && row >= 3) {
            String squareId = columns[column - 2] + (row - 2);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column - 2] + (row - 2)).getColor().equals(super.getColor())) {
            squares.add(columns[column - 2] + (row - 2));
            }
        }
        if (column >= 3 && row <= 7) {
            String squareId = columns[column - 3] + (row + 1);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column - 3] + (row + 1)).getColor().equals(super.getColor())) {
            squares.add(columns[column - 3] + (row + 1));
            }
        }
        if (column >= 3 && row >= 2) {
            String squareId = columns[column - 3] + (row - 1);
            if (pieces.getPiece(squareId) == null || !pieces.getPiece(columns[column - 3] + (row - 1)).getColor().equals(super.getColor())) {
            squares.add(columns[column - 3] + (row - 1));
            }
        }

        return squares;
    }
    
}
