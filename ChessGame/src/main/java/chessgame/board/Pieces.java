package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.pieces.*;
import java.util.HashMap;

/**
 * This class stores all the pieces. Constructor generates all the pieces used
 * in the game. Methods are used to return and remove pieces and to alter the
 * state of the pieces in play.
 *
 * @author mattilei
 */
public class Pieces {

    private HashMap<String, Piece> pieces;

    private Piece whiteKing;
    private Piece blackKing;

    private Piece removedPiece;

    /**
     * The constructor creates the pieces.
     */
    public Pieces() {
        this.pieces = new HashMap<String, Piece>();

        this.whiteKing = null;
        this.blackKing = null;

        generatePiecesAccordingToFONNotation("RNBQKBNR/PPPPPPPP/8/8/8/8/pppppppp/rnbqkbnr/");
    }
    
    /**
     * Constructor can be given a parameter to create a new set of pieces. Used
     * when loading a game from memory.
     */
    public Pieces(String FONNotation) {
        this.pieces = new HashMap<String, Piece>();

        this.whiteKing = null;
        this.blackKing = null;

        generatePiecesAccordingToFONNotation(FONNotation);
    }

    /**
     * Generates all the pieces stored in the parameter
     *
     * @param FONNotation this string stores all the pieces on the board in a
     * given state for example string
     * RNBQKBNR/PPPPPPPP/8/8/8/8/pppppppp/rnbqkbnr/ stores all the pieces from
     * the start of an ordinary chess game.
     */
    public void generatePiecesAccordingToFONNotation(String FONNotation) {
        String[] parts = FONNotation.split("/");

        for (int row = 0; row < parts.length; row++) {
            int column = 0;
            for (int i = 0; i < parts[row].length(); i++) {
                String character = ("" + parts[row].charAt(i));
                if (character.matches("[1-9]{1}")) {
                    column += Integer.parseInt(character);
                } else {
                    column += 1;
                }
                switch (character) {
                    case "P":
                        Pawn pawnWhite = new Pawn(column, (row + 1), "white");
                        pieces.put(pawnWhite.getLocation(), pawnWhite);
                        break;
                    case "p":
                        Pawn pawnBlack = new Pawn(column, (row + 1), "black");
                        pieces.put(pawnBlack.getLocation(), pawnBlack);
                        break;
                    case "R":
                        Rook rookWhite = new Rook(column, (row + 1), "white");
                        pieces.put(rookWhite.getLocation(), rookWhite);
                        break;
                    case "r":
                        Rook rookBlack = new Rook(column, (row + 1), "black");
                        pieces.put(rookBlack.getLocation(), rookBlack);
                        break;
                    case "N":
                        Knight knightWhite = new Knight(column, (row + 1), "white");
                        pieces.put(knightWhite.getLocation(), knightWhite);
                        break;
                    case "n":
                        Knight knightBlack = new Knight(column, (row + 1), "black");
                        pieces.put(knightBlack.getLocation(), knightBlack);
                        break;
                    case "B":
                        Bishop bishopWhite = new Bishop(column, (row + 1), "white");
                        pieces.put(bishopWhite.getLocation(), bishopWhite);
                        break;
                    case "b":
                        Bishop bishopBlack = new Bishop(column, (row + 1), "black");
                        pieces.put(bishopBlack.getLocation(), bishopBlack);
                        break;
                    case "Q":
                        Queen queenWhite = new Queen(column, (row + 1), "white");
                        pieces.put(queenWhite.getLocation(), queenWhite);
                        break;
                    case "q":
                        Queen queenBlack = new Queen(column, (row + 1), "black");
                        pieces.put(queenBlack.getLocation(), queenBlack);
                        break;
                    case "K":
                        King kingWhite = new King(column, (row + 1), "white");
                        pieces.put(kingWhite.getLocation(), kingWhite);
                        this.whiteKing = kingWhite;
                        break;
                    case "k":
                        King kingBlack = new King(column, (row + 1), "black");
                        pieces.put(kingBlack.getLocation(), kingBlack);
                        this.blackKing = kingBlack;
                        break;
                }
            }
            column = 0;
        }
    }

    /**
     * Alters the row and column of a piece
     *
     * @param oldPlace location of the piece that is being moved
     * @param newPlace location of the square where the piece is being moved
     */
    public void move(String oldPlace, String newPlace) {
        Piece movable = pieces.get(oldPlace);

        removePiece(newPlace);

        movable.move(newPlace);

        pieces.remove(oldPlace);
        pieces.put(movable.getLocation(), movable);
    }

    /**
     * Used to get the piece from location
     *
     * @param location where the searched piece is
     * @return returns the piece which location matches the parameter
     */
    public Piece getPiece(String location) {
        return pieces.get(location);
    }

    /**
     * Returns all the pieces stored as a HashMap
     */
    public HashMap<String, Piece> getPieces() {
        return this.pieces;
    }

    public Piece getKing(String color) {
        if (color.equals("white")) {
            return whiteKing;
        } else if (color.equals("black")) {
            return blackKing;
        }

        return null;
    }

    /**
     * Removes a piece from location
     *
     * @param location
     */
    public void removePiece(String location) {
        if (pieces.get(location) == null) {
            return;
        }

        removedPiece = pieces.get(location);

        if (location.equals(getKing("white").getLocation())) {
            whiteKing = null;
        }
        if (location.equals(getKing("black").getLocation())) {
            blackKing = null;
        }

        pieces.remove(location);
    }

    /**
     * Returns the piece that was that was last removed to it's original
     * location
     *
     */
    public void addBackTheRemovedPiece() {
        pieces.put(removedPiece.getLocation(), removedPiece);
        removedPiece = null;
    }

    public Piece getRemovedPiece() {
        return removedPiece;
    }

    /**
     * Erases the piece that was last removed from the game from memory
     */
    public void resetRemovedPiece() {
        removedPiece = null;
    }
}
