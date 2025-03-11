package LEVEL1;

public class nextPermutation {
    public static void Permutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If a decreasing element is found, find the next larger element
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            // Swap nums[i] with nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse the part of the array to the right of i
        reverse(nums, i + 1);
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;

        // Reverse the subarray from 'start' to the end
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // Input array
        Permutation(nums); // Generate the next permutation

        // Print the result
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
