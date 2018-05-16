/*Case study 1: an income tax calculator
Compute a person's income tax.
1) Significant constants
       tax rate
       standard deduction
       deduction per dependent
2) The inputs are:
       gross income 
       number of dependents 
3) Computations:
       net income = gross income - the standard deduction - 
                    a deduction for each dependent 
       income tax = is a fixed percentage of the net income 
4) The outputs are:
       the income tax.
*/


// Import scanner class (for user input)
import java.util.Scanner;

// Create a class called IncomeTax Calculator
public class IncomeTaxCalculatorCommented{
   
   // Main Method
   public static void main(String [] args){
   
      // Constants
      final double TAX_RATE = 0.20; // Sets the tax rate to 20%
      final double STANDARD_DEDUCTION = 10000.0; // Base taken off
      final double DEPENDENT_DEDUCTION = 2000.0; // More money taken away
      
      // Scanner object for user input   
      Scanner reader = new Scanner(System.in);
      
      // Variables used in calculation
      double grossIncome;          // the gross income (input)
      int    numDependents;        // the number of dependents (input)
      double taxableIncome;        // the taxable income (calculated)
      double incomeTax;            // the income tax (calculated and output)
      

      // Request the inputs
      System.out.print("Enter the gross income: ");
      // Income is defined by the next double input
      grossIncome = reader.nextDouble();
      System.out.print("Enter the number of dependents: ");
      // Define dependents by user input
      numDependents = reader.nextInt();
      

      // Compute the income tax
      taxableIncome = grossIncome - STANDARD_DEDUCTION - 
                      DEPENDENT_DEDUCTION * numDependents;
      // More Computation
      incomeTax = taxableIncome * TAX_RATE;
      
      // Display the income tax 
      System.out.println("The income tax is $" + incomeTax);
   }
}
