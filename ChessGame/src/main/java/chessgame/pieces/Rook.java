package chessgame.pieces;
import javax.swing.ImageIcon;

public class Rook extends Piece {
    
    public Rook(int column, int row, String color) {
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
        return "Rook, " + super.toString();
    }
    
}
