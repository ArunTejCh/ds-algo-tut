package com.arun.arrays;

public class EasyThirdMaximum {

	public static void main(String[] args) {
		
		int[] arg1 = {2, 2, 3, 1};
		int[] arg2 = {3, 2, 1};
		int[] arg3 = {1, 2};
		int[] arg4 = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
		
		EasyThirdMaximum temp = new EasyThirdMaximum();
		int res1 = temp.thirdMax(arg1);
		int res2 = temp.thirdMax(arg2);
		int res3 = temp.thirdMax(arg3);
		int res4 = temp.thirdMax(arg4);
		
		assert res1 == 1;
		assert res2 == 1;
		assert res3 == 2;
		assert res4 == 1;
		
		
	}

	public int thirdMax(int[] nums) {
		
		if(nums.length == 0){
			return -1;
		}
		
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
		boolean minPassed = false;
		int count = 0;
		for(int i : nums){
			
			if(i != Integer.MIN_VALUE && (i == first || i == second))
				continue;
			
			if(i > first){
				third = second;
				second = first;
				first = i;
				count++;
			}else if(i > second){
				third = second;
				second = i;
				count++;
			}else if(i >= third){
				if(!(i == Integer.MIN_VALUE && minPassed)){
					third = i;
					count++;
				}
				
				if(minPassed || i == Integer.MIN_VALUE){
					minPassed = true;
				}
			}
		}
		
		if(count>=3)
			return third;
		else
			return first;
	}

}
