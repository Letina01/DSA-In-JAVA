package LEVEL1;

public class rotateAnArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3; // Number of positions to rotate
        int n = arr.length;

        // Normalize k to ensure it's within the array bounds
        k = k % n;

        // Rotate the array to the right by k positions
        reverse(arr, 0, n - 1);     // Reverse the entire array
        reverse(arr, 0, k - 1);     // Reverse the first k elements
        reverse(arr, k, n - 1);     // Reverse the remaining n - k elements

        // Print the rotated array
        System.out.println(java.util.Arrays.toString(arr));
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
