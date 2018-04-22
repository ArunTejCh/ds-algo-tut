package com.arun.companies.amazon;

import java.util.*;

public class ReorderLines {

    public static void main(String[] args) {
        ReorderLines inst = new ReorderLines();

        List<String> test = new ArrayList<>();
        test.add("a1 9 3 2 1");
        test.add("g1 Act car");
        test.add("zo4 4 7");
        test.add("ab1 off KEY dog");
        test.add("a8 act zoo");
        //Collections.sort(test);
        //System.out.println(test.toString());
        System.out.println(inst.reorderLines(5,test).toString());


    }

    public List<String> reorderLines(int logfileSize, List<String> logfile){
        List<String> result = new ArrayList<>();
        List<String> intLogs = new ArrayList<>();

        Map<String, String> stringLogs = new TreeMap<>();

        for(String log : logfile){
            String[] words = log.split(" ");
            if(!isInteger(words[1])) {
                String key = String.join(" ", Arrays.copyOfRange(words, 1, words.length - 1));
                key = key + words[0];

                stringLogs.put(key, log);
            }else{
                intLogs.add(log);
            }
        }

        for(String key : stringLogs.keySet()){
            result.add(stringLogs.get(key));
        }
        result.addAll(intLogs);
        return result;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
