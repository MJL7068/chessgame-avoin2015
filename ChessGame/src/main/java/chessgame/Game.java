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

    public void start() {
        while (true) {
            System.out.println("\nMovable pieces:");
            board.printPieces();
            System.out.println("");
            round();
        }
    }

    public void round() {
        Scanner l = new Scanner(System.in);
        System.out.print("Input next move (ex. A2:A4): ");
        String input = l.nextLine();

        String[] parts = input.split(":");

        String oldPlace = parts[0];
        String newPlace = parts[1];

        board.turn(oldPlace, newPlace);
    }
}
