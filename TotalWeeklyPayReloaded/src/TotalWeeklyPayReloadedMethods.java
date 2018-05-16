/*
 * TotalWeeklyPayReloadedMethods
 * 12/5/2017
 * A collection of loosely related methods integrated into the Total Weekly Pay project
 * Returns info about text
 *
 * @author Aviel Resnick
 */

import java.util.StringTokenizer;
import java.io.*;

public class TotalWeeklyPayReloadedMethods {
	// Variables for file input
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;

	// Variables for StringTokenizer
	static StringTokenizer strTkn;

	// Variables for computing
	static double regularHours, overtimeHours, wage, totalPay;
	static String firstname, lastname;
	static String line;
	static double totalRegHours = 0;
	static double totalOverHours = 0;

	public static void main (String[] args) throws IOException {
		initFile();
	    getData();
	    printResults();
        textStats();
	}

	// open and read file
  	public static void initFile() throws IOException {
    	inFile = new FileInputStream ("/home/avilor/Dropbox/Code/VHS/AP Comp Sci A/Data/project3_5data.txt");
    	inReader = new InputStreamReader(inFile);
    	reader = new BufferedReader(inReader);
  	}

  	//read data from file
  	public static void getData() throws IOException {
     	line = reader.readLine();   //acquiring the data line as a string

    	strTkn = new StringTokenizer(line);  // attaching the string tokenizer to the line

    	// First and Last Name
    	firstname = strTkn.nextToken();
		lastname = strTkn.nextToken();

		// Fill in all the data, and calculate totals
		wage = Double.parseDouble(strTkn.nextToken());
	    totalRegHours = Double.parseDouble(strTkn.nextToken());
	    totalOverHours = Double.parseDouble(strTkn.nextToken());
	    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
	    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
	    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
	    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
	    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
	    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
	    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
	    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
  	}

  	//print results
  	public static void printResults() {
  		totalPay = totalRegHours * wage + totalOverHours * wage * 1.5;
	    System.out.println("The total weekly pay is $" + totalPay);
  	}

    //returns info about the text, using 10 methods.
    public static void textStats () {
    	
        // length
        System.out.println("The length of the firstname is: " + firstname.length());

        // charAt
        System.out.println("The firstname starts with the letter: " + firstname.charAt(0));

        // Equals
        if (firstname.equals(lastname))
            System.out.println("The first and last name is the same");
        else {
            System.out.println("The first and last names are different");
        }

        // Replace
        System.out.println("The letter k is replaced with b, in the firstname " + firstname.replace("K", "B"));

        // toLower
        System.out.println("The firstname in all lowercase is " + firstname.toLowerCase());

        // toUpper
        System.out.println("The firstname in all uppercase is " + firstname.toUpperCase());

        // indexOf
        System.out.println("The letter R is at the " + firstname.indexOf("r") + " index");

        // trim
        System.out.println("The firstname trimmed is " + firstname.trim());

        // equalsIgnoreSign
        if (firstname.equalsIgnoreCase("kermit")) {
            System.out.println("The firstname is not case sensitive");
        }
        else {
            System.out.println("The firstname is case sensitive");
        }
        
        // contains
        if (firstname.contains("Kerm")) {
            System.out.println("The firstname contains Kerm");
        }
        else {
            System.out.println("The firstname does not contain Kerm");
        }

    }
}
