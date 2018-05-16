/*
 * Problem Set 7.5
 * 10/24/2017
 * @author Aviel Resnick
 */
import java.util.Scanner;
import java.io.*;

public class ProblemSet {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		
		double sampleDoubleA = -5.0;
		double sampleDoubleB = 10.3;
		String sample = "this is a test";
		
		
		//abs
		System.out.println("The absolute value of -5 is: " + Math.abs(sampleDoubleA));
		
		//ceil
		System.out.println("The ceiling function of 10.3 is: " + Math.ceil(sampleDoubleB));
		
		//floor
		System.out.println("The floor function of 10.3 is: " + Math.floor(sampleDoubleB));
		
		//min
		System.out.println("The min of 10.3 and -5.0 is: " + Math.min(sampleDoubleA, sampleDoubleB));
		
		//max
		System.out.println("The max of 10.3 and -5.0 is: " + Math.max(sampleDoubleA, sampleDoubleB));
		
		//indexOf
		System.out.println("Index of test is " + sample.indexOf("test"));
		
		//length
		System.out.println("The Length of the sample string is: " + sample.length());
		
		//isEmpty
		System.out.println("Is the sample string empty?: " + sample.isEmpty());
		
		//substring
		System.out.println("The first four characters of the sample string are: " + sample.substring(0, 4));
		
		//replace
		System.out.println("The sample string with z's  for t's is: " + sample.replace("t", "z"));
	}
}
