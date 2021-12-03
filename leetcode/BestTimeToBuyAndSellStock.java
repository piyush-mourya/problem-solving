// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int  i = 0 ; i < prices.length ; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            int profit;
            profit = prices[i] - min;
            if(profit >= max_profit){
                max_profit = profit;
            }
        }
        return max_profit;
    }
}
