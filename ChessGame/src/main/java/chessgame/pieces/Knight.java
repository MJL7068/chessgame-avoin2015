package chessgame.pieces;

import javax.swing.ImageIcon;

public class Knight extends Piece {
    
    public Knight(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    @Override
    public ImageIcon getImage() {
        return null;
    }
    
    public String toString() {
        return "Knight, " + super.toString();
    }
    
}
