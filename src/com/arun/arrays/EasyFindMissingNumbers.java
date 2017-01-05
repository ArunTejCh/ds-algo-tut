package com.arun.arrays;

import java.util.ArrayList;
import java.util.List;

public class EasyFindMissingNumbers {

	public static void main(String[] args) {

		int[] nos = {4,3,2,7,8,2,3,1};
		List<Integer> retList2 = new EasyFindMissingNumbers().findDisappearedNumbers(nos);
		System.out.println(retList2.toString());
	}
	
	public List<Integer> findDisappearedNumbersExtraMem(int[] nums) {
        
		int [] temp = new int[nums.length];
		List<Integer> retList2 = new ArrayList<Integer>(nums.length);
		
		
		for(int num : nums){
			temp[num] = -1;
		}
		
		for(int i = 0; i < temp.length; i++){
				if(temp[i] != -1){
					retList2.add(i);
				}
		}
		
		return retList2;
    }
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
	
		List<Integer> retList = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++){
			int curValue = nums[i];
			if(curValue == (i + 1)){
				continue;
			}else{
				nums[i] = -1;
			}
			
			while(curValue != -1 && curValue != nums[curValue - 1]){
				int temp = nums[curValue - 1];
				nums[curValue - 1] = curValue;
				curValue = temp;
			}
			
		}
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == -1){
				retList.add(i+1);
			}
		}
		
		return retList;
	}

}
