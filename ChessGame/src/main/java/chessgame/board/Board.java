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
    
    //if a piece is active and awaiting order to move to a new place, this variable is true
    private boolean isTurnActive;
    //this variable stores the starting point of the move
    private String startingPoint;
    private boolean check;
    
    private String gameOver;
    private String whitePlayerName;
    private String  blackPlayerName;

    /**
     * This class contains information about the state of the game, like pieces on the board and
     * the state of the current turn. Methods are used to alter the state off the pieces and to update
     * the graphical interface.
     */
    public Board() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.isTurnActive = false;
        this.startingPoint = "";
        this.check = false;
        this.gameOver = "empty";
    }

    /**
     * This method will reset all the pieces to their original places and regenerate the pieces lost during the game
     */
    public void reset() {
        this.pieces = new Pieces();
        this.turns = 1;
        this.notification = "";

        this.isTurnActive = false;
        this.startingPoint = "";
        this.check = false;
        this.gameOver = "empty";

        gui.updateTable();
    }
    
    /**
     * This method resets the game according to loaded information
     * @param loadState this string contains the placement of all the pieces and other data,
     * like the number of turns, it's split into multiple parts, first contains the location
     * of the pieces, second the number of turns, third contains the last notification, fourth
     * tells whether the game is over or not and the last two contain the names of the players
     *  */
    public void reset(String loadState) {
        String[] loadStateParts = loadState.split(":");
        this.pieces = new Pieces(loadStateParts[0]);
        
        this.turns = Integer.parseInt(loadStateParts[1]);
        this.notification = loadStateParts[2];

        this.isTurnActive = false;
        this.startingPoint = "";
        this.check = false;
        this.gameOver = loadStateParts[3];
        
        this.whitePlayerName = loadStateParts[4];
        this.blackPlayerName = loadStateParts[5];

        gui.updateTable();
    }

    /**
     * This method returns true if the move of the piece from one square to another is valid. It checks
     * if there is a piece located in the place where the piece is to be moved and then if it can
     * be moved to the new location
     * @param oldPlace  the id of the square where the piece is moved from
     * @param newPlace the id of the square where the pieces is being moved to
     * @return whether the move from one square to another is valid
     */
    public boolean move(String oldPlace, String newPlace) {
        if (!lookForPiece(oldPlace)) {
            return false;
        }

        if (!pieces.getPiece(oldPlace).isValidMove(newPlace, pieces)) {
            notification = "Not a valid move!";
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
     * This method returns true if the piece on the location is the same color
     * as the color given in the parameter
     * @param location the location of the piece in question
     * @param color the color that the piece is compared to
     * @return
     */
    public boolean checkForColor(String location, String color) {
        if (!lookForPiece(location)) {
            return false;
        }

        if (!pieces.getPiece(location).getColor().equals(color)) {
            this.notification = "Not your pieces!";
            return false;
        }

        return true;
    }

    /**
     * This method is called if no piece is yet active. It checks if the selected piece
     * is valid and then stores the location of the selected square and paints gray all
     * the squares where the piece can move
     * @param squareId tells which piece was selected
     */
    public void firstPartOfTheTurn(String squareId) {
        if (gameOver.equals("Game over")) {            
            return;
        }
        if (checkForColor(squareId, getTurnColor())) {
            isTurnActive = true;
            startingPoint = squareId;
            notification = "move where?";
            gui.paintMovableSquares(pieces.getPiece(squareId).returnPossibleSquares(pieces));
        }
        gui.updateSquare(squareId);
        gui.updateLowerPanel();
    }

    /**
     * This method is called if the turn is active and there is a piece that is waiting
     * for a move order. The method will check if the move is valid and then perform the move.
     * Afterwards the board is updated.
     * @param squareId
     */
    public void secondPartOfTheTurn(String squareId) {
        if (move(startingPoint, squareId)) {
            pieces.move(startingPoint, squareId);
            notification = startingPoint + " moved to " + squareId;
            turns++;
            checkIfCheck(squareId);
        }

        isTurnActive = false;
        startingPoint = "";

        gui.updateTable();
    }
    
    /**
     * This method is used to check if the game is in check or if a move would cause it
     * to be in check-state.
     * @param id the location of the piece that is being moved when this method is called
     * @return returns true if a move causes or has already caused a check.
     */
    public boolean checkIfCheck(String id) {
        for (Piece piece : pieces.getPieces().values()) {
            if (piece.returnPossibleSquares(pieces).contains(pieces.getKing(getOpposingTurnColor()).getLocation())) {
                cancelTurn(id);
                notification = "Game is in check or move would cause a check!";
                gui.updateUpperPanel();
                return true;
            }
            
            if(piece.returnPossibleSquares(pieces).contains(pieces.getKing(getTurnColor()).getLocation())) {
                check = true;
                notification = "Check!";                
                gui.updateUpperPanel();
                gui.showCheckMessage();
            }
        }
        
        pieces.resetRemovedPiece();
        check = false;
        gui.updateUpperPanel();
        return false;
    }
    
    /**
     * This method cancel the movement of the piece and changes it back.
     * @param id
     */
    public void cancelTurn(String id) {
        pieces.move(id, startingPoint);
        if (pieces.getRemovedPiece() != null) {
            pieces.addPiece();
        }
        turns--;
    }
    
    public void setNotification(String notification) {
        this.notification = notification;
    }

    /**
     * Used to set the graphical interface as an attribute
     * @param gui
     */
    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }
    
    public void setWhitePlayerName(String name) {
        this.whitePlayerName = name;
    }
    
    public void setBlackPlayerName(String name) {
        this.blackPlayerName = name;
    }

    public String getWhitePlayerName() {
        return whitePlayerName;
    }

    public String getBlackPlayerName() {
        return blackPlayerName;
    }
    
    public void setGameState(String gameState) {
        this.gameOver = "Game over";
        notification = "Game over, " + getOpposingTurnColor() + " wins!";
        gui.updateLowerPanel();
    }

    /**
     * Returns the piece from the location
     * @param location
     * @return
     */
    public Piece getPiece(String location) {
        return pieces.getPiece(location);
    }

    /**
     * Returns true if the turn is underway
     * @return
     */
    public boolean getTurnState() {
        return isTurnActive;
    }

    /**
     * Returns the starting point of a turn
     * @return
     */
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
    
    public String getOpposingTurnColor() {
        if (turns % 2 != 0) {
            return "black";
        } else {
            return "white";
        }
    }

    public String getNotification() {
        return notification;
    }

    public int getTurns() {
        return turns;
    }
    
    public boolean getCheck() {
        return check;
    }

    public String getGameOver() {
        return gameOver;
    }    
}
