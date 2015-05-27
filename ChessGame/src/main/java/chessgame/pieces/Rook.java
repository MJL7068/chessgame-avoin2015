package chessgame.pieces;

public class Rook extends Piece {
    
    public Rook(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "Rook, " + super.toString();
    }
    
}
