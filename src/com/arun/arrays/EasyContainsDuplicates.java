package com.arun.arrays;

import java.util.HashMap;
import java.util.Map;


public class EasyContainsDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arg = {0, 1, 0, 3, 12};
		EasyContainsDuplicates inst = new EasyContainsDuplicates();
		System.out.println(inst.containsDuplicate(arg));
	}

	public boolean containsDuplicate(int[] nums) {

		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		for(int num : nums){
			boolean exists = map.get(num) == null ? false : true;
			if(!exists){
				map.put(num, true);
			}else{
				return true;
			}
		}
		
		return false;
	}

}
