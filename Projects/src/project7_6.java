/*LuckySevens.java
 * Aviel Resnick
 * 11/28
 * Lucky Sevens Statistical Analysis

Simulate the game of lucky sevens until all funds are depleted.
1) Rules:
        roll two dice
        if the sum equals 7, win $4, else lose $1
2) The inputs are:
        the amount of money the user is prepared to lose
3) Computations:
        use the random number generator to simulate rolling the dice
        loop until the funds are depleted
        count the number of rolls
4) The outputs are:
        the number of rolls it takes to deplete the funds on average
*/

import java.util.Scanner;
import java.util.Random;

public class project7_6 {
   public static void main (String [] args) {

      Scanner reader = new Scanner(System.in);
      Random generator = new Random();

      int die1, die2,       // two dice
          dollars,          // initial number of dollars (input)
          count,            // number of rolls to reach depletion
          localDollars,     // User input in Dollars
          totalRolls,        // Total Rolls
          average;           // average number of rolls

      // Request the input
      System.out.print("How many dollars do you have? ");
      localDollars = reader.nextInt();
      average = 0;
      count = 0;
      totalRolls = 0;

      for (int i = 1; i <= 100; i++) {
    	  dollars = localDollars;
          count = 0;
          // Loop until the money is gone
          while (dollars > 0){
             count++;

             // Roll the dice.
             die1 = generator.nextInt (6) + 1; // 1-6
             die2 = generator.nextInt (6) + 1; // 1-6

             // Calculate the winnings or losses
             if (die1 + die2 == 7)
                dollars += 4;
             else
                dollars -= 1;

          }
          totalRolls = totalRolls + count;
      }
      // Display the results
      System.out.println("On average, you will be broke after " + totalRolls / 100 + " rolls.");
   }
}
