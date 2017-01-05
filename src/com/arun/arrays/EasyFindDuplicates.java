package com.arun.arrays;

import java.util.ArrayList;
import java.util.List;

public class EasyFindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arg1 = {4,3,2,7,8,2,3,1};
		EasyFindDuplicates a = new EasyFindDuplicates();
		List<Integer> res = a.findDuplicates(arg1);
		System.out.println(res.toString());
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> retList = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++){
			int curValue = nums[i];
			if(curValue <= -2 || curValue == (i + 1)){
				continue;
			}else{
				nums[i] = -1;
			}
			
			while(curValue != -1 && nums[curValue - 1] > -2 && curValue != nums[curValue - 1]){
				int temp = nums[curValue - 1];
				nums[curValue - 1] = curValue;
				curValue = temp;
			}
			
			if(curValue != -1){
				if(nums[curValue - 1] <= -2){
					nums[curValue - 1]--;
				}else if(curValue == nums[curValue - 1]){
					nums[curValue - 1] = -2;
				}
			}
			
		}
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == -2){
				retList.add(i+1);
			}
		}
		
		
		return retList;
    }
}
