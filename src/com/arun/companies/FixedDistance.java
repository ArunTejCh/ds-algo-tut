package com.arun.companies;

import java.util.Arrays;

public class FixedDistance {

    public static void main(String[] args) {
        FixedDistance sol = new FixedDistance();

        assert fixedDistance(new int[]{1,5,3,4,2}, 2) == 3;
        assert fixedDistance(new int[]{2,4,6,8,10,12}, 2) == 5;


    }

    static int fixedDistance2(int[] a, int d) {

        int counter = 0;

        for(int i = 0 ; i < a.length ; i++){
            for(int j = i ; j < a.length; j++){
                int dist = Math.abs(a[i] - a[j]);
                if(dist == d)
                    counter++;
            }
        }

        return counter;

    }

    static int fixedDistance(int[] a, int d) {

        if(a.length == 0 || a.length ==1){
            return 0;
        }

        int counter = 0;

        Arrays.sort(a);

        int lower = 0;
        int upper = 1;

        while(upper < a.length){
            int curDist = a[upper] - a[lower];
            if(curDist == d){
                counter++;
                lower++;
                upper++;
            }else if(curDist > d){
                lower++;
            }else{
                upper++;
            }
        }

        return counter;

    }

}
