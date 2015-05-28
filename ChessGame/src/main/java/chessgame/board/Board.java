package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.userinterface.UserInterface;

public class Board {

    private Pieces pieces;
    private UserInterface gui;

    private boolean turnState;
    private String startingPoint;

    public Board() {
        this.pieces = new Pieces();

        this.turnState = false;
        this.startingPoint = "";
    }
    
    public void reset() {
        this.pieces = new Pieces();
        
        this.turnState = false;
        this.startingPoint = "";
        
        gui.updateTable();
    }

    public boolean move(String oldPlace, String newPlace) {
        if (!lookForPiece(oldPlace)) {
            return false;
        }

        if (!pieces.getPiece(oldPlace).isValidMove()) {
            System.out.println("Not a valid move!");
            return false;
        }

        return true;
    }

    public void turn(String oldPlace, String newPlace) {
        Piece movable = pieces.getPiece(oldPlace);

        if (move(oldPlace, newPlace)) {
            pieces.move(oldPlace, newPlace);
            System.out.println("new place: " + movable);
            gui.updateTable();
        }
    }

    private boolean lookForPiece(String id) {
        Piece piece = pieces.getPiece(id);
        if (piece == null) {
            System.out.println("There is no piece there!");
            return false;
        }

        return true;
    }

    public void turnFirstPart(String squareId) {
        if (lookForPiece(squareId)) {
            turnState = true;
            startingPoint = squareId;
        }
    }

    public void turnSecondPart(String squareId) {
        if (move(startingPoint, squareId)) {
            pieces.move(startingPoint, squareId);
        }

        startingPoint = "";
        turnState = false;
        
        gui.updateTable();
    }

    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }

    public Piece getPiece(String location) {
        return pieces.getPiece(location);
    }

    public boolean getTurnState() {
        return turnState;
    }

    public void printPieces() {
        pieces.printPieces();
    }
}
