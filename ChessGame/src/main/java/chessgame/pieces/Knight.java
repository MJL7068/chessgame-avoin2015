package chessgame.pieces;

public class Knight extends Piece {
    
    public Knight(int column, int row) {
        super(column, row);
    }

    @Override
    void isValidMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString() {
        return "Knight: " + super.toString();
    }
    
}