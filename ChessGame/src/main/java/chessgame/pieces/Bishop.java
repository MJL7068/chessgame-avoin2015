package chessgame.pieces;

public class Bishop extends Piece {
    
    public Bishop(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "Bishop, " + super.toString();
    }
    
}
