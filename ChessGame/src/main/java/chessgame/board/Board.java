package chessgame.board;
import chessgame.pieces.Piece;
import chessgame.userinterface.UserInterface;
import java.util.ArrayList;

public class Board {
    private Pieces pieces;
    
    private UserInterface gui;
    
    public Board() {
        this.pieces = new Pieces();
    }
    
    public void move(String input) {
        String[] parts = input.split(":");
        
        String oldPlace = parts[0];
        String newPlace = parts[1];
        
        Piece movable = pieces.getPiece(oldPlace);
        if (movable == null) {
            System.out.println("There is no piece there!");
            return;
        }
        
        movable.move(newPlace);
        System.out.println("new place: " + movable);
    }
    
    public void setInterface(UserInterface gui) {
        this.gui = gui;
    }
    
    public void printPieces() {
        pieces.printPieces();
    }
}