package chessgame;
import chessgame.board.Board;
import chessgame.userinterface.UserInterface;
import javax.swing.SwingUtilities;

public class ChessGame {

    public static void main(String[] args) {
        Game game = new Game();

        Board board = new Board();
        UserInterface graphicalInterface = new UserInterface(board);
        
        board.setInterface(graphicalInterface);
        SwingUtilities.invokeLater(graphicalInterface);
    }

}
