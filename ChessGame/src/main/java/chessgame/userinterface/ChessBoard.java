package chessgame.userinterface;

import chessgame.board.Board;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 * This class is a component of the graphical interface. It contains 8x8
 * squares. Methods are used to access individual squares.
 *
 * @author mattilei
 */
public class ChessBoard {

    private Board board;
    private JPanel chessBoard;
    private Color dark;
    private Color light;

    private ArrayList<Square> squares;
    private HashMap<String, Square> squaresById;

    /**
     * The parameter creates 8 x 8 squares
     *
     * @param board
     */
    public ChessBoard(Board board) {
        this.board = board;
        this.dark = new Color(92, 129, 152);
        this.light = new Color(140, 150, 155);
        this.chessBoard = new JPanel(new GridLayout(8, 8));

        this.squares = new ArrayList<Square>();
        this.squaresById = new HashMap<String, Square>();

        generateSquares();
    }
    
    /**
     * This method creates all the squares, gives them their id's and then
     * stores them.
     *
     * @return
     */
    public void generateSquares() {
        final String[] columns = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        Color color = null;
        for (int y = 8; y >= 1; y--) {
            for (int x = 1; x <= 8; x++) {
                if (y % 2 == 0 && x % 2 == 0 || y % 2 != 0 && x % 2 != 0) {
                    color = dark;
                }

                if (y % 2 == 0 && x % 2 != 0 || y % 2 != 0 && x % 2 == 0) {
                    color = light;
                }

                String id = columns[x - 1] + y;
                Square newSquare = new Square(id, board, color);
                squares.add(newSquare);
                squaresById.put(newSquare.getId(), newSquare);
                JPanel square = newSquare.getSquare();

                chessBoard.add(square);
            }
        }
    }

    /**
     * Returns the JPanel representation of this class.
     *
     * @return
     */
    public JPanel getChessBoard() {
        return chessBoard;
    }

    /**
     * Returns all the squares stored in the ChessBoard-object.
     */
    ArrayList<Square> getSquares() {
        return squares;
    }

    /**
     * Returns the square stored in the ChessBoard-object
     *
     * @param id
     * @return
     */
    public Square getSquare(String id) {
        return squaresById.get(id);
    }

}
