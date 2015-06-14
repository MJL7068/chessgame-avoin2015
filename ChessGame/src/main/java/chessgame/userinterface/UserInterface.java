package chessgame.userinterface;
import chessgame.SaveState;
import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JLabel whitePlayerName;
    private JLabel blackPlayerName;
    
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
        frame.setPreferredSize(new Dimension(550, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
//        container.add(drawBoard());
        container.add(startMenu());
    }
    
    /**
     * A component of the graphical interface that has the option to select the
     * players name, start a new game or load the last saved game
     * @return returns the JPanel object that contains the menu
     */
    private JPanel startMenu() {
        JPanel menu = new JPanel();
        
        JPanel startMenu = new JPanel(new GridLayout(8, 2));

        JLabel playerOne = new JLabel(" White players name: ");
        final JTextField playerOneField = new JTextField();
        JLabel playerTwo = new JLabel(" Black players name: ");
        final JTextField playerTwoField = new JTextField();

        JButton start = new JButton("Start a new game!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!playerOneField.getText().isEmpty() && !playerTwoField.getText().isEmpty()) {
                board.setWhitePlayerName(playerOneField.getText());
                board.setBlackPlayerName(playerTwoField.getText());
                
                //The game is started
                frame.setContentPane(drawBoard());
                updateTable();
                frame.validate();
                frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "You have to input player names!");
                }
            }
        });
        
        JButton load = new JButton("Load your last saved game!");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                               
                frame.setContentPane(drawBoard());
                updateTable();
                frame.validate();
                frame.repaint();
                
                saveState.loadGame();
            }
        });
        
        startMenu.add(playerOne);
        startMenu.add(playerOneField);
        startMenu.add(playerTwo);
        startMenu.add(playerTwoField);
        startMenu.add(new JLabel(""));
        startMenu.add(load);
        startMenu.add(new JLabel(""));
        startMenu.add(start);

//        return startMenu;
        menu.add(startMenu);
        return menu;
    }
    
    /**
     * A component of the graphical interface that has all the components of the
     * gameboard.
     * @return returns the JPanel object that contains the board
     */
    private JPanel drawBoard() {
        JPanel gameBoard = new JPanel(new BorderLayout());

        gameBoard.add(createSavePanel(), BorderLayout.EAST);
        gameBoard.add(createSurrenderPanel(), BorderLayout.WEST);

        gameBoard.add(createChessBoard());
        gameBoard.add(createUpperPanel(), BorderLayout.NORTH);
        gameBoard.add(createLowerPanel(), BorderLayout.SOUTH);

        return gameBoard;
    }
    
    /**
     * A component of the graphical interface that has buttons to reset and to
     * end the game
     * @return returns the JPanel object that contains the panel
     */
    private JPanel createSurrenderPanel() {
        JPanel surrenderPanel = new JPanel(new GridLayout(2, 1));
        
        //surrenderpanel is also used to store the reset-button
        JButton reset = new JButton("Reset");
        reset.setToolTipText("Reset the game");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });

        surrenderPanel.add(reset);      
        
        JButton surrender = new JButton("Give up");
        surrender.setToolTipText("Surrender the game");
        surrender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setGameState("Game over");
                showGameOverMessage();
                updateLowerPanel();
            }
        });
        
        surrenderPanel.add(surrender);
        
        return surrenderPanel;
    }
    
    /**
     * A component of the graphical interface that has buttons to save the game
     * and to load the last saved game
     * @return returns the JPanel object that contains the panel
     */
    private JPanel createSavePanel() {
        JPanel savePanel = new JPanel(new GridLayout(2, 1));

        JButton save = new JButton("Save");
        
        save.setToolTipText("Save your game");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveState.saveCurrentGame();
            }
        });
        savePanel.add(save);

        JButton load = new JButton("Load");
        load.setToolTipText("Load the last saved game");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveState.loadGame();
            }
        });
        savePanel.add(load);

        return savePanel;
    }
    
    /**
     * This method creates the ChessBoard-object that contains all the squares
     * of the board.
     * @return returns the JPanel object that contains the board
     */
    private JPanel createChessBoard() {
        ChessBoard chessBoard = new ChessBoard(board);

        this.chessBoard = chessBoard;

        return chessBoard.getChessBoard();
    }

    /**
     * Creates a part of the interface, which contains the turn-counter and the
     * name of the black player.
     *
     * @return returns the JPanel object
     */
    public JPanel createUpperPanel() {
        JPanel upperPanel = new JPanel(new GridLayout(2, 1));
        
        JLabel name = new JLabel(" Black player: " + board.getBlackPlayerName());
        upperPanel.add(name);
        blackPlayerName = name;
        
        JLabel turn = new JLabel();
        upperPanel.add(turn);
        this.upperPanel = turn;

        return upperPanel;
    }

    /**
     * Creates a part of the interface, which contains a notification of the
     * current stage of the game and the name of the white player
     *
     * @return returns a JPanel object
     */
    public JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel(new GridLayout(2, 1));  
        
        JLabel message = new JLabel();
        lowerPanel.add(message);
        
        JLabel name = new JLabel(" White player: " + board.getWhitePlayerName());
        lowerPanel.add(name);
        whitePlayerName = name;

        this.lowerPanel = message;
        return lowerPanel;
    }

    /**
     * Updates the entire interface
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
        upperPanel.setText(" Turn: " + board.getTurns() + ", " + board.getTurnColor() + "s turn to move");
        blackPlayerName.setText(" Black player: " + board.getBlackPlayerName());
    }

    /**
     * Updates the lower panel according to the board
     */
    public void updateLowerPanel() {        
        lowerPanel.setText(" Message: " + board.getNotification());
        whitePlayerName.setText(" White player: " + board.getWhitePlayerName());
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
     * Paints the squares specified in the parameter to a lighter color. Used
     * to show the possible moves of a piece.
     * @param squares contains the location of the squares to be painted
     */
    public void paintMovableSquares(HashSet<String> squares) {
        for (String squareId : squares) {
            Square square = chessBoard.getSquare(squareId);
            if (square != null) {
                square.paintBackgroundLighter();
            }
        }
    }
    
    /**
     * Shows a notification that a check-state has occurred.
     */
    public void showCheckMessage() {
        JOptionPane.showMessageDialog(frame, "Check!");
    }
    
    /**
     * Shows a notification that the game has ended. Also shows the winner.
     */
    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(frame, "Game over, " + board.getOpposingTurnColor() + " wins!");
    }

}
