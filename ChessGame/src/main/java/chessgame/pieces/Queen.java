package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class Queen extends Piece {
    
    public Queen(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public ImageIcon getImage() {
        ImageIcon image;
        if (this.getColor().equals("white")) {
            image = new ImageIcon(getClass().getResource("/images/queenWhite.png"));
            image.setDescription("queenWhite.png");
        } else {
            image = new ImageIcon(getClass().getResource("/images/queenBlack.png"));
            image.setDescription("queenBlack.png");
        }
        return image;
    }
    
    public String toString() {
        return "Queen, " + super.toString();
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
            return "Q";
        } else {
            return "q";
        }
    }
    
}
