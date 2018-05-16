/*
 * Aviel Resnick
 * Project 7-8
 * Dec. 5, 2017
 *
 * Returns the following statistics about a given sentence:
 *  1. Number of words
 *  2. Average length of words
 *  3. Sentence length
 */

import java.util.*;

public class project7_8 {

    public static void main(String [] args) {
    	// Scanner for sentence inputs
        Scanner reader = new Scanner(System.in);
        
        // Variables
        int numberOfWords = 0; // Number of words in the given sentence
        int sentenceLength = 0; // The number characters in the sentence
        int beginPosition = 0; // The index of the start of the current word
        int endPosition; // The index of the end of the current word
        String sentence; // Stores original sentence

        System.out.println("Enter a sentence: ");
        sentence = reader.nextLine();

        endPosition = sentence.indexOf(" ");

        while (endPosition != -1) {
            if (endPosition > beginPosition) {
                numberOfWords++;
                String word = sentence.substring(beginPosition, endPosition);
                sentenceLength += word.length();
            }

            // Update the indexes to match the next wordin
            beginPosition = endPosition + 1;
            endPosition = sentence.indexOf(" ", beginPosition);
        }

        if (beginPosition < sentence.length()) {
            numberOfWords++;
            String word = sentence.substring(beginPosition, sentence.length());
            sentenceLength += word.length();
        }

        if (numberOfWords > 0) {
            System.out.println("Word Count: " + numberOfWords);
            System.out.println("Sentence Length: " + sentenceLength);
            System.out.println("Average Word Length: " + sentenceLength / numberOfWords);
        }
    }
}
