package com.arun.math;

public class EasyMinimumMovesToArrayElements {

	public static void main(String[] args) {
		EasyMinimumMovesToArrayElements inst = new EasyMinimumMovesToArrayElements();

		int[] arg0 = {0,0,0};
		int[] arg1 = {1,2,3};
		int[] arg2 = {1,5,2};
		int[] arg3 = {1,4,5};
		int[] arg4 = {5,5,5};
		
		assert inst.minMoves(arg0)==0;
		assert inst.minMoves(arg1)==3;
		assert inst.minMoves(arg2)==5;
		assert inst.minMoves(arg3)==7;
		assert inst.minMoves(arg4)==0;
		
	}

    public int minMoves(int[] nums) {
        
    	int min = nums[0];
    	for(int num : nums){
    		if(num < min){
    			min = num;
    		}
    	}
    	
    	int sum = 0;
    	
    	for(int num : nums){
    		sum = sum + num - min;
    	}
    	return sum;
    }
}
