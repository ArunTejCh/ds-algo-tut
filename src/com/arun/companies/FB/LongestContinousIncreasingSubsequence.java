package com.arun.companies.FB;

public class LongestContinousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 0  || nums.length ==1)
            return nums.length;

        int maxlen = 1;
        int curMax = nums[0];
        int curlen = 1;
        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            if(cur > curMax){
                curlen++;
            }else{
                curlen = 1;
            }
            curMax = cur;
            if(curlen > maxlen)
                maxlen = curlen;
        }

        return maxlen;
    }
}
