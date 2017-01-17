package com.arun.math;

import java.util.Arrays;

public class MediumMinMovesToEqualArrayElemsII {

	public static void main(String[] args) {
		MediumMinMovesToEqualArrayElemsII inst = new MediumMinMovesToEqualArrayElemsII();
		
		int[] arg1 = null;
		int[] arg2 = {};
		int[] arg3 = {1,2,3};
		int[] arg4 = {3,3,3};
		int[] arg5 = {1,3,1};
		int[] arg6 = {2,3,3};
		
		assert inst.minMoves2(arg1) == 0;
		assert inst.minMoves2(arg2) == 0;
		assert inst.minMoves2(arg3) == 2;
		assert inst.minMoves2(arg4) == 0;
		assert inst.minMoves2(arg5) == 2;
		assert inst.minMoves2(arg6) == 1;
		
	}
	
    public int minMoves2(int[] nums) {
     
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	Arrays.sort(nums);
    	
    	int median = nums[nums.length/2];
    	int sum = 0;
    	
    	for(int num : nums){
    		sum = sum + Math.abs(num - median);
    	}
    	
    	return sum;
    }

}
