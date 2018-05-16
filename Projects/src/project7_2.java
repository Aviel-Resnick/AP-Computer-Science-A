/*
 * Aviel Resnick
 * AP Comp Sci
 *
 * Guessing Game 7.2
 * The program guesses a number, defined by the user.
 * Week 11
 */

import java.util.*;

public class project7_2 {
	// variables
	public static Random random = new Random();
	public static int answer = random.nextInt(101);
	public static int guess;
	public static Boolean winner = false;
	public static int numberOfGuesses = 0;
	static // Scanner
	Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		// Sets up the answer, and an initial guess
		System.out.println("Pick a number between 1 and 100: ");
		answer = reader.nextInt();
		guess = random.nextInt(101);
		
		// while the program is not correct
		while (winner != true) {
			numberOfGuesses += 1;
			winner = round();
			
			// Restrict to a higher bound
			if (guess < answer) {
				guess = guess + random.nextInt(101 - guess);
			}
			
			// Restrict to a lower bound
		 	if (guess > answer){
				guess = random.nextInt(guess);
			}
		}
		// Output how many tries it took
		System.out.println("Correct, it took me " + numberOfGuesses + " tries.");
	}
	
	// Checks if correct
	public static Boolean round() {
		if (guess == answer) {
			return true;
		}
		else {
			return false;
		}
	}
}
