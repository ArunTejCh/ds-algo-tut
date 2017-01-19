package com.arun.math;

public class MediumValidPerfectSquare {

	public static void main(String[] args) {
		MediumValidPerfectSquare inst = new MediumValidPerfectSquare();
		
		int arg1 = 0;
		int arg2 = 1;
		int arg3 = 2;
		int arg4 = 4;
		int arg5 = 7;
		int arg6 = 9;
		int arg7 = 676;
		
		assert inst.isPerfectSquare(arg1) == false;
		assert inst.isPerfectSquare(arg2) == true;
		assert inst.isPerfectSquare(arg3) == false;
		assert inst.isPerfectSquare(arg4) == true;
		assert inst.isPerfectSquare(arg5) == false;
		assert inst.isPerfectSquare(arg6) == true;
		assert inst.isPerfectSquare(arg7) == true;
	}

    public boolean isPerfectSquare(int num) {
        
    	int low = 1;
    	int high = num;
    	
    	while(low <= high){
    		long mid = (low + high)/2;
    		long mul = mid * mid;
    		if(mul == num){
    			return true;
    		}else if(mul > num){
    			high = (int)mid - 1;
    		}else{
    			low = (int)mid +1;
    		}
    		
    	}
    	
    	return false;
    }
}
