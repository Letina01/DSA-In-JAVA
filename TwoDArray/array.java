package TwoDArray;

import java.util.Scanner;

public class array {
    public static boolean search(int matrix[][],int key){

        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==key){
                    System.out.println("Found in cell"+"("+i+","+j+")");
                    return true;
                }
            }

        }
        return false;

    }
    public static void GreatestNumber(int matrix[][]){

        int n=matrix.length;
        int m=matrix[0].length;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]>max){
                    max=matrix[i][j];
                }
               
            }
        }

        System.out.println("Greatest number in matrix is : "+max);
    }
    public static void SmallestNumber(int matrix[][]){

        int n=matrix.length;
        int m=matrix[0].length;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
        }

        System.out.println("Smallest number in matrix is : "+min);
    }

    public static void main(String[] args) {
        int[][] matrix=new int [3][3];
        Scanner sc = new Scanner(System.in);
        int n=3;
        int m=3;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();

            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println(search(matrix,5));
        GreatestNumber(matrix);
        SmallestNumber(matrix);
    }
    
}
