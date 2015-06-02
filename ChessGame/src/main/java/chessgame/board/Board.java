package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.userinterface.UserInterface;

public class Board {

    private Pieces pieces;
    private UserInterface gui;
    private int turns;
    private String notification;

    private boolean turnState;
    private String startingPoint;

    public Board() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.turnState = false;
        this.startingPoint = "";
    }

    public void reset() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.turnState = false;
        this.startingPoint = "";

        gui.updateTable();
    }

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

    public boolean lookForPiece(String id) {
        Piece piece = pieces.getPiece(id);
        if (piece == null) {
            this.notification = "There is no piece there!";
            return false;
        }

        return true;
    }

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

    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }

    public Piece getPiece(String location) {
        return pieces.getPiece(location);
    }

    public boolean getTurnState() {
        return turnState;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getTurnColor() {
        if (turns % 2 != 0) {
            return "white";
        } else {
            return "black";
        }
    }

    public String getNotification() {
        return notification;
    }

    public int getTurns() {
        return turns;
    }

    public void printPieces() {
        pieces.printPieces();
    }
}
