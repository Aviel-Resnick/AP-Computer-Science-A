import java.util.Scanner;

public class project3_5 {
	public static void main (String[] args){
		// Variables
		double hourlyWage;
		double regularSum;
		double overSum;
		
		Scanner reader = new Scanner(System.in);
		
		// Ask for hourly wage
		System.out.print("Hourly Wage: ");
		hourlyWage = reader.nextDouble();
		
		// Ask for regular and over time hours for each day
		System.out.print("Regular hours worked on Monday: ");
		double regMon = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Monday: ");
		double overMon = reader.nextDouble();
		
		System.out.print("Regular hours worked on Tuesday: ");
		double regTue = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Tuesday: ");
		double overTue = reader.nextDouble();
		
		System.out.print("Regular hours worked on Wednesday: ");
		double regWed = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Wednesday: ");
		double overWed = reader.nextDouble();
		
		System.out.print("Regular hours worked on Thursday: ");
		double regThur = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Thursday: ");
		double overThur = reader.nextDouble();
		
		System.out.print("Regular hours worked on Friday: ");
		double regFri = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Friday: ");
		double overFri = reader.nextDouble();
		
		// Sum all of the regular hours, and overtime hours, for easy computation
		regularSum = regMon + regTue + regWed + regThur + regFri;
		overSum = overMon + overTue + overWed + overThur + overFri;
		
		// Return Weekly Pay
		System.out.println("Total Pay: " + (regularSum * hourlyWage + overSum * hourlyWage * 1.5));
	}

}
