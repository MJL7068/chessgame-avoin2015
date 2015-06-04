package chessgame.userinterface;
import chessgame.board.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mattilei
 */
public class ButtonListener implements ActionListener {
    private String squareId;
    private Board board;
    
    /**
     * This class determines what happens when a JButton object is pressed on
     * the interface.
     * @param squareId
     * @param board
     */
    public ButtonListener(String squareId, Board board) {
        this.squareId = squareId;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (!board.getTurnState()) {
             board.turnFirstPart(squareId);
         } else {
             board.turnSecondPart(squareId);
         }
    }
    
}
