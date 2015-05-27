package chessgame.pieces;

public class Pawn extends Piece {
    
    public Pawn(int column, int row, String color) {
        super(column, row, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
    
    public String toString() {
        return "Pawn, " + super.toString();
    }
    
}
