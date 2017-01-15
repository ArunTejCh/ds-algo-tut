package com.arun.math;

public class EasyArrangingCoins {

	public static void main(String[] args) {
		EasyArrangingCoins inst = new EasyArrangingCoins();
		
		int arg1 = 0;
		int arg2 = 1;
		int arg3 = 3;
		int arg4 = 11;
		
		
		assert inst.arrangeCoins(arg1) == 0;
		assert inst.arrangeCoins(arg2) == 1;
		assert inst.arrangeCoins(arg3) == 2;
		assert inst.arrangeCoins(arg4) == 4;
	}
	
    public int arrangeCoins(int n) {
    	if(n == 0){
    		return 0;
    	}
    	int i = 0;
    	while(i < n){
    		i++;
    		n = n-i;
    		
    	}
        return i;
    }

}
