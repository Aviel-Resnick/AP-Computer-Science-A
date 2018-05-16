/*
 * Vowels-R-Us
 * 12/19/2017
 * Problem  Definition :  The vowels on planet ACSL are naturally enough, the letters  A, C, S, and L.
                          All other letters are considered to be consonants.  There are two tasks associated with each word :
                          forming the plural and adding a suffix. Rules stated on req sheet

 * @author Aviel Resnick
 */

import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class VowelsRUs {

	public static void main (String[] args) throws IOException {
		// Gets Data, also calls pluralize and suffixize
		// Receives the textFile (reader) as input
		processData(initFile());
	}

	// Open and read file
  	public static BufferedReader initFile() throws IOException {
			// Variables for file input
			FileInputStream inFile;
			InputStreamReader inReader;
			BufferedReader reader;

			Scanner dirReader = new Scanner(System.in);

			// Read the text file
			System.out.println("Enter the path to the data file: ");
    	inFile = new FileInputStream (dirReader.nextLine());
    	inReader = new InputStreamReader(inFile);
    	reader = new BufferedReader(inReader);

			// Return the text file
    	return(reader);
  	}

  	//read data from file
  	public static void processData(BufferedReader reader) throws IOException {
  		// Variables for StringTokenizer
  		StringTokenizer strTkn;

        for (int i = 0; i < 13; i++) {
          //acquiring the data line as a string
          String line = reader.readLine();

            // attaching the string tokenizer to the line
        	strTkn = new StringTokenizer(line);

    		// Identify the word and the suffix
    			String word = strTkn.nextToken();
    	    String suffix = strTkn.nextToken();

    	    // Output the original word, the plural form, and the suffix form
					System.out.println("Original Word: " + word + " Suffix: " + suffix);
          System.out.println(pluralize(word));
          System.out.println(suffixize(word, suffix));
					System.out.println();
        }
  	}

    // Pluralize the given word based on provided rules
    public static String pluralize(String word) {
        // Identify the last letter
        String lastLetter = word.substring(word.length() - 1);

        if (isVowel(lastLetter) == true) {
					// Double Vowel
					if (isVowel(word.substring(word.length() - 2, word.length() - 1)) == true) {
							return("Plural Form: " + word + lastLetter + "H");
					}

					// Single Vowel
        	else {
							return("Plural Form: " + word.substring(0, word.length() - 1) + "G");
        	}
      }

      else{
				// Single Consonant
        if (isVowel(word.substring(word.length() - 2, word.length() - 1)) == true) {
                return("Plural Form: " + word + "GH");
        }

				// Double Consonant
        else {
          return("Plural Form: " + word + lastLetter + "H");
        }
      }
    }

	public static String suffixize(String word, String suffix) {
		// Identify the last letter
        String lastLetter = word.substring(word.length() - 1);

        if (isVowel(lastLetter) == true) {
			// Double Vowel
			if (isVowel(word.substring(word.length() - 2, word.length() - 1)) == true) {
				// Suffix starts with a vowel
				if (isVowel(suffix.substring(0,1)) == true) {
					return("Suffix Form: " + word + suffix.substring(0,1) + suffix);
				}

				// Suffix starts with a consonant
				else {
					return("Suffix Form: " + word.substring(0, word.length() - 2) + word.substring(word.length() - 1) + suffix);
				}
			}

			// Single Vowel
            else {
				// Suffix starts with a vowel
				if (isVowel(suffix.substring(0,1)) == true) {
					return("Suffix Form: " + word + suffix.substring(1, suffix.length()));
				}

				// Suffix starts with a consonant
				else {
					return("Suffix Form: " + word + suffix.substring(0,1) + suffix);
				}
        	}
        }

        else {
			// Single Consonant
            if (isVowel(word.substring(word.length() - 2, word.length() - 1)) == true) {
				// Suffix starts with a vowel
				if (isVowel(suffix.substring(0,1)) == true) {
					return("Suffix Form: " + word + suffix);
				}

				// Suffix starts with a consonant
				else {
					return("Suffix Form: " + word + suffix);
				}
            }

			// Double Consonant
            else {
				// Suffix starts with vowel
				if (isVowel(suffix.substring(0,1)) == true) {
					return("Suffix Form: " + word + suffix.substring(0,1) + suffix);
				}

				// Suffix starts with a consonant
				else {
					return("Suffix Form: " + word.substring(0, word.length() - 2) + word.substring(word.length() - 1) + suffix);
				}
            }
        }
	}

	// I wrote this method to simplify the process of checking whether a letter is a vowel,
	// Given a string (single character) it checks if it matches one of the letters, and returns a boolean value
    public static Boolean isVowel(String letter) {
        if (letter.toUpperCase().equals("A") || letter.toUpperCase().equals("C") || letter.toUpperCase().equals("S") || letter.toUpperCase().equals("L")) {
            return(true);
        }
        else{
            return(false);
        }
    }
}
