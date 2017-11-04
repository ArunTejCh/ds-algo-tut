package com.arun.companies.FB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArrays {
    public static void main(String[] args) {
        MergeSortedArrays sol = new MergeSortedArrays();
        int[] num1 = {0};
        int[] num2 = {1};
        sol.merge(num1, 0, num2, 1);
        assert Arrays.equals( num1 , new int[]{1});

        int[] num21 = {1,0};
        int[] num22 = {2};
        sol.merge(num21, 1, num22, 1);
        assert Arrays.equals( num21 , new int[]{1,2});
     }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if((m==0 && n==0) || n == 0)
            return;

        Queue<Integer> sortedQ = new LinkedList<Integer>();

        int counter = m + n;
        int c1 = 0;
        int c2 = 0;
        while (counter > 0){
            if(c1 < m && c2 < n){
                int c1Val = nums1[c1];
                int c2Val = nums2[c2];
                if(c1Val < c2Val){
                    sortedQ.add(c1Val);
                    c1++;
                }else{
                    sortedQ.add(c2Val);
                    c2++;
                }
            }else if(c1 < m && c2 == n){
                int c1Val = nums1[c1];
                sortedQ.add(c1Val);
                c1++;
            }else{
                int c2Val = nums2[c2];
                sortedQ.add(c2Val);
                c2++;
            }
            counter--;
        }

        for(int i = 0; i < m+n; i++)
            nums1[i] = sortedQ.remove();

        Arrays.toString(nums1);

    }
}
