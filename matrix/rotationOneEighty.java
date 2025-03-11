class Solution {
    public void rotateMatrix(int[][] mat) {
        int n = mat.length;

        // Traverse half the matrix
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n; j++) {
                // Swap (i, j) with its 180-degree counterpart (n-1-i, n-1-j)
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        solution.rotateMatrix(mat1);
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }

        int[][] mat2 = {
            {41, 44, 34, 37, 29},
            {40, 18, 3, 24, 9},
            {15, 37, 20, 20, 47},
            {37, 35, 31, 26, 29},
            {6, 27, 33, 27, 3}
        };
        solution.rotateMatrix(mat2);
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                System.out.print(mat2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
