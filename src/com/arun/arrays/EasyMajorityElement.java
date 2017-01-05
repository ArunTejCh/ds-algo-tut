package com.arun.arrays;

import java.util.HashMap;
import java.util.Map;

public class EasyMajorityElement {

	public static void main(String[] args) {
		int[] arg = {0, 1, 0, 0, 12};
		EasyMajorityElement inst = new EasyMajorityElement();
		System.out.println(inst.majorityElement(arg));
	}

	public int majorityElement(int[] nums) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maj = nums.length/2;
		for(int num : nums){
			int val = map.get(num) == null ? 0 : map.get(num);
			map.put(num, ++val);
			if(val > maj){
				return num;
			}
		}
		
		return 0;
	}

}
