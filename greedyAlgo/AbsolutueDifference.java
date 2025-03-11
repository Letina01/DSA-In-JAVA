package greedyAlgo;


import java.util.Arrays;

public class AbsolutueDifference {
    public static void main(String[] args) {
        int[] arrA = {1, 3, 6, 10, 15};
        int[] arrB = {2, 3, 4, 6, 8};
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int minDiff=0;
        for(int i=0;i<arrA.length;i++){
            minDiff+=Math.abs(arrA[i]-arrB[i]);//absolute difference
        }
        System.out.println("the minimum difference is = "+minDiff);
      
    }
    
}
