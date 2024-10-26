
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * The MineWalkerPanel class creates a panel for a minewalker game
 * The players goal is to reach the bottom right corner from top left avoiding the mines
 * There are four sub panels within the MineWalkerPanel
 * The top panel has a button for calling a new game and a text field to allow user to set the difficulty of game
 * The color key panel shows the color key for the game board
 * The game grid panel consists of a 10x10 minewalker game board
 * The lives panel shows the number of lives remaining.
 * 
 * @author Anup Bhattarai
 */
public class MineWalkerPanel extends JPanel {

    private final int GAMEGRID = 10;
    private final int DEFAULTMINES = 30;
    private final Color[] COLORS = {Color.green,Color.yellow,Color.orange,Color.red,Color.black,Color.gray};
    ArrayList <Point> randomPath;
    TileButton[][] tiles = new TileButton[GAMEGRID][GAMEGRID];
    private int livesLeft  = 5;
    TileButton player;
    JLabel livesRemaining;
    JTextField minePercentField;

    public MineWalkerPanel() {
        this.setLayout(new BorderLayout());

        // Making a panel that has new game button and minepercent 
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JButton newGame = new JButton();
        newGame.setText("New Game");
        newGame.addActionListener(new NewGameListener());

        JLabel minePercent = new JLabel();
        minePercent.setText("Mine Percent(10-50)");
        minePercentField = new JTextField(DEFAULTMINES+"");
        minePercentField.setEditable(true);

        topPanel.add(newGame);
        topPanel.add(minePercent);
        topPanel.add(minePercentField);

        // making a game board panel of dimension 10x10
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(GAMEGRID, GAMEGRID));
        
        for (int row = 0; row < GAMEGRID; row++) {
            for (int col = 0; col < GAMEGRID; col++) {
                tiles[row][col] = new TileButton(row, col);
                tiles[row][col].setBackground(COLORS[5]);
                tiles[row][col].setPreferredSize(new Dimension(GAMEGRID, GAMEGRID));
                tiles[row][col].setEnabled(true);
                tiles[row][col].addActionListener(new TileButtonListener(row, col));
                gamePanel.add(tiles[row][col]);
            }
        }

        //calls new game method to start a new game
        this.NewGame();

        //making a color key panel 
        JPanel colorKeyPanel = new JPanel();
        colorKeyPanel.setLayout(new BoxLayout(colorKeyPanel, BoxLayout.Y_AXIS));
        colorKeyPanel.setBorder(BorderFactory.createTitledBorder("Color Key"));
        
        //Making a textfield for 0 mines neighbourand set background to green
        JTextField t0 = new JTextField("0 Nearby mines");
        t0.setEditable(false);
        t0.setBackground(Color.GREEN);
        colorKeyPanel.add(t0);

        // textfield for 1 nearby mine and set background to yellow
        JTextField t1 = new JTextField("1 Nearby mine");
        t1.setEditable(false);
        t1.setBackground(Color.YELLOW);
        colorKeyPanel.add(t1);
        add(colorKeyPanel,BorderLayout.WEST);

        // textfield for 2 nearby mines and set background color to orange
        JTextField t2 = new JTextField("2 Nearby mines");
        t2.setEditable(false);
        t2.setBackground(Color.ORANGE);
        colorKeyPanel.add(t2);
       
        //textfield for 3 nearby mines and set background to red
        JTextField t3 = new JTextField("3 Nearby mines");
        t3.setEditable(false);
        t3.setBackground(Color.RED);
        colorKeyPanel.add(t3);
   
        //textfield for mines exploded and set background to black
        JTextField t4 = new JTextField("Mines Exploded");
        t4.setEditable(false);
        t4.setForeground(Color.WHITE);
        t4.setBackground(Color.BLACK);
        colorKeyPanel.add(t4);


        JTextField t5 = new JTextField("X <- You");
        t5.setEditable(false);
        t5.setBackground(Color.LIGHT_GRAY);
        t5.setHorizontalAlignment(JTextField.CENTER);
        colorKeyPanel.add(t5);

        // making a panel that displays the remaining lives 
        JPanel livesPanel = new JPanel();
        livesPanel.setLayout(new FlowLayout());
        livesRemaining = new JLabel("Lives: "+ livesLeft );
        livesPanel.add(livesRemaining);

        //adding all the sub panels to the minewalker panel 
        this.add(livesPanel,BorderLayout.SOUTH);  
        this.add(colorKeyPanel,BorderLayout.EAST);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(gamePanel,BorderLayout.CENTER);
      
   
    }
 
    // inner class that handles button clicks on the tiles
    private class TileButtonListener implements ActionListener{
        private int playersRow;
        private int playersCol;


        // Constructor
        public TileButtonListener(int row , int col){
            playersRow = row;
            playersCol = col;
        }

        public void actionPerformed(ActionEvent e){
            int currentRow = player.getLocation().x;
            int currentCol = player.getLocation().y;
            
            //checking if the player clicked the current tile
            if(playersRow == currentRow&& currentCol==playersCol){
                return;
            }

            int rowDifference = currentRow - playersRow;
            int colDifference = currentCol - playersCol;

            //checking if the clicked tile is adjacent to current tile
            if((rowDifference == -1||rowDifference ==1)&&colDifference==0){
              
            }else if((colDifference == -1||colDifference==1)&&(rowDifference==0)){
              
            }else if (rowDifference!=0||colDifference!=0){
                return;
            }
            
            if (!tiles[playersRow][playersCol].isMine() && tiles[playersRow][playersCol].isHidden()) {
                player = tiles[playersRow][playersCol];
                tiles[playersRow][playersCol].setHidden(false);
                tiles[playersRow][playersCol].setBackground(COLORS[tiles[playersRow][playersCol].getNumMineNeighbors()]);
                tiles[playersRow][playersCol].setText(null);
                tiles[playersRow][playersCol].setText("X");

                //checks if the player has won the game and displays the message 
                if (playersRow == GAMEGRID - 1 && playersCol == GAMEGRID - 1) {
                    JOptionPane.showMessageDialog(MineWalkerPanel.this, "You Won");
                    MineWalkerPanel.this.disableTile();
                    MineWalkerPanel.this.displayMine();
                    return;
                }
            } 
            

            if(!tiles[playersRow][playersCol].isMine()&&!tiles[playersRow][playersCol].isHidden()) {
                TileButton button = tiles[playersRow][playersCol];
                tiles[playersRow][playersCol].setText(null);
                player = button;
                button.setText("X");
            }
            if(!tiles[playersRow][playersCol].isMine()){
                 tiles[currentRow][currentCol].setText("");
            }

             // checks if the tile is mine and decrements the value of lives 
             if (tiles[playersRow][playersCol].isMine()) {
                tiles[playersRow][playersCol].setHidden(false);
                tiles[playersRow][playersCol].setBackground(COLORS[4]);
                tiles[playersRow][playersCol].setEnabled(false);
                livesLeft--;
                livesRemaining.setText("Lives: " + livesLeft);
                
                // shows a message that you lost the game if lives = 0
                if (livesLeft == 0) {
                    MineWalkerPanel.this.disableTile();
                    MineWalkerPanel.this.displayMine();
                    JOptionPane.showMessageDialog(MineWalkerPanel.this, "You Lost");
                    return;
                }   
            } 

            return;
        }
    }
    
    //method that disables all tiles in the game grid after the compilation of the game
    private void disableTile(){
        for(int row = 0; row<tiles.length;row++){
            for (int col = 0; col<tiles[row].length;col++){
                tiles[row][col].setEnabled(false);
            }
        }
    }

    // method that displays all mines in the game grid after the compilation of game
    private void displayMine(){
        for (int row = 0 ; row<GAMEGRID ; row++){
            for ( int col = 0 ; col< GAMEGRID ; col++){
                if (tiles[row][col].isMine()){
                    tiles[row][col].setBackground(COLORS[4]);
                }
            }
        }
    }

    private class NewGameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            livesLeft = 5;
            livesRemaining.setText("Lives: "+livesLeft);

            for (int row = 0 ; row<GAMEGRID; row++){
                for(int col = 0; col<GAMEGRID;col++){
                    tiles[row][col].setBackground(COLORS[5]);
                    tiles[row][col].setEnabled(true);
                    tiles[row][col].setHidden(true);
                    tiles[row][col].setMine(false);
                    tiles[row][col].setPath(false);
                    tiles[row][col].setNumMineNeighbors(0);

                }
            }

            for (int row = 0; row < GAMEGRID; row++) {
                for (int col = 0; col < GAMEGRID; col++) {
                    tiles[row][col].setText(""); 
                }
            }
            MineWalkerPanel.this.NewGame();

            
       }
    }

   
    private void NewGame() {
        // Get a random path from the game grid
        ArrayList<Point> randomPath = RandomPath.getPath(GAMEGRID);
         
    for (Point point : randomPath) {
        int row = point.x;
        int col = point.y;
        tiles[row][col].setPath(true);
    }

    // gets mine percent from the user and ensure its between 10- 50.
    int minePercent = Integer.parseInt(minePercentField.getText());
    minePercent = Math.max(10, Math.min(50, minePercent));
    minePercentField.setText(Integer.toString(minePercent));

    // calculates num of mines to be placed based on the game grid and mine percent
    int numMinesToPlace = ((GAMEGRID * GAMEGRID) - randomPath.size()) * minePercent / 100;

    // randomly places mines in the game grid
    Random random = new Random();
    int placedMines = 0;
    while (placedMines < numMinesToPlace) {
        int row = random.nextInt(GAMEGRID);
        int col = random.nextInt(GAMEGRID);

        if (!tiles[row][col].isPath() && !tiles[row][col].isMine()) {
            tiles[row][col].setMine(true);
            placedMines++;
        }
    }

    // Set number of neighboring mines for each non-mine tile
    for (int row = 0; row < GAMEGRID; row++) {
        for (int col = 0; col < GAMEGRID; col++) {
            TileButton button = tiles[row][col];

            if (!button.isMine()) {
                int numMinesAround = 0;

                if (row > 0 && tiles[row - 1][col].isMine()) {
                    numMinesAround++;
                }
                if (row < GAMEGRID - 1 && tiles[row + 1][col].isMine()) {
                    numMinesAround++;
                }
                if (col > 0 && tiles[row][col - 1].isMine()) {
                    numMinesAround++;
                }
                if (col < GAMEGRID - 1 && tiles[row][col + 1].isMine()) {
                    numMinesAround++;
                }

                button.setNumMineNeighbors(numMinesAround);
            }
        }
    }

    // sets new game position to top left 
    player = tiles[0][0];
    player.setBackground(COLORS[player.getNumMineNeighbors()]);
    player.setText("X");
}
}


