package chessgame.pieces;

public abstract class Piece {
    private static final String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int column;
    private int row;
    private String color;
    
    public Piece(int x, int y, String color) {
        this.column = x;
        this.row = y;
        this.color = color;
    }
    
    public void move(String newPlace) {
        int newColumn = 0, newRow;
        
        for (int i = 0; i < columns.length; i++) {
            if (("" + newPlace.charAt(0)).equals(columns[i])) {
                newColumn = i + 1;
            }
        }
        newRow = Integer.parseInt("" + newPlace.charAt(1));
        
        setColumn(newColumn);
        setRow(newRow);
    }
    
    public String getLocation() {
        return columns[column - 1] + row;
    }

    private void setColumn(int x) {
        this.column = x;
    }

    private void setRow(int y) {
        this.row = y;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }    
    
    public String returnClass() {
        String role = "" + this.getClass();
        return role;
    }
    
    public abstract boolean isValidMove();
    
    public String toString() {
        return color + ": " + getLocation();
    }
}
