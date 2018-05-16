/*
 * Project 3-5 Reloaded
 * 11/14/2017
 * Project 3-5 using StringTokenizer
 * @author Aviel Resnick
 */

import java.util.StringTokenizer;
import java.io.*;

public class TotalWeeklyPayReloaded {
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
}
