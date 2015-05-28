package chessgame.pieces;

import javax.swing.ImageIcon;

public class King extends Piece {

    public King(int column, int row, String color) {
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
        return "King, " + super.toString();
    }
    
}
