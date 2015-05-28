package chessgame;

import chessgame.board.Board;
import chessgame.userinterface.UserInterface;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Game {

    private Board board;
    private UserInterface gui;

    public Game() {
        this.board = new Board();
        this.gui = new UserInterface(board);

        board.setInterface(gui);
        SwingUtilities.invokeLater(gui);
    }
}
