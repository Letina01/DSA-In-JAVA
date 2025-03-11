package LEVEL1;

public class stock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyprice=Integer.MAX_VALUE;//infinity

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] >buyprice) {//profit
                int profit=prices[i]-buyprice;
                maxProfit=Math.max(maxProfit,profit);
            }else{
                buyprice=prices[i];
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {

        int prices[] = { 7, 1, 5, 3, 6, 4 };

        System.out.println(maxProfit(prices));

    }
    
}
