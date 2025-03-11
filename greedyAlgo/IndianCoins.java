package greedyAlgo;

import java.util.ArrayList;

public class IndianCoins {

    public static void main(String[] args) {
        int amount =590;
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int countofCoins=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<=coins.length;i--){
            while(amount>=coins[i]){
                countofCoins++;
                amount-=coins[i];
                ans.add(coins[i]);
            }
          
        }
        System.out.println("the minimum coins required are = "+countofCoins);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}

