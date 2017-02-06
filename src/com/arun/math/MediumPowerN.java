package com.arun.math;

public class MediumPowerN {

	public static void main(String[] args) {

		MediumPowerN inst = new MediumPowerN();
		
		assert inst.myPow(0, 0) == 1;
		assert inst.myPow(2, 0) == 1;
		assert inst.myPow(2, 3) == 8;
		assert inst.myPow(2, -1) == 0.5;
		assert inst.myPow(-1, Integer.MIN_VALUE) == 0;
	}
	
    public double myPow(double x, int n) {
        
    	if(n == 0){
    		return 1;
    	}
    	boolean isNeg = n < 0 ? true:false;
    	if(isNeg){
    		if(n == Integer.MIN_VALUE){
    			n = Integer.MAX_VALUE-1;
    		}else{
    			n = -n;
    		}
    	}
    	double ret = 0;
    	if(n%2==0){
    		ret = myPow(x, n/2);
    		ret = ret * ret;
    	}else{
    		ret = myPow(x, (n-1)/2);
    		ret = ret * ret * x;
    	}
    	
    	if(!isNeg)
    		return ret;
    	else
    		return (1/ret);
    }

}
