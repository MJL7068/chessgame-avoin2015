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
     * @param x the column of this piece during its creation
     * @param y the row of this piece during its creation
     * @param color the color of this piece
     */
    public Piece(int x, int y, String color) {
        this.column = x;
        this.row = y;
        this.color = color;
    }

    /**
     * Changes the row and column of Piece according to parameter.
     *
     * @param newPlace the location that the piece is to be moved
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
     * @return the location of this piece
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
     * @param newLocation the location where the piece is to be moved
     * @param pieces the piece checks if the move is valid based on the locations
     * of other pieces on the board
     * @return returns true if the move is possible
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

    /**
     * This method returns the single character notation of this piece used when
     * the game is saved
     * @return returns the single character notation
     */
    public abstract String returnNotation();
    
    /**
     * This method returns the ImageIcon of this piece based on it's subclass
     * and color. Used by the graphical interface.
     * @return returns the ImageIcon-representation of this piece
     */
    public abstract ImageIcon getImage();

    public String toString() {
        return color + ": " + getLocation();
    }
}
