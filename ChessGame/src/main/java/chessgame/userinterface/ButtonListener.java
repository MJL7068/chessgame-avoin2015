package chessgame.userinterface;
import chessgame.board.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private String squareId;
    private Board board;
    
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
