package chessgame;

import chessgame.board.Board;
import chessgame.pieces.Piece;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author mattilei
 */
public class SaveState {
    private Board board;
    private ArrayList<String> loadStates;
    
    /**
     * This class is used to save to information about the pieces in play and
     * other information about the game like the turn number.
     * @param board
     */
    public SaveState(Board board) {
        this.board = board;
        this.loadStates = new ArrayList<String>();
    }
    
    /**
     * This method saves the pieces in play using notation similar to Forsyth-Edwards notation
     */
    public void saveCurrentGame() {
        String notation = getFONNotation() + ":" +  board.getTurns() + ":" + board.getNotification();
        loadStates.add(notation);
    }
    
    /**
     * This method resets the board and sets new parameters based on the information stored
     */
    public void loadGame() {
        board.reset(loadStates.get(loadStates.size() - 1));
    }
    
    /**
     * This method return a single line-string that describes the current board position of the game
     * @return
     */
    public String getFONNotation() {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        
        String FONNotation = "";
        
        int i = 0;
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                Piece piece = board.getPiece(columns[x - 1] + y);
                if (piece == null) {
                    i++;
                } else {
                    if (i > 0) {
                        FONNotation += i;
                    }
                    FONNotation += piece.returnNotation();
                    i = 0;
                }                
            }
            if (i > 0) {
                FONNotation += i;
            }
            FONNotation += "/";
            i = 0;
        }       
        System.out.println(FONNotation);
        return FONNotation;
    }
}
