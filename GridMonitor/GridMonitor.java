/**
 * The GridMOnitor class reads and calculates grid data from a file,
 * calculates different values and determine if the cell is at the risk 
 * of explosion or not.
 * 
 * @author Anup Bhattarai
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GridMonitor implements GridMonitorInterface{

    private double[][] baseGrid;

    /**
     * @param filename. Name of file that has grid data.
     * 
     * @throws FileNotFoundException If the file is not found in the folder.
     */
    public GridMonitor(String filename) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(filename));
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        baseGrid = new double[rows][cols];

            for(int i = 0 ; i< rows ; i++ ){
                for( int j = 0  ; j < cols; j++){
                    baseGrid[i][j] = scan.nextDouble();
                }
            }
    }

    /**
     * Gets the base grid.
     * 
     * 
     * @return A copy of baseGrid.
     */
    public double[][] getBaseGrid(){
        int numCol = baseGrid[0].length;
        int numRow = baseGrid.length;
        double[][] getGrid = new double[numRow][numCol];
        for (int i = 0 ; i<numRow; i++){
            for (int j = 0 ; j<numCol ; j++){
                getGrid[i][j] = baseGrid[i][j];
            }
        }
        return getGrid;
    }

    /**
     * Calculates and returns the sum of the surrounding cells.
     * 
     * @return the sum of surrounding cells.
     */
    @Override
    public double[][] getSurroundingSumGrid() {
        int numRows = baseGrid.length;
        int numCols = baseGrid[0].length;
        double[][] sumGrid = new double[numRows][numCols];
    
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double sum = 0;
                
                if (i > 0) {
                    sum += baseGrid[i - 1][j]; 
                }
                if (i < numRows - 1) {
                    sum += baseGrid[i + 1][j]; 
                }
                if (j > 0) {
                    sum += baseGrid[i][j - 1]; 
                }
                if (j < numCols - 1) {
                    sum += baseGrid[i][j + 1]; 
                }
    
                if (i == 0) {
                    sum += baseGrid[i][j]; 
                }
                if (i == numRows - 1) {
                    sum += baseGrid[i][j]; 
                }
                if (j == 0) {
                    sum += baseGrid[i][j]; 
                }
                if (j == numCols - 1) {
                    sum += baseGrid[i][j]; 
                }
    
                sumGrid[i][j] = sum;
            }
        }
        return sumGrid;
    }
    
    /**
     * Calculates and returns the the average from the sum of the surrounding cells.
     * 
     * @return grid of surrounding average values.
     */
    @Override
    public double[][] getSurroundingAvgGrid() {
        int numRows = baseGrid.length;
        int numCols = baseGrid[0].length;
        double[][] avgGrid = new double[numRows][numCols];
        double[][] sumGrid = getSurroundingSumGrid();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    int count = 4; 
                    double sum = sumGrid[i][j];

                    avgGrid[i][j] = sum / count;
                }
            }
         return avgGrid;
    }

    /**
     * 
     * @return grid containing boolean values indicating whether the cell at this
	 * location is in danger of exploding
     */
    public double[][] getDeltaGrid() {
        int numRows = baseGrid.length;
        int numCols = baseGrid[0].length;
        double[][] deltaGrid = new double[numRows][numCols];
        double[][] avgGrid = getSurroundingAvgGrid();
    
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double avg = avgGrid[i][j];
                double delta = Math.abs(avg) / 2;
                
                deltaGrid[i][j] = delta;
            }
        }
    
        return deltaGrid;
    }

    /**
     * Calculates and returns a grid of each cells and represents if the cells is at risk of exploding.
     * 
     * @return  grid containing boolean values indicating whether the cell at this
	 * location is in danger of exploding
     */
    @Override
    public boolean[][] getDangerGrid() {
    int numRows = baseGrid.length;
    int numCols = baseGrid[0].length;
    boolean[][] dangerGrid = new boolean[numRows][numCols];
    double[][] avgGrid = getSurroundingAvgGrid();
    double[][] deltaGrid = getDeltaGrid();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double cellValue = baseGrid[i][j];
                double lowerLimit = avgGrid[i][j] - deltaGrid[i][j];
                double upperLimit = avgGrid[i][j] + deltaGrid[i][j];
                
                dangerGrid[i][j] = cellValue < lowerLimit || cellValue > upperLimit;
            }
        }

        return dangerGrid;
    }

    /**
     * Returns a formatted string representation of the danger grid.
     * 
     * @return string representation of danger grid.
     */
    public String toString() {
        boolean[][] grid = getDangerGrid();
        String result = "";
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    result += "true ";
                } else {
                    result += "false ";
                }
            }
            result += "\n";
        }
    
        return result;
    }

}