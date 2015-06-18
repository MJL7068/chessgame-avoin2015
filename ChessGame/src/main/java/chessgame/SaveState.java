package chessgame;

import chessgame.board.Board;
import chessgame.pieces.Piece;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class is used to save to information about the pieces in play and other
 * information about the game like the turn number
 *
 * @author mattilei
 */
public class SaveState {

    private Board board;
//    private ArrayList<String> loadStates;
    private String loadState;

    /**
     *
     * @param board SaveState gets the locations of pieces from the Board-class
     */
    public SaveState(Board board) {
        this.board = board;
//        this.loadStates = new ArrayList<String>();
    }

    /**
     * This method saves the pieces in play using notation similar to
     * Forsyth-Edwards notation
     */
    public void saveCurrentGame() {
        String notation = getFonNotation() + ":" + board.getTurns() + ":" + board.getNotification() + ":"
                + board.getGameOver() + ":" + board.getWhitePlayerName() + ":" + board.getBlackPlayerName();

        try {
            FileWriter writer = new FileWriter("saves.txt");

            writer.write(notation);
            writer.close();

            board.setNotification("The game has been saved");
        } catch (Exception e) {
            board.setNotification("The game has not been saved");
        }

        this.loadState = notation;
    }

    /**
     * This method resets the board and sets new parameters based on the
     * information stored
     */
    public void loadGame() {
        if (loadState == null) {
            JOptionPane.showMessageDialog(null, "The file is empty");
        } else {
            board.reset(loadState);
        }
    }

    /**
     * This method return true if a saved data can be loaded from the file
     *
     * @return returns true if there is a save data available
     */
    public boolean isLoadAvaivable() {
        File file = new File("saves.txt");

        String loadState = "";

        try {
            Scanner reader = new Scanner(file);
            loadState = reader.nextLine();
            this.loadState = loadState;
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loading operation failed!");
        }
        if (loadState.equals("")) {
            JOptionPane.showMessageDialog(null, "The file is empty!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method return a single line-string that describes the current board
     * position of the game
     *
     * @return the String in FON notation
     */
    public String getFonNotation() {
        String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

        String fonNotation = "";

        int i = 0;
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                Piece piece = board.getPiece(columns[x - 1] + y);
                if (piece == null) {
                    i++;
                } else {
                    if (i > 0) {
                        fonNotation += i;
                    }
                    fonNotation += piece.returnNotation();
                    i = 0;
                }
            }
            if (i > 0) {
                fonNotation += i;
            }
            fonNotation += "/";
            i = 0;
        }

        return fonNotation;
    }
}
