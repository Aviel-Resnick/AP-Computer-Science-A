/*
 * Project 2-4
 * 10/1/2017
 * Outputs the number of seconds in n years.
 * @author Aviel Resnick
 */
import java.util.Scanner;

public class project2_4 {
	public static void main (String[] args) {
		// Used for user input
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Years: ");
		
		// Get input in years
	    int years = userInput.nextInt();
	    int min = 0;
	    
	    // Convert years to minutes
	    min = years * 365 * 24 * 60;
	    
	    // Output minutes in n years
	    System.out.println("Minutes = " + min);
	}
}