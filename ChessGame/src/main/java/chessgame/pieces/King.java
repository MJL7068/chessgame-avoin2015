package chessgame.pieces;

public class King extends Piece {

    public King(int column, int row, String color) {
        super(column, row, color);
    }
    
    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "King, " + super.toString();
    }
    
}
