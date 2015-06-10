package chessgame.userinterface;

import chessgame.SaveState;
import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private JLabel checkState;
    private ArrayList<Square> squares;

    private SaveState saveState;

    /**
     * Generates the graphical user interface. Methods are used to alter
     * different components within it.
     *
     * @param board
     */
    public UserInterface(Board board) {
        this.board = board;

        this.dark = new Color(92, 129, 152);
        this.light = new Color(140, 150, 155);

        this.squares = new ArrayList<Square>();

        this.saveState = new SaveState(board);
    }

    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
//        container.add(drawBoard());
        container.add(startMenu());
    }

    private JPanel startMenu() {
        JPanel startMenu = new JPanel(new GridLayout(3, 2));

        JLabel playerOne = new JLabel("White players name: ");
        final JTextField playerOneField = new JTextField();
        JLabel playerTwo = new JLabel("Black players name: ");
        final JTextField playerTwoField = new JTextField();

        JButton start = new JButton("Start!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setWhitePlayerName(playerOneField.getText());
                board.setBlackPlayerName(playerTwoField.getText());
                
                frame.setContentPane(drawBoard());
                updateTable();
                frame.validate();
                frame.repaint();
            }
        });

        startMenu.add(playerOne);
        startMenu.add(playerOneField);
        startMenu.add(playerTwo);
        startMenu.add(playerTwoField);
        startMenu.add(new JLabel(""));
        startMenu.add(start);

        return startMenu;
    }

    private JPanel drawBoard() {
        JPanel gameBoard = new JPanel(new BorderLayout());

        gameBoard.add(createSavePanel(), BorderLayout.EAST);
//        gameBoard.add(createSurrenderPanel(), BorderLayout.WEST);

        gameBoard.add(createChessBoard());
        gameBoard.add(createUpperPanel(), BorderLayout.NORTH);
        gameBoard.add(createLowerPanel(), BorderLayout.SOUTH);

        return gameBoard;
    }
    
    private JButton createSurrenderPanel() {
//        JPanel surrenderPanel = new JPanel();
        
        JButton surrender = new JButton("Surrender");
        surrender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setGameState("Game over");
            }
        });
        
        return surrender;
//        surrenderPanel.add(surrender);
//        return surrenderPanel;
    }

    private JPanel createSavePanel() {
        JPanel savePanel = new JPanel(new GridLayout(2, 1));

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveState.saveCurrentGame();
            }
        });
        savePanel.add(save);

        JButton load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveState.loadGame();
            }
        });
        savePanel.add(load);

        return savePanel;
    }

    private JPanel createChessBoard() {
        ChessBoard chessBoard = new ChessBoard(board);

        this.chessBoard = chessBoard;

        return chessBoard.getChessBoard();
    }

    /**
     * Creates a part of the interface, which contains the turn-counter.
     *
     * @return returns the JPanel object
     */
    public JPanel createUpperPanel() {
        JPanel upperPanel = new JPanel(new GridLayout(1, 4));
        
        JLabel name = new JLabel(board.getBlackPlayerName());
        upperPanel.add(name);
        
        JLabel turn = new JLabel("    Turn: " + board.getTurns());
        upperPanel.add(turn);

        this.upperPanel = turn;

//        if (board.getTurns() % 2 == 0) {
//            upperPanel.setBackground(Color.black);
//        } else {
//            upperPanel.setBackground(Color.white);
//        }
        JLabel checkState = new JLabel("");
        this.checkState = checkState;
        upperPanel.add(checkState);

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });

        upperPanel.add(reset);

        return upperPanel;
    }

    /**
     * Creates a part of the interface, which contains a notification of the
     * current stage of the game
     *
     * @return returns a JPanel object
     */
    public JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel(new GridLayout(1, 2));        
        JLabel message = new JLabel("Message: " + board.getNotification());
        lowerPanel.add(message);
        
        JLabel name = new JLabel(board.getWhitePlayerName());
        lowerPanel.add(name);

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

        if (board.getCheck()) {
            checkState.setText("CHECK!");
        } else {
            checkState.setText("");
        }
    }

    /**
     * Updates the lower panel according to the board
     */
    public void updateLowerPanel() {
        lowerPanel.setText("Message: " + board.getNotification());
    }

    /**
     * Updates the entire board
     */
    public void updateChessBoard() {
        ArrayList<Square> squares = chessBoard.getSquares();
        for (Square square : squares) {
            updateSquare(square.getId());
        }
    }

    /**
     * Updates a single square
     *
     * @param id what are the squares coordinates
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
