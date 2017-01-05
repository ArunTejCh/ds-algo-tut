package com.arun.arrays;

public class EasyMoveZeroes {

	public static void main(String[] args) {
		int[] arg = {0, 1, 0, 3, 12};
		EasyMoveZeroes instance = new EasyMoveZeroes();
		instance.moveZeroes(arg);
		System.out.println(arg);
	}
	
	public void moveZeroes(int[] nums) {
		
		int zeroCount = 0;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i]==0){
				zeroCount++;
				continue;
			}
			
			if(zeroCount > 0){
			    nums[i-zeroCount] = nums[i];
			    nums[i] = 0;
			}
		}
        
    }

}
