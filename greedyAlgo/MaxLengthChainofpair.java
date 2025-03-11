package greedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainofpair {
    public static void main(String[] args) {//o(nlogn)
        int pairs [][] = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // sort by end time
        int chainlength=1;
        int pairEnd=pairs[0][1];//last selected pair end chain end
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>pairEnd){
                chainlength++;
                pairEnd=pairs[i][1];
            }
        }
        System.out.println("the longest chain length is = "+chainlength);

    }
    
}
