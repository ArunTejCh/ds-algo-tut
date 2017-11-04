package com.arun.companies.FB;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] n1 = {};
        int[] n2 = {0,0,0};
        int[] n3 = {1, 1, 1, 1};
        int[] n4 = {1,2,3,3,4,4,4,5,6,7,8,8,9};

        assert sol.removeDuplicates(n1) == 0;
        assert sol.removeDuplicates(n2) == 1;
        assert sol.removeDuplicates(n3) == 1;
        assert sol.removeDuplicates(n4) == 9;
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0 || nums.length == 1)
            return nums.length;

        int cur = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[cur]){
                nums[i] = -1;
            }else{
                cur++;
                this.swap(nums, cur, i );

            }
        }
        return cur + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
