class Solution {

    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check 3x3 sub-grids
        for (int block = 0; block < 9; block++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = 3 * (block / 3) + i;
                    int col = 3 * (block % 3) + j;
                    if (board[row][col] != '.') {
                        int num = board[row][col] - '1';
                        if (seen[num]) {
                            return false;
                        }
                        seen[num] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(sol.isValidSudoku(board)); // Expected: true
    }
}
