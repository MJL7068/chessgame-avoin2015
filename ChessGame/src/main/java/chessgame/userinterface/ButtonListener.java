package chessgame.userinterface;

import chessgame.board.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class determines what happens when a JButton object is pressed on the
 * interface.
 *
 * @author mattilei
 */
public class ButtonListener implements ActionListener {

    private String squareId;
    private Board board;

    /**
     * 
     * @param squareId this parameter tells what are the squares coordinates
     * @param board ButtonListener sends the method call to board when the button
     * is pressed
     */
    public ButtonListener(String squareId, Board board) {
        this.squareId = squareId;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If turn is not active, call this method
        if (!board.getTurnState()) {
            board.firstPartOfTheTurn(squareId);
        } else {
         // If turn is active, call this method
            board.secondPartOfTheTurn(squareId);
        }
    }

}
