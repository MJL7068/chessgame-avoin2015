package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.userinterface.UserInterface;

/**
 *
 * @author mattilei
 */
public class Board {

    private Pieces pieces;
    private UserInterface gui;
    private int turns;
    private String notification;

    private boolean turnState;
    private String startingPoint;

    /**
     * This class contains information about the state of the game, like pieces on the board and
     * the state of the current turn. Methods are used to alter the state off the pieces and to update
     * the graphical interface.
     */
    public Board() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.turnState = false;
        this.startingPoint = "";
    }

    /**
     * This method will reset all the pieces to their original places and regenerate the pieces lost during the game
     */
    public void reset() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.turnState = false;
        this.startingPoint = "";

        gui.updateTable();
    }

    /**
     * This method returns true if the move of the piece from one square to another is valid
     * @param oldPlace  the id of the square where the piece is moved from
     * @param newPlace the id of the square where the pieces is being moved to
     * @return whether the move from one square to another is valid
     */
    public boolean move(String oldPlace, String newPlace) {
        if (!lookForPiece(oldPlace)) {
            return false;
        }

        if (!pieces.getPiece(oldPlace).isValidMove(newPlace, pieces)) {
            System.out.println("Not a valid move!");
            return false;
        }

        return true;
    }

    /**
     * Method returns true if there is a piece on the square
     * @param id the id of the square 
     * @return whether there is a piece on the square
     */
    public boolean lookForPiece(String id) {
        Piece piece = pieces.getPiece(id);
        if (piece == null) {
            this.notification = "There is no piece there!";
            return false;
        }

        return true;
    }

    /**
     *
     * @param location
     * @param color
     * @return
     */
    public boolean checkForColor(String location, String color) {
        if (!lookForPiece(location)) {
            return false;
        }

        if (!pieces.getPiece(location).getColor().equals(color)) {
            this.notification = "Not your pieces!";
//            System.out.println(notification);
            return false;
        }

        return true;
    }

    /**
     *
     * @param squareId
     */
    public void turnFirstPart(String squareId) {
        if (checkForColor(squareId, getTurnColor())) {
            turnState = true;
            startingPoint = squareId;
            notification = "move where?";
            gui.paintMovableSquares(pieces.getPiece(squareId).returnPossibleSquares(pieces));
        }
//        updateGui();
        gui.updateSquare(squareId);
        gui.updateLowerPanel();
    }

    /**
     *
     * @param squareId
     */
    public void turnSecondPart(String squareId) {
        if (move(startingPoint, squareId)) {
            pieces.move(startingPoint, squareId);

            turns++;
        }

        turnState = false;
//        String startPoint = startingPoint;
        startingPoint = "";

//        gui.updateSquare(startPoint);
//        gui.updateSquare(squareId);
        gui.updateTable();        
    }

    /**
     *
     * @param gui
     */
    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }

    /**
     *
     * @param location
     * @return
     */
    public Piece getPiece(String location) {
        return pieces.getPiece(location);
    }

    /**
     *
     * @return
     */
    public boolean getTurnState() {
        return turnState;
    }

    /**
     *
     * @return
     */
    public String getStartingPoint() {
        return startingPoint;
    }

    /**
     *
     * @return
     */
    public String getTurnColor() {
        if (turns % 2 != 0) {
            return "white";
        } else {
            return "black";
        }
    }

    /**
     *
     * @return
     */
    public String getNotification() {
        return notification;
    }

    /**
     *
     * @return
     */
    public int getTurns() {
        return turns;
    }

    /**
     *
     */
    public void printPieces() {
        pieces.printPieces();
    }
}
