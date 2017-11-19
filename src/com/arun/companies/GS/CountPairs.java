package com.arun.companies.GS;

import java.util.HashMap;
import java.util.Set;

public class CountPairs {
    public static void main(String[] args) {
        assert countPairs(6, new int[]{1,2,3,4,5}) == 2;
        assert countPairs(2, new int[]{1,1,1}) == 3;
    }

    static int countPairs(int k, int[] a) {
        HashMap<Integer, Integer> nos = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            Integer val = nos.get(a[i]);
            if( val == null){
                val = 0;
            }
            nos.put(a[i], ++val);
        }

        int pairs = 0;
        Set<Integer> keys = nos.keySet();

        for(int key: keys){
            int diff = Math.abs(key - k);
            if(diff == key){
                int no = nos.get(key);
                if(no > 1){
                    pairs = pairs + ((no*(no-1))/2);
                }
            }else{
                if(nos.get(diff) != null && nos.get(diff) != -1){
                    int no1 = nos.get(key);
                    int no2 = nos.get(diff);
                    pairs = pairs + (no1 * no2);
                    nos.put(key, -1);
                    nos.put(diff, -1);
                }
            }
        }
        return pairs;
    }
}
