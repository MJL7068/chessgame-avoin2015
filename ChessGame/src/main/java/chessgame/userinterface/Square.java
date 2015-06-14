package chessgame.userinterface;
import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mattilei
 */
public class Square {
    private JPanel square;
    private JButton button;
    
    private String id;
    private Color color;
    
    /**
     * This class is a component of the graphical interface. It contains a JPanel,
     * that can to updated to reflect the reflect the changes on the board.
     * @param id the chessboard is composed of 8 x 8 squares. The coordinates of
     * the squares are stored in the id
     * @param board the square updates itself based on the information stored in
     * the board class
     * @param color this parameter tells whether this square is light or dark
     */
    public Square(String id, Board board, Color color) {
        this.square = new JPanel(new BorderLayout());
        this.id = id;
        this.color = color;
        
        square.setBackground(color);
        square.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        this.button = null;
        
        if (board.getPiece(id) == null) {
            button = new JButton();
        } else {
            button = new JButton(board.getPiece(id).getImage());
        }
        
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new ButtonListener(id, board));
        
        square.add(button);
    }
    
    /**
     * Returns the JPanel representation of this class.
     * @return
     */
    public JPanel getSquare() {
        return square;
    }

    public String getId() {
        return id;
    }
    
    /**
     * This method causes the square to update itself based on the information
     * found in the board class
     * @param board
     */
    public void update(Board board) {
        JButton button = getButton();
            clearBackground();
            if (board.getPiece(id) == null) {
                button.setIcon(null);
            } else {
                button.setIcon(board.getPiece(id).getImage());
            }
            
            if (id.equals(board.getStartingPoint())) {
                paintBackgroundWhite();
            }
    }
    
    /**
     * Paints the background of the square white
     */
    public void paintBackgroundWhite() {
        this.square.setBackground(Color.white);
    }
    
    /**
     * Paints the background of the square in lighter color than it was originally
     */
    public void paintBackgroundLighter() {
        Color light = new Color(color.getRed() + 52, color.getGreen() + 42, color.getBlue() + 37);
        this.square.setBackground(light);
    }

    /**
     * Turns the background of the square back to normal color
     */
    public void clearBackground() {
        this.square.setBackground(color);
    }

    /**
     * Returns the JButton-object that is stored in this class.
     * @return
     */
    public JButton getButton() {
        return button;
    }
}
