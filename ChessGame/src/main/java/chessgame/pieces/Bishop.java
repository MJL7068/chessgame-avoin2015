package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

/**
 *
 * @author mattilei
 */
public class Bishop extends Piece {

    /**
     *
     * @param column
     * @param row
     * @param color
     */
    public Bishop(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public ImageIcon getImage() {
        ImageIcon image;
        if (this.getColor().equals("white")) {
            image = new ImageIcon(getClass().getResource("/images/bishopWhite.png"));
            image.setDescription("bishopWhite.png");
        } else {
            image = new ImageIcon(getClass().getResource("/images/bishopBlack.png"));
            image.setDescription("bishopBlack.png");
        }
        return image;
    }

    public String toString() {
        return "Bishop, " + super.toString();
    }

    @Override
    public HashSet<String> returnPossibleSquares(Pieces pieces) {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        HashSet<String> squares = new HashSet<String>();
        int column = super.getColumn();
        int row = super.getRow();

        for (int i = 1; column <= 7; i++) {
            String squareId = columns[column] + (row + i);
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
            column++;
        }
        
        column = super.getColumn();
        for (int i = 1; column <= 7; i++) {
            String squareId = columns[column] + (row - i);
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
            column++;
        }
        
        column = super.getColumn();
        for (int i = 1; column > 1; i++) {
            String squareId = columns[column - 2] + (row + i);
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
            column--;
        }
        
        column = super.getColumn();
        for (int i = 1; column > 1; i++) {
            String squareId = columns[column - 2] + (row - i);
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
            column--;
        }

        return squares;
    }

    @Override
    public String returnNotation() {
        if (super.getColor().equals("white")) {
            return "B";
        } else {
            return "b";
        }
    }

}
