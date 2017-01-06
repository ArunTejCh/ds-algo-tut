package com.arun.arrays;

public class MediumSearchForRange {

	public static void main(String[] args) {
		int[] arg1 = {5, 7, 7, 8, 8, 10};
		int[] arg2 = {};
		int[] arg3 = {6,6,6,6,6,6,6};
		int[] arg4 = {-4,-2,-1,0,0,0,0,1,5,7,9};
		int[] arg5 = {2,2};
		
		MediumSearchForRange inst = new MediumSearchForRange();
		
		int[] res1 = inst.searchRange(arg1, 8);
		assert res1[0] == 3;
		assert res1[1] == 4;
		
		int[] res2 = inst.searchRange(arg2, 8);
		assert res2[0] == -1;
		assert res2[1] == -1;
		
		int[] res3 = inst.searchRange(arg3, 6);
		assert res3[0] == 0;
		assert res3[1] == 6;
		
		int[] res4 = inst.searchRange(arg4, 0);
		assert res4[0] == 3;
		assert res4[1] == 6;
		
		int[] res5 = inst.searchRange(arg5, 1);
		assert res5[0] == -1;
		assert res5[1] == -1;
		
	}

	public int[] searchRange(int[] nums, int target) {

		int[] notFound = {-1,-1};
		
		if(nums.length == 0){
			return notFound;
		}
		
		int start = 0;
		int end = nums.length - 1;
		int targetIndex = -1;
		
		
		while(true){
			int mid = (start + end)/2;
			if(nums[mid] == target){
				targetIndex = mid;
				break;
			}
			
			if(start==end || (mid == start && nums[mid] > target) || (mid == end && nums[mid] < target)){
				break;
			}
			
			if(nums[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}

		if(targetIndex == -1)
			return notFound;
		
		int rightEdge = targetIndex;
		int leftEdge = targetIndex;
		
		while(rightEdge < nums.length && nums[rightEdge] == target)
			rightEdge++;
		
		
		while(leftEdge >= 0 && nums[leftEdge] == target)
			leftEdge--;
		
		int[] res = {leftEdge+1, rightEdge-1};
		return res;
	}

}
