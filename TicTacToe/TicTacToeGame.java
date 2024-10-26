import java.awt.Point;

/*
 * TicTacTooeGame implements TicTacToe interface. 
 * It provides all the methods to play a game of tictactoe.
 * The gaem is played in a 3x3 gameGrid with two players(X and O).
 * The player with three symbols in row, column or diagonal wins.
 * If the grid is filled without anyone winning it is a tie.
 *  
 * @author Anup Bhattarai
 */

public class TicTacToeGame implements TicTacToe{
   
    // Initiating variables
    private BoardChoice [][] gameGrid;
    private GameState game;
    private Point [] moves;
    private BoardChoice currentPlayer;
    private int numMoves;
    
    //Constructor 
    public TicTacToeGame(){
      newGame();// Calling newGame method to start the game
    }
   
    public void newGame(){
       gameGrid = new BoardChoice[3][3];// making a 3x3 gameGrid
       for (int row=0; row<gameGrid.length; row++){// iterating over 2D array
        for (int col=0; col<gameGrid[row].length;col++){
            gameGrid[row][col]= BoardChoice.OPEN;
        }
       }
       game = GameState.IN_PROGRESS;
       moves = new Point[9];
       numMoves = 0;
      
    }

    // method to choose an index on the gameGrid
    public boolean choose(BoardChoice player, int row, int col) {
        // Checking if the game is in progress, is in bound, open index, player is not the currentPlayer.
        if (game == GameState.IN_PROGRESS && row >= 0 && row <= 2 && col >= 0 && col <= 2 && gameGrid[row][col] == BoardChoice.OPEN && player != currentPlayer) {
            gameGrid[row][col] = player;
            moves[numMoves] = new Point(row, col);
            numMoves++;
            currentPlayer = player;
            if (gameOver()) {
                if (player == BoardChoice.X) {
                  game = GameState.X_WON;
                } else {
                  game = GameState.O_WON;
                }
              }
            return true;
        }
        return false;
    } 
   
        
     
    public boolean gameOver(){
        boolean full = true;
        if (game.equals(GameState.IN_PROGRESS)) {
            // boolean full = true;
            // Checking if there is still move to make or not
            for (int row = 0; row < gameGrid.length; row++) {
                for (int col = 0; col < gameGrid[row].length; col++) {
                    if (gameGrid[row][col] == BoardChoice.OPEN) {
                        game = GameState.IN_PROGRESS;
                        full = false;
                    }
                }
            }
            if (full) {
                game=GameState.TIE;
                return true;
            }
        }
        
        //Checking win by row
        for(int row=0; row<gameGrid.length; row++){
           
            if(gameGrid[row][0]!=BoardChoice.OPEN&&gameGrid[row][0]== gameGrid[row][1]&&gameGrid[row][1]==gameGrid[row][2]){
                if (gameGrid[row][0]==BoardChoice.X){
                    game = GameState.X_WON;
                    
                }else{
                    game = GameState.O_WON;
                    
                }
                return true;
            }
        }

        //Checking win by column
        for (int col=0; col<gameGrid.length ;col++){
            if(gameGrid[0][col]!=BoardChoice.OPEN&&gameGrid[0][col]==gameGrid[1][col]&&gameGrid[1][col]==gameGrid[2][col]){
                if(gameGrid[0][col]==BoardChoice.X){
                    game = GameState.X_WON;
                    
                }else{
                    game = GameState.O_WON;
                    
                }
                return true;
            }
        }
    
    // Checking win by diagonal
    if(gameGrid[0][0]!=BoardChoice.OPEN&&gameGrid[0][0]==gameGrid[1][1]&&gameGrid[1][1]==gameGrid[2][2]){
            if(gameGrid[0][0]==BoardChoice.X){
                game = GameState.X_WON;
                    
            }else{
                game = GameState.O_WON;
                   
        }
        return true;
    }

    // Checking win by diagonal
    if(gameGrid[0][2]!=BoardChoice.OPEN&&gameGrid[0][2]==gameGrid[1][1]&&gameGrid[1][1]==gameGrid[2][0]){
            if(gameGrid[0][2]==BoardChoice.X){
                game = GameState.X_WON;
                    
            }else{
                game = GameState.O_WON;
                    
            }
            return true;
        }
        return false;
    }

   
    public GameState getGameState(){
        return game;//gets current game state
       
    }

    
    public BoardChoice[][] getGameGrid(){
        BoardChoice[][] grid= new BoardChoice[3][3];
        for(int row=0; row<gameGrid.length; row++){
            for(int col=0; col<gameGrid[row].length;col++){
                grid[row][col]= gameGrid[row][col];
            }
        }
        return grid;
    }

    public Point[] getMoves(){
    Point[] needMoves = new Point[numMoves];
    for (int i=0;i<numMoves;i++){
        needMoves[i]= moves[i];
    }
    return needMoves;
    }
}
