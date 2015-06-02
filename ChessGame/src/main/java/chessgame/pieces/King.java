package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class King extends Piece {

    public King(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public ImageIcon getImage() {
        return null;
    }
    
    public String toString() {
        return "King, " + super.toString();
    }

    @Override
    public HashSet<String> returnPossibleSquares(Pieces pieces) {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        HashSet<String> squares = new HashSet<String>();
        int column = super.getColumn();
        int row = super.getRow();

        for (int i = 0; i < 3; i++) {
            String upperSquare = columns[column - 2 + i] + "" + (row + 1);
            if (pieces.getPiece(upperSquare) == null || !pieces.getPiece(upperSquare).getColor().equals(super.getColor())) {
                squares.add(upperSquare);
            }

            String square = columns[column - 2 + i] + "" + row;
            if (pieces.getPiece(square) == null || !pieces.getPiece(square).getColor().equals(super.getColor())) {
                squares.add(square);
            }

            String lowerSquare = columns[column - 2 + i] + "" + (row - 1);
            if (pieces.getPiece(lowerSquare) == null || !pieces.getPiece(lowerSquare).getColor().equals(super.getColor())) {
                squares.add(lowerSquare);
            }
        }

        return squares;
    }
    
}
