class Solution {
    public static int findMinOperation(int[][] mat) {
        int n = mat.length;
        
        // Calculate the row sums and column sums
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Find the maximum sum among rows and columns
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        int operations = 0;

        // Make row sums and column sums equal to maxSum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diff = Math.min(maxSum - rowSum[i], maxSum - colSum[j]);
                mat[i][j] += diff;
                rowSum[i] += diff;
                colSum[j] += diff;
                operations += diff;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println(findMinOperation(mat1)); // Output: 4

        int[][] mat2 = {
            {1, 2, 3},
            {4, 2, 3},
            {3, 2, 1}
        };
        System.out.println(findMinOperation(mat2)); // Output: 6

        int[][] mat3 = {
            {0, 2},
            {3, 4}
        };
        System.out.println(findMinOperation(mat3)); // Output: 5
    }
}
