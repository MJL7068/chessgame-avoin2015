package chessgame.pieces;
import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

/**
 *
 * @author mattilei
 */
public class Rook extends Piece {
    
    /**
     *
     * @param column
     * @param row
     * @param color
     */
    public Rook(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public ImageIcon getImage() {
        ImageIcon image;
        if (this.getColor().equals("white")) {
            image = new ImageIcon(getClass().getResource("/images/rookWhite.png"));
            image.setDescription("rookWhite.png");
        } else {
            image = new ImageIcon(getClass().getResource("/images/rookBlack.png"));
            image.setDescription("rookBlack.png");
        }
        return image;
    }
    
    public String toString() {
        return "Rook, " + super.toString();
    }

    @Override
    public HashSet<String> returnPossibleSquares(Pieces pieces) {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        HashSet<String> squares = new HashSet<String>();
        int column = super.getColumn();
        int row = super.getRow();        
        
        for (int x = column + 1; x <= 8; x++) {
            String squareId = columns[x - 1] + "" + row;
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
        }
        
        for (int x = column - 1; x >= 1; x--) {
            String squareId = columns[x - 1] + "" + row;
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
        }
        
        for (int y = row + 1; y <= 8; y++) {
            String squareId = columns[column - 1] + "" + y;
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
        }
        
        for (int y = row - 1; y >= 1; y--) {
            String squareId = columns[column - 1] + "" + y;
            if (pieces.getPiece(squareId) != null) {
                if (!pieces.getPiece(squareId).getColor().equals(super.getColor())) {
                    squares.add(squareId);
                }
                break;
            }
            squares.add(squareId);
        }
        
        return squares;
    }

    @Override
    public String returnNotation() {
        if (super.getColor().equals("white")) {
            return "R";
        } else {
            return "r";
        }
    }
    
}
