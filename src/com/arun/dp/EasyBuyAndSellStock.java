package com.arun.dp;

public class EasyBuyAndSellStock {

	public static void main(String[] args) {
		EasyBuyAndSellStock inst = new EasyBuyAndSellStock();

		int[] arg1 = null;
		int[] arg2 = {};
		int[] arg3 = { 0, 0, 0, 0, 0 };
		int[] arg4 = { 3, 6, 2, 7, 1, 8 };

		assert inst.maxProfit(arg1) == 0;
		assert inst.maxProfit(arg2) == 0;
		assert inst.maxProfit(arg3) == 0;
		assert inst.maxProfit(arg4) == 7;

	}

	public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0)
    		return 0;
    	
        int[] subSolns = new int[prices.length];
        int min = prices[0];
        subSolns[0] = 0;
        
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] > min){
        		subSolns[i] = (prices[i] - min) > subSolns[i-1] ? (prices[i] - min) : subSolns[i-1]; 
        	}else{
        		min = prices[i];
        		subSolns[i] = subSolns[i-1];
        	}
        }
    	
        return subSolns[subSolns.length - 1];
    }

}
