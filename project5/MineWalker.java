import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This main method creates a new JFrame with a MineWalkerPanrl.
 */

public class MineWalker {
    public static void main(String[] args){
        JFrame frame = new JFrame("MineWalker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MineWalkerPanel panel = new MineWalkerPanel();
        frame.setPreferredSize(new Dimension(800, 700));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}


