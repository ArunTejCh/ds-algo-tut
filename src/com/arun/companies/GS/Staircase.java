package com.arun.companies.GS;

public class Staircase {
    public static void main(String[] args) {
        assert new Staircase().countSteps(3) == 4;
        assert new Staircase().countSteps(4) == 7;
    }

    int countSteps(int n){
        int[] cache = new int[n + 1];
        cache[0] = 1;
        return recurse(n, cache);
    }

    int recurse(int steps, int[] cache){
        if(cache[steps] != 0)
            return cache[steps];
        int one = 0;
        int two = 0;
        int three = 0;
        if((steps - 1) >= 0){
            one = recurse(steps - 1, cache);
        }

        if((steps - 2) >= 0){
            two = recurse(steps - 2, cache);
        }

        if((steps - 3) >= 0){
            three = recurse(steps - 3, cache);
        }

        cache[steps] = one + two + three;

        return cache[steps];
    }
}
