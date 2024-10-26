import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class GradeBook {

	public static void main(String[] args) {
		
		/* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
		ArrayList<Student>  gradeBook=new ArrayList<Student>();

		
		/* TODO: 2. Create a new File object for gradebook.csv and 
		 * a new Scanner object to parse it. Catch any required 
		 * exceptions and display a useful message to the user.
		 */
		
		try{
			File file= new File("gradebook.csv");
			Scanner fileScanner= new Scanner (file);
		
				
			/* TODO: 3. Use a while loop and the Scanner created above to iterate 
			 * through the lines in the gradebook.csv file.
			 */
			while (fileScanner.hasNextLine())
			{
				String line= fileScanner.nextLine();
				System.out.println(line);
			
		
		

				/* TODO: 4. For each line (student record), use a second 
				 * Scanner object to tokenize the line using a comma (',')
				 * as the delimiter, extract values for lastName, firstName,
				 * id and grade and store them to local variables.
			 	 */
				

					Scanner studentScanner=new Scanner (line);
					studentScanner.useDelimiter(",");
					String  firstName= studentScanner.next();
					String lastName= studentScanner.next();
					Integer id = studentScanner.nextInt();
					Integer grade= Integer.parseInt(studentScanner.next());
			
		
			 	/* TODO: 5. Create a new Student object using the local variables
			 	 * create above, set the student's grade, and finally add the 
			 	 * new Student object to the gradebook ArrayList. 
				 */
				Student student= new Student(firstName,lastName,id);
				student.setGrade(grade);
				gradeBook.add(student);
			}
			studentScanner.close();
			fileScanner.close();
		}
				 catch (FileNotFoundException e){
					System.out.println("File not found.");
				}
				
		/* TODO: 6. Use a foreach loop to print out contents of the gradebook */
	
		for (Student student:gradeBook)
		{
			System.out.println(student);
		}
	}

}
