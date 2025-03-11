package greedyAlgo;
import java.util.*;

public class fractionKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        double[][] ratio = new double[val.length][2];

        for(int i = 0; i < val.length; i++){
            ratio[i][0] = val[i];
            ratio[i][1] = wt[i];
        }

        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity=0;
        int finalval=0;
        for(int i = 0; i < ratio.length; i++){
            int idx=(int)ratio[i][1];
            if(capacity+idx<=W){
                capacity+=idx;
                finalval+=ratio[i][0];
            }
            else{
                finalval+=((W-capacity)/ratio[i][1])*ratio[i][0];
                break;
            }
        }
        System.out.println("the final value is = "+finalval);
    }
    
}
