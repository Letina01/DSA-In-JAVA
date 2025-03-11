public class searchSortedMat {
    public static boolean searchMatrix(int[][] mat, int target) {
        int n=mat.length,m=mat[0].length;
        int low=0,high=(n*m)-1;
        while(low<high){
            int mid=low+(high-low)/2;
            int row=mid/m,col=mid%m;
            if(mat[row][col]==target){
                return true;
            }else if(mat[row][col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int key = 8;
        searchMatrix(mat, key);
    }
    
}
