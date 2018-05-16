/*
 * Project 2-3
 * 10/1/2017
 * Converts Kilometers to Nautical Miles 
 * @author Aviel Resnick
 */
import java.util.Scanner;

public class project2_3 {
	public static void main (String[] args) {
		// Used for user input
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Kilometers: ");
		
		// Get input in kilometers
	    double kilo = userInput.nextDouble();
	    double nauticalMiles = 0;
	    
	    // Convert to nautical miles, as outlined by the textbook
	    nauticalMiles = kilo / 10000 * 90 * 60;
	    
	    // Output nautical miles
	    System.out.println("Nautical Miles = " + nauticalMiles);
	}
}