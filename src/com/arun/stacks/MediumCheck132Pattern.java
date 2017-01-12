package com.arun.stacks;

public class MediumCheck132Pattern {

	public static void main(String[] args) {
		MediumCheck132Pattern inst = new MediumCheck132Pattern();
		
		int[] arg1 = null;
		int[] arg2 = {};
		int[] arg3 = {1, 2, 3, 4};
		int[] arg4 = {3, 1, 4, 2};
		int[] arg5 = {-1, 3, 2, 0};

		assert inst.find132pattern(arg1) == false;
		assert inst.find132pattern(arg2) == false;
		assert inst.find132pattern(arg3) == false;
		assert inst.find132pattern(arg4) == true;
		assert inst.find132pattern(arg5) == true;
		
	}
	
    public boolean find132pattern(int[] nums) {
    	    if(nums == null || nums.length < 3){
    	    	return false;
    	    }
    	    
    	    boolean isAsc = nums[0] < nums[1] ? true : false;
    	    
    	    if(isAsc){
    	    	for(int i = 0; i < nums.length - 1;i++){
    	    		if(nums[i] > nums[i+1]){
    	    			return true;
    	    		}
    	    	}
    	    	
    	    	
    	    }else{
    	    	for(int i = 0; i < nums.length - 1;i++){
    	    		if(nums[i] < nums[i+1]){
    	    			return true;
    	    		}
    	    	}
    	    }
    	    
    	    return false;
    }

}
