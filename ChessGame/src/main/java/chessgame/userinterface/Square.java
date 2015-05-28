package chessgame.userinterface;
import chessgame.board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Square {
    private JPanel square;
    private JButton button;
    
    private String id;
    private Color color;
    
    public Square(String id, Board board, Color color) {
        this.square = new JPanel(new BorderLayout());
        this.id = id;
        this.color = color;
        
        square.setBackground(color);
        
        this.button = null;
        
        if (board.getPiece(id) == null) {
            button = new JButton(id);
        } else {
            button = new JButton(board.getPiece(id).toString());
        }
        
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new ButtonListener(id, board));
        
        square.add(button);
    }
    
    public JPanel getSquare() {
        return square;
    }
}
