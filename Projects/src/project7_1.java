/*
 * Aviel Resnick
 * AP Comp Sci
 *
 * Guessing Game 7.1
 * The user guess a number, while the program states higher or lower.
 * Week 11
 */

import java.util.*;

public class project7_1 {
	// variables
	public static Random random = new Random();
	public static int answer = random.nextInt(101);
	public static int guess;
	public static Boolean winner = false;
	public static int numberOfGuesses = 0;

	public static void main(String[] args) {
		// While the user is not correct
		while (winner != true) {
			// Increases guess count
			numberOfGuesses += 1;
			// Check if the user is correct
			winner = round();
			// Output appropriate response
			if (guess < answer) {
				System.out.println("Higher");
			}
		 	if (guess > answer){
				System.out.println("Lower");
			}
		}
		// State how many tries it took
		System.out.println("Correct, it took you " + numberOfGuesses + " tries.");
	}

	// Checks and returns whether the user is correct
	public static Boolean round() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Guess: ");
		guess = reader.nextInt();

		if (guess == answer) {
			return true;
		}
		else {
			return false;
		}
	}
}
