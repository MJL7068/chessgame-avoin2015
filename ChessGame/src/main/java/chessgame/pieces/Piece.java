package chessgame.pieces;

import chessgame.board.Pieces;
import java.util.HashSet;
import javax.swing.ImageIcon;

/**
 * Piece is a abstract class. Every subclass of Piece has a row, a column, a
 * color and id based on the location
 *
 * @author mattilei
 */
public abstract class Piece {

    private static final String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int column;
    private int row;
    private String color;

    /**
     *
     * @param x
     * @param y
     * @param color
     */
    public Piece(int x, int y, String color) {
        this.column = x;
        this.row = y;
        this.color = color;
    }

    /**
     * Changes the row and column of Piece according to parameter.
     *
     * @param newPlace
     */
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

    /**
     * Returns the location as a string
     *
     * @return
     */
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

    public String getColor() {
        return color;
    }

    /**
     * This method returns true if the move to the new location is valid
     *
     * @param newLocation
     * @param pieces
     * @return
     */
    public boolean isValidMove(String newLocation, Pieces pieces) {
        HashSet<String> possibleMovementOptions = returnPossibleSquares(pieces);
        if (possibleMovementOptions.contains(newLocation)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param pieces contains all the pieces on the board
     * @return a HashSet that contains the ids of all the squares where the
     * piece can move to
     */
    public abstract HashSet<String> returnPossibleSquares(Pieces pieces);

    public abstract String returnNotation();

    public abstract ImageIcon getImage();

    public String toString() {
        return color + ": " + getLocation();
    }
}
