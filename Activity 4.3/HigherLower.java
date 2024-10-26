import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{

	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		answer = random.nextInt(MAX) + 1;
		
		System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
		System.out.print("Guess what it is: ");
		

		guess = Integer.parseInt(scan.nextLine());	
		boolean playAgain=true;
		
		while (guess!=answer)
		{
			if (guess<1||guess>MAX)
			{
				System.out.println("Out of bounds.");
				System.out.println("Guess a number between 1 and " + MAX + ". ");
			}		
			else
			{
				if(guess>answer)
				{
					System.out.println("Guess Lower.");
				}
				else 
				{
					System.out.println("Guess Higher.");
				}
			guess = Integer.parseInt(scan.nextLine());
			}
		}

		System.out.println("You got it! Good guessing.");
		if (guess==answer)
		{
				System.out.println("Do you want to play again?");
				System.out.println("Press Y if you want to play again.");
				System.out.println("Press N if you dont want to play.");
				String playOnceAgain= scan.nextLine();
				
				if (playOnceAgain.equalsIgnoreCase("y"))
				{
						System.out.println("Let's play.");
						playAgain=true;
				}
				else if (playOnceAgain.equalsIgnoreCase("n"))
				{
					playAgain=false;
				}
				else
				{
					System.out.println("You can only press y or n");
				}		
		}	
		else 
		{
			System.out.println("Thanks for playing.");
		}
		scan.close();
}
}
