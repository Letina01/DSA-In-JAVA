package LEVEL1;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        // Input arrays and sizes
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // nums1 has extra space to hold nums2
        int[] nums2 = {2, 5, 6};
        int m = 3; // Number of initialized elements in nums1
        int n = 3; // Number of elements in nums2
        
        // Merge nums2 into nums1
        merge(nums1, m, nums2, n);
        
        // Print the merged array
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    /**
     * Merges two sorted arrays into one sorted array in-place.
     * @param nums1 - First sorted array with extra space for nums2
     * @param m - Number of initialized elements in nums1
     * @param nums2 - Second sorted array
     * @param n - Number of elements in nums2
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer to the last initialized element in nums1
        int p2 = n - 1; // Pointer to the last element in nums2
        int p = m + n - 1; // Pointer to the last position in nums1

        // Traverse arrays from the end and merge
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements from nums2, if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
 