package chessgame.userinterface;

import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Board board;

    private Color dark;
    private Color light;
    
    private ArrayList<Square> squares;

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
        gameBoard.add(createLowerPanel(), BorderLayout.SOUTH);

        return gameBoard;
    }

    private JPanel createChessBoard() {
        JPanel chessBoard = new JPanel(new GridLayout(8, 8));

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
                JPanel square = newSquare.getSquare();

                chessBoard.add(square);
            }
        }

        return chessBoard;
    }
    
    public JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel();
        
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });
        
        lowerPanel.add(reset);
        return lowerPanel;
    }

    public void updateTable() {
        frame.setContentPane(drawBoard());
        frame.validate();
        frame.repaint();
    }

}
