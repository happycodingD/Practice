package Amazon;

/*
You are given an array prices where prices[i] is the price
of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one
stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.
 */

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                if(prices[j]-prices[i]>profit) {
                    profit = prices[j]-prices[i];
                }
            }
        }
        return profit;
    }

    public static int maxProfit_dp(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while(right < prices.length) {
            if (prices[left]<prices[right]) {
                int profit = prices[right]-prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right += 1;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println("Output: " + maxProfit_dp(prices));
    }
}
