package chessgame.pieces;

public class Knight extends Piece {
    
    public Knight(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "Knight, " + super.toString();
    }
    
}
