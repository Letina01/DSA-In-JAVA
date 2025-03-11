package LEVEL1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMajority(int[] nums) {
        // Step 1: Identify potential candidates
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        
        // Traditional loop instead of enhanced for-loop
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Return result sorted in increasing order
        result.sort(Integer::compareTo);
        return result;
    }
}
