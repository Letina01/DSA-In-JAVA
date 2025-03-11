package HashMap;

import java.util.HashMap;

public class anagram {
    
    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // If the lengths of the two strings are not equal, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a map to store the frequency of characters in str1
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in the first string
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Check if the second string has the same frequency of characters
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (!map.containsKey(c)) {
                return false;  // If the character is not in the map, the strings are not anagrams
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // If the map is empty, the strings are anagrams
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
