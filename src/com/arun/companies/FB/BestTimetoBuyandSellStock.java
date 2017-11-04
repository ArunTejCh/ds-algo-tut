package com.arun.companies.FB;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock solution = new BestTimetoBuyandSellStock();

        int[] c1 = {7, 1, 5, 3, 6, 4};
        int[] c2 = {7, 6, 4, 3, 1};

        assert solution.maxProfit(c1) == 5;
        assert solution.maxProfit(c2) == 0;
    }

    public int maxProfit(int[] prices) {

        int maxP = 0;
        int min = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[min]){
                min = i;
                continue;
            }

            if(prices[i] - prices[min] > maxP){
                maxP = prices[i] - prices[min];
            }
        }
        return maxP;
    }
}
