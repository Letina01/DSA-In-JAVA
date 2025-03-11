package recursion;

public class subStringCount {
    
    // Helper function to count substrings starting from index 'start' that start and end with the same character
    public static int countFromIndex(String s, int start) {
        char startingChar = s.charAt(start);
        int count = 0;
        
        // Check substrings starting from 'start' and ending at each subsequent character
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == startingChar) {
                count++; // Valid substring found
            }
        }
        
        return count;
    }
    
    // Recursive function to count all valid substrings
    public static int countSubstrings(String s, int index) {
        // Base case: If the index reaches the end of the string, return 0
        if (index == s.length()) {
            return 0;
        }
        
        // Recursive case:
        // Count substrings starting from the current index and end with the same character
        int currentCount = countFromIndex(s, index);
        
        // Recursively count for the remaining string (starting from the next index)
        return currentCount + countSubstrings(s, index + 1);
    }
    
    public static void main(String[] args) {
        // Example usage
        String s = "abcab";
        
        // Start recursion from index 0
        int totalCount = countSubstrings(s, 0);
        
        // Output the total count
        System.out.println("Total substrings that start and end with the same character: " + totalCount);
    }
}
