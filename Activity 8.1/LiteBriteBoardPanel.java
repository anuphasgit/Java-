import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class LiteBriteBoardPanel  extends JPanel{
    private LitePegButton[][] board;
    private final int BUTTON_DIMENSON = 30;

    public LiteBriteBoardPanel(int width, int height){
        this.setLayout(new GridLayout(height, width));
        board = new LitePegButton[height][width];
        for (int row = 0; row< height; row++){
            for(int col = 0;col<width;col++){
                board[row][col]= new LitePegButton();//create component
                board[row][col].setPreferredSize(new Dimension(BUTTON_DIMENSON,BUTTON_DIMENSON));//config component
                this.add(board[row][col]);//add to layout
            }
        }
    }

    public void reset() {
        for (int row = 0; row< board.length; row++){
            for(int col = 0;col<board[row].length;col++){
                board[row][col].reset();
            }
    }
    }
}
