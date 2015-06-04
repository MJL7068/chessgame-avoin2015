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
     * @param id
     * @param board
     * @param color
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
            button = new JButton(board.getPiece(id).toString());
//            button = new JButton(board.getPiece(id).getImage());
        }
        
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new ButtonListener(id, board));
        
        square.add(button);
    }
    
    /**
     *
     * @return
     */
    public JPanel getSquare() {
        return square;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }
    
    public void update(Board board) {
        JButton button = getButton();
            clearBackground();
            if (board.getPiece(id) == null) {
                button.setText("");
            } else {
                button.setText(board.getPiece(id).toString());
            }
            
            if (id.equals(board.getStartingPoint())) {
                paintBackground(Color.white);
            }
    }
    
    /**
     * Paints the background of the square based on the parameter
     * @param color
     */
    public void paintBackground(Color color) {        
        this.square.setBackground(color);
    }

    /**
     * Turns the background of the square back
     */
    public void clearBackground() {
        this.square.setBackground(color);
    }

    /**
     *
     * @return
     */
    public JButton getButton() {
        return button;
    }
}
