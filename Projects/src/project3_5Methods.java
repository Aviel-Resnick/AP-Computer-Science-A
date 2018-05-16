/*
 * Project 3-5 using Methods
 * 10/24/2017
 * @author Aviel Resnick
 */

import java.util.Scanner;

public class project3_5Methods {
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);
		//Ask for name
		System.out.print("Name: ");
		String name = reader.nextLine();
		// Runs each method, and calculates the total weekly wage
		double wage = getHourlyWage();
		System.out.println(name + "'s Total Pay: " + (wage * getRegHours() + getOverHours() * wage * 1.5));
	}
	
	public static double getHourlyWage() {
		double hourlyWage;
		// Scanner + Prompt for hourly wage
		Scanner reader = new Scanner(System.in);
		
		// Ask for hourly wage
		System.out.print("Hourly Wage: ");
		hourlyWage = reader.nextDouble();
		
		return hourlyWage;
	}
	
	public static double getRegHours() {
		double regularSum;
		Scanner reader = new Scanner(System.in);
		// Ask for regular hours for each day
		System.out.print("Regular hours worked on Monday: ");
		double regMon = reader.nextDouble();
		
		System.out.print("Regular hours worked on Tuesday: ");
		double regTue = reader.nextDouble();
		
		System.out.print("Regular hours worked on Wednesday: ");
		double regWed = reader.nextDouble();
		
		System.out.print("Regular hours worked on Thursday: ");
		double regThur = reader.nextDouble();
		
		System.out.print("Regular hours worked on Friday: ");
		double regFri = reader.nextDouble();
		
		regularSum = regMon + regTue + regWed + regThur + regFri;
		
		// Return the sum of the regular working hours
		return (regularSum);
	}
	
	public static double getOverHours() {
		double overSum;
		Scanner reader = new Scanner(System.in);
		// Ask for over time hours for each day
		
		System.out.print("Overtime hours worked on Monday: ");
		double overMon = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Tuesday: ");
		double overTue = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Wednesday: ");
		double overWed = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Thursday: ");
		double overThur = reader.nextDouble();
		
		System.out.print("Overtime hours worked on Friday: ");
		double overFri = reader.nextDouble();
		
		// Sum of all overtime hours
		overSum = overMon + overTue + overWed + overThur + overFri;
		
		return(overSum);
	}

}
