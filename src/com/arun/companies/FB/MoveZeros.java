package com.arun.companies.FB;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();
        int[] a1 = {0, 0, 0, 0, 0};
        int[] a2 = {};
        int[] a3 = {1, 0, 4, 23, 0, 0, 90};
        int[] a4 = {5, 0};
        int[] a5 = {0, 0, 1};

        solution.moveZeroes(a1);
        solution.moveZeroes(a2);
        solution.moveZeroes(a3);
        solution.moveZeroes(a4);
        solution.moveZeroes(a5);

        assert Arrays.equals(a1, new int[]{0, 0, 0, 0, 0});
        assert Arrays.equals(a2, new int[]{});
        assert Arrays.equals(a3, new int[]{1, 4, 23, 90, 0, 0, 0});
        assert Arrays.equals(a4, new int[]{5, 0});
        assert Arrays.equals(a5, new int[]{1, 0, 0});


    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;

        int zeroCounter = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                if(zeroCounter == -1){
                    zeroCounter = i;
                }
            }else{
                if(zeroCounter != -1){
                    this.swap(nums, i, zeroCounter);
                    zeroCounter++;
                }
            }
        }

        //System.out.println("returning: "+ Arrays.toString(nums));


    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
