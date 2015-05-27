package chessgame.pieces;

public class Queen extends Piece {
    
    public Queen(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "Queen, " + super.toString();
    }
    
}
