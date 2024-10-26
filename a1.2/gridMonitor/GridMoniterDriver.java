/**
 * This is a driver class for GridMonitor, which asks user to open a file and performes calculation and displays the
 * output if the cell is danger to exploding or not(true-is in danger or false- is safe).
 * 
 * @author Anup Bhattarai
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GridMoniterDriver {
    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        
        System.out.print("Enter the name of the file: ");
        String fileName = fileScanner.nextLine();

        try {
            GridMonitor gridMonitor = new GridMonitor(fileName);
            System.out.println(gridMonitor.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("No such file found.");
        }

        fileScanner.close();
        
    }
    
}

