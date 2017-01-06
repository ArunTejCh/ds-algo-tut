package com.arun.arrays;

public class MediumFindMinInRotatedArray {

	public static void main(String[] args) {
		MediumFindMinInRotatedArray inst = new MediumFindMinInRotatedArray();

		int[] arg1 = { 4, 5, 6, 7, 0, 1, 2 };
		int res1 = inst.findMin(arg1);
		assert res1 == 0;

		int[] arg2 = { 4, 5, 6, 7, 0, 0, 1, 2 };
		int res2 = inst.findMin(arg2);
		assert res2 == 0;

		/*int[] arg3 = { 7, 7, 7, 7, 7, 7 };
		int res3 = inst.findMin(arg3);
		assert res3 == 7;*/
		
		int[] arg4 = { 7, 2 };
		int res4 = inst.findMin(arg4);
		assert res4 == 2;
		
		int[] arg5 = { 1 };
		int res5 = inst.findMin(arg5);
		assert res5 == 1;

	}

	public int findMin(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		
		if(start == end){
			return nums[0];
		}
		
		while(true){
			if(nums[start] < nums[end]){
				return nums[start];
			}
			int mid = (start + end)/2;
			
			int before = mid == 0 ?  nums.length - 1 : mid - 1;
			int after = mid == nums.length - 1 ? 0 : mid + 1;
			
			
			if(nums[mid] < nums[before] && nums[mid] < nums[after]){
				return nums[mid];
			}else if(nums[mid] < nums[start]){
				end = before;
			}else{
				start = after;
			}
			
		}
	}

}
