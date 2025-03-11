public class sumMatrix {
    public int[][] generateMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Determine the maximum value we can place in matrix[i][j]
                int minValue = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = minValue;
                
                // Deduct the used value from rowSum and colSum
                rowSum[i] -= minValue;
                colSum[j] -= minValue;
            }
        }

        return matrix;
    }
}
 
    

