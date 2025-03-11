class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; // Number of rows
        int n = board[0].length; // Number of columns

        // Directions to check all 8 neighbors
        int[] directions = {-1, 0, 1};

        // Step 1: Traverse each cell and calculate the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors using traditional loops
                for (int dx = 0; dx < 3; dx++) {
                    for (int dy = 0; dy < 3; dy++) {
                        // Skip the cell itself
                        if (directions[dx] == 0 && directions[dy] == 0) {
                            continue;
                        }

                        int ni = i + directions[dx];
                        int nj = j + directions[dy];

                        // Check if the neighbor is within bounds and alive
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n 
                                && (board[ni][nj] == 1 || board[ni][nj] == 2)) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply the rules:
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // Live cell dies → Next state dead
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // Dead cell becomes live → Next state live
                }
            }
        }

        // Step 2: Finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Dead in the next state
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Alive in the next state
                }
            }
        }
    }
}
