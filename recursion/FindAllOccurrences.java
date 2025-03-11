package recursion;

import java.util.ArrayList;

public class FindAllOccurrences {
    
    // Recursive function to find all occurrences of the key
    public static void findOccurrences(int[] arr, int key, int currentIndex, ArrayList<Integer> result) {
        // Base case: if the current index reaches the end of the array
        if (currentIndex == arr.length) {
            return;
        }

        // Check if the current element matches the key
        if (arr[currentIndex] == key) {
            result.add(currentIndex); // Add the index to the result list
        }

        // Recursive call for the next index
        findOccurrences(arr, key, currentIndex + 1, result);
    }

    public static void main(String[] args) {
        // Example usage
        int[] array = {2, 3, 4, 3, 5, 3, 6};
        int key = 3;
        
        // List to store the indices where key is found
        ArrayList<Integer> result = new ArrayList<>();
        
        // Call the recursive function
        findOccurrences(array, key, 0, result);
        
        // Print the result
        System.out.println("The key " + key + " is found at indices: " + result);
    }
}
