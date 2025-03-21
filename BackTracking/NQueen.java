package BackTracking;

public class NQueen {
    //isa sfae function
    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row) {
        //base case
        if (row == board.length) {
           PrintBoard(board);
           count++;
            return;
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                
                board[row][j]='Q';
                nQueens(board, row+1);//finction call
                board[row][j]='X';//backtracking
            }
        
        }

     

    }
    //count ways
    public static int count=0;
       
    public static void PrintBoard(char board[][]){
        System.out.println("________Printing the board_________");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }

            System.out.println();
        }
       
    }


    public static void main(String[] args) {
        int n=4;

        char board[][] = new char[n][n];
        //intialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        nQueens(board, 0);
        System.out.println("Total Ways to solve n queens : "+count);
    }
    
}
//O(n!)