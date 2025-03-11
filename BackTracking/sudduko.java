package BackTracking;

public class sudduko {

    public static boolean isSafe(int[][] board, int row, int col, int digit) {
        // Check the number in the row
        for (int i = 0; i < 9; i++) { // Iterate only from 0 to 8
            if (board[row][i] == digit) {
                return false;
            }
        }

        // Check the number in the column
        for (int i = 0; i < 9; i++) { // Iterate only from 0 to 8
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check the number in the 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true; // Return true if no conflicts
    }

    public static boolean solveSudoku(int sudoku[][], int row, int col) {
        // Base case: if the row index exceeds 8, Sudoku is solved
        if (row == 9) {
            return true;
        }

        // Move to the next row if column exceeds 8
        int nextRow = row;
        int nextCol = col + 1;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the cell is already filled, move to the next cell
        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        // Try placing digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place the digit

                // Recursively try to solve the Sudoku with this digit placed
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }

                // Backtrack if placing the digit does not lead to a solution
                sudoku[row][col] = 0;
            }
        }

        return false; // Trigger backtracking
    }

    // Print Sudoku board
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0},
            {0, 7, 4, 0, 0, 0, 6, 0, 0},
            {9, 0, 0, 7, 3, 0, 0, 0, 8},
            {2, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 0, 0, 0, 9, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 4, 0, 0}
        };

        if (solveSudoku(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists");
        }
    }
}
