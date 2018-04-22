package com.arun.companies;

import java.util.HashSet;
import java.util.Set;

public class NextEarliestTime {
    public static void main(String[] args) {
        NextEarliestTime test = new NextEarliestTime();

        test.solution("11:00");
        //assert test.solution("23:59").equalsIgnoreCase("23:59");
    }

    Set<String> perms = new HashSet<>();

    public String solution(String s) {
        String[] temp = s.split(":");
        //find all perms
        permutation("", temp[0]+ temp[1]);

        //validate perms
        Set<String> res = validatePerms();
        //find next closest time

        return null;
    }

    private Set<String> validatePerms() {
        for(String s: perms){
        }
        return null;
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0){
            //System.out.println(prefix);
            perms.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
