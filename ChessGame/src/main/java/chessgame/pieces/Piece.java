package chessgame.pieces;

public abstract class Piece {
    private static final String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int column;
    private int row;        
    
    public Piece(int x, int y) {
        this.column = x;
        this.row = y;
    }
    
    public void move(String newPlace) {
        int newColumn = 0, newRow;
        
        for (int i = 0; i < columns.length; i++) {
            if (("" + newPlace.charAt(0)).equals(columns[i])) {
                newColumn = i + 1;
            }
        }
        newRow = Integer.parseInt("" + newPlace.charAt(1));
        
        setX(newColumn);
        setY(newRow);
    }
    
    public String getLocation() {
        return columns[column - 1] + row;
    }

    public void setX(int x) {
        this.column = x;
    }

    public void setY(int y) {
        this.row = y;
    }
    
    abstract void isValidMove();
    
    public String toString() {
        return getLocation();
    }
}
