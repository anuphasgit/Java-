
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Main panel for LiteBrite activities.
 * Top-level organizer and coordinator between sub-panels/controls. 
 * 
 * @author mvail
 */

public class LiteBritePanel extends JPanel {
	private LiteBriteBoardPanel board;
	private final int BOARD_DIMENSION = 20;
	
	
	/**
	 * Initialize top-level panel with a LitePegButton (for testing) or 
	 * LiteBriteBoardPanel (final). Also adds a reset button to reset all
	 * pegs in the final LiteBriteBoardPanel.
	 */
	public LiteBritePanel() {
		
		board = new LiteBriteBoardPanel(BOARD_DIMENSION, BOARD_DIMENSION);
		this.add(board);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont (new Font("Arial", Font.PLAIN, 24));
		resetButton.addActionListener(new ResetButtonListener());		
		this.add(resetButton);
	}
	
	/**
	 * Private listener class to respond to reset button clicks.
	 * Notifies LiteBriteBoardPanel to reset all pegs to black.
	 */
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			board.reset();
		}
	}
}
