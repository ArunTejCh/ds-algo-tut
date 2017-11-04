package com.arun.companies.FB;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2,4,1,7};
        System.out.println(nums.toString());
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 8)));

    }

    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return null;
        }

        int[] ret = new int[2];

        HashMap<Integer,Integer> nos = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int rem = target - cur;
            if(nos.containsKey(rem)){
                ret[0] = nos.get(rem);
                ret[1] = i;
                return ret;
            }else{
                nos.put(cur, i);
            }

        }

        return null;

    }

}
