package chessgame.userinterface;

import chessgame.board.Board;
import chessgame.pieces.Piece;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Board board;

    private Color dark;
    private Color light;

    public UserInterface(Board board) {
        this.board = board;

        this.dark = new Color(92, 129, 152);
        this.light = new Color(140, 150, 155);
    }

    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(1000, 500));

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

        gameBoard.add(createLowerPanel(), BorderLayout.SOUTH);
        gameBoard.add(createChessBoard());

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

                JPanel square = createSquare(id, color);

                chessBoard.add(square);
            }
        }

        return chessBoard;
    }

    public JPanel createSquare(String id, Color color) {
        JPanel square = new JPanel(new GridLayout(2, 1));

        square.add(new JLabel(id));

        Piece piece = board.getPiece(id);
        if (piece != null) {
            square.add(new JLabel(piece.toString()));
        }

        square.setBackground(color);

        return square;
    }

    private JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel(new GridLayout(1, 3));
        final JTextField from = new JTextField();
        final JTextField to = new JTextField();
        JButton send = new JButton("Send order");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPlace = from.getText();
                String newPlace = to.getText();

                board.turn(oldPlace, newPlace);                
            }
        });

        lowerPanel.add(from);
        lowerPanel.add(to);
        lowerPanel.add(send);

        return lowerPanel;
    }
    
    public void updateTable() {
        frame.setContentPane(drawBoard());
        frame.validate();
        frame.repaint();
    }

}
