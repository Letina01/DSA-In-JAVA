package Queue;

import java.util.*;
import java.util.Queue;


public class nonRepeatingLetter {

    // Function to print the first non-repeating character
    public static char firstNonRepeating(String str) {

        // Create a queue to store characters
        Queue<Character> q = new LinkedList<>();

        // Create an array to store the frequency of characters (assuming only lowercase letters)
        int[] freq = new int[26];  // Since there are 26 letters in the English alphabet

        // Traverse the string
        for (int i = 0; i < str.length(); i++) {

            char currentChar = str.charAt(i);

            // Add the current character to the queue
            q.add(currentChar);

            // Increment the frequency of the current character in the array
            freq[currentChar - 'a']++;

            // Remove characters from the front of the queue until the front is non-repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll(); // Remove the character from the queue
            }
        }

        // If the queue is not empty, return the first non-repeating character
        if (!q.isEmpty()) {
            return q.peek();  // The front of the queue is the first non-repeating character
        } else {
            return '\0';  // Return null character if no non-repeating character is found
        }
    }

    public static void main(String[] args) {

        String str = "geeksforgeeks";

        char result = firstNonRepeating(str);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
