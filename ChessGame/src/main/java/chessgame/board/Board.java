package chessgame.board;

import chessgame.pieces.Piece;
import chessgame.userinterface.UserInterface;

public class Board {

    private Pieces pieces;

    private UserInterface gui;

    public Board() {
        this.pieces = new Pieces();
    }

    public boolean move(String oldPlace, String newPlace) {
        Piece movable = pieces.getPiece(oldPlace);
        if (movable == null) {
            System.out.println("There is no piece there!");
            return false;
        }
        
        if (!movable.isValidMove()) {
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

    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }
    
    public Piece getPiece(String location) {
        return pieces.getPiece(location);
    }

    public void printPieces() {
        pieces.printPieces();
    }
}
