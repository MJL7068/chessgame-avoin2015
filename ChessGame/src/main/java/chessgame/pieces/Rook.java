package chessgame.pieces;

public class Rook extends Piece {
    
    public Rook(int column, int row) {
        super(column, row);
    }

    @Override
    void isValidMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString() {
        return "Rook: " + super.toString();
    }
    
}
