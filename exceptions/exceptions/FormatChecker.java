/**
 * The FormatChecker class checks the format of data files. It checks if the datat files follow a specific
 * format specified in their beginning lines and verifies the data inside it.
 * 
 * @author Anup Bhattarai
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker {
    /**
     * Verifies the format of data files.
     * 
     * @param args an array of file names whose format has to be checked.
     */
    public static void main(String[] args) {
        for (String fileName : args) {
            File file = new File(fileName);

            try {

                Scanner fileScanner = new Scanner(file);

                    if(fileScanner.hasNextLine()){
                        String line = fileScanner.nextLine();
                        String[] firstLine = line.split(" ");

                        if(firstLine.length == 2){
                            try {
                                int numRow = Integer.parseInt(firstLine[0]);
                                int numCol = Integer.parseInt(firstLine[1]);

                                int rowCount = 0 ;
                                
                                while(fileScanner.hasNextLine()){
                                    rowCount++;
                                    String rowData = fileScanner.nextLine();
                                    String[] rowDatas = rowData.split(" ");

                                    if(rowDatas.length != numCol){ 
                                        System.out.println(fileName);
                                        System.out.println("INVALID");
                                        System.out.println("Invalid number of columns in row: "+rowCount);
                                        return;
                                    }
                                

                                    for (String data : rowDatas) {
                                        try {
                                            Double.parseDouble(data);
                                        } catch (NumberFormatException e) {
                                            System.out.println(fileName);
                                            System.out.println("INVALID");
                                            System.out.println("Invalid data in row: " + rowCount);
                                            return;
                                        }
                                    }
                                }

                                if(rowCount != numRow){
                                    System.out.println(fileName);
                                    System.out.println("INVALID");
                                    System.out.println("Invalid number of rows");
                                }
                                else{
                                    System.out.println(fileName);
                                    System.out.println("VALID");
                                }
            
                
                            } catch (NumberFormatException e) {
                            System.out.println(fileName);
                            System.out.println("INVALID");
                            System.out.println("Invalid data in the firstline."); 
                            }
                        }else{
                            System.out.println(fileName);
                            System.out.println("INVALID");
                            System.out.println("Invalid number of paramater in first line");
                        }
                    }else{
                        System.out.println(fileName);
                        System.out.println("INVALID");
                        System.out.println("File is empty.");
                    }

                fileScanner.close();

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                System.out.println("INVALID");
                System.out.println("No such file exist");

            } 

            System.out.println();  

        }
    }
}
