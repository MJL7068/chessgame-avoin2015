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
        ImageIcon image;
        if (this.getColor().equals("white")) {
            image = new ImageIcon(getClass().getResource("/images/kingWhite.png"));
            image.setDescription("kingWhite.png");
        } else {
            image = new ImageIcon(getClass().getResource("/images/kingBlack.png"));
            image.setDescription("kingBlack.png");
        }
        return image;
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
            int index = (column - 2 + i);
            if (index >= 0 && index < 8) {
            String upperSquare = columns[index] + "" + (row + 1);
            if (pieces.getPiece(upperSquare) == null || !pieces.getPiece(upperSquare).getColor().equals(super.getColor())) {
                squares.add(upperSquare);
            }

            String square = columns[index] + "" + row;
            if (pieces.getPiece(square) == null || !pieces.getPiece(square).getColor().equals(super.getColor())) {
                squares.add(square);
            }

            String lowerSquare = columns[index] + "" + (row - 1);
            if (pieces.getPiece(lowerSquare) == null || !pieces.getPiece(lowerSquare).getColor().equals(super.getColor())) {
                squares.add(lowerSquare);
            }
            }
        }

        return squares;
    }

    @Override
    public String returnNotation() {
        if (super.getColor().equals("white")) {
            return "K";
        } else {
            return "k";
        }
    }
    
}
