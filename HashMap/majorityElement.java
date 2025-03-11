package HashMap;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            // Create a map to store the frequency of each element
            HashMap<Integer, Integer> map = new HashMap<>();
            
            // Iterate through the array and count the frequency of each element
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            
            // Find the element with frequency greater than n/2
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }
            
            // If no majority element is found, return -1 (or handle accordingly)
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution solution = new Solution();
        int majority = solution.majorityElement(nums);
        System.out.println("Majority element: " + majority); // Output will be 2
    }
}
