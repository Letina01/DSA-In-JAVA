package LEVEL1;

public class removeElement {
    public static int RemoveElement(int[] arr, int val) {
        int count = 0; // Tracks the new length of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count; // Return the new logical size of the array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3};
        int val = 3;
        int newLength = RemoveElement(arr, val);

        // Print the array up to the new length
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
