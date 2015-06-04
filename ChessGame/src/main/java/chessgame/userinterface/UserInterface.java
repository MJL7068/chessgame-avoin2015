package chessgame.userinterface;

import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author mattilei
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private Board board;

    private Color dark;
    private Color light;
    
    private ChessBoard chessBoard;
    private JLabel upperPanel;
    private JLabel lowerPanel;
    private ArrayList<Square> squares;

    /**
     * Generates the graphical user interface. Methods are used to alter different
     * components within it.
     * @param board
     */
    public UserInterface(Board board) {
        this.board = board;

        this.dark = new Color(92, 129, 152);
        this.light = new Color(140, 150, 155);
        
        this.squares = new ArrayList<Square>();
    }

    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(1250, 650));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(drawBoard());
    }

    private JPanel drawBoard() {
        JPanel gameBoard = new JPanel(new BorderLayout());

        gameBoard.add(createChessBoard());
        gameBoard.add(createUpperPanel(), BorderLayout.NORTH);
        gameBoard.add(createLowerPanel(), BorderLayout.SOUTH);

        return gameBoard;
    }

    private JPanel createChessBoard() {
        ChessBoard chessBoard = new ChessBoard(board);

        this.chessBoard = chessBoard;

        return chessBoard.getChessBoard();
    }
    
    /**
     * Creates a part of the interface, which contains the turn-counter.
     * @return returns the JPanel object
     */
    public JPanel createUpperPanel() {
        JPanel upperPanel = new JPanel();
        JLabel turn = new JLabel("    Turn: " + board.getTurns());
        upperPanel.add(turn);

        this.upperPanel = turn;

//        if (board.getTurns() % 2 == 0) {
//            upperPanel.setBackground(Color.black);
//        } else {
//            upperPanel.setBackground(Color.white);
//        }
        return upperPanel;
    }
    
    /**
     * Creates a part of the interface, which contains a notification of the 
     * current stage of the game
     * @return returns a JPanel object
     */
    public JPanel createLowerPanel() {
//        JPanel lowerPanel = new JPanel();
        
//        JButton reset = new JButton("Reset");
//        reset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                board.reset();
//            }
//        });
//        
//        lowerPanel.add(reset);
        JPanel lowerPanel = new JPanel();
        JLabel message = new JLabel("Message: " + board.getNotification());
        lowerPanel.add(message);

        this.lowerPanel = message;
        return lowerPanel;
    }

    /**
     * Updates the whole interface
     */
    public void updateTable() {
        updateChessBoard();
        updateLowerPanel();
        updateUpperPanel();
    }

    /**
     * Updates the upper panel according to the board
     */
    public void updateUpperPanel() {
        upperPanel.setText("    Turn: " + board.getTurns());
    }

    /**
     * Updates the lower panel according to the board
     */
    public void updateLowerPanel() {
        lowerPanel.setText("Message: " + board.getNotification());
    }

    /**
     *
     */
    public void updateChessBoard() {
        ArrayList<Square> squares = chessBoard.getSquares();
        for (Square square : squares) {
            updateSquare(square.getId());
        }
    }
    
    /**
     * Updates a single square
     * @param id
     */
    public void updateSquare(String id) {
        Square square = chessBoard.getSquare(id);
        square.update(board);
    }

    /**
     *
     * @param squares
     */
    public void paintMovableSquares(HashSet<String> squares) {
        for (String squareId : squares) {
            Square square = chessBoard.getSquare(squareId);
            if (square != null) {
            square.paintBackground(Color.LIGHT_GRAY);
            }
        }
    }    

}
