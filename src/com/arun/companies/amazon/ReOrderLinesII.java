package com.arun.companies.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReOrderLinesII {

    public static void main(String[] args) {
        ReOrderLinesII inst = new ReOrderLinesII();

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

        if(logfile == null || logfileSize == 0 || logfile.size() == 0){
            return logfile;
        }

        List<String> results = new ArrayList<>();
        List<String> intLogs = new ArrayList<>();
        List<String> stringLogs = new ArrayList<>();

        for(String log : logfile){
            String[] words = log.split(" ");
            if(Character.isDigit(words[1].charAt(0))){
                intLogs.add(log);
            }else{
                stringLogs.add(log);
            }
        }

        Collections.sort(stringLogs, new ListComparator());
        results.addAll(stringLogs);
        results.addAll(intLogs);

        return results;
    }

}

class ListComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2){
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        int loopLength = arr1.length > arr2.length ? arr2.length : arr1.length;

        for(int i = 1; i < loopLength; i++){
            int compare = arr1[i].compareTo(arr2[i]);
            if(compare < 0){
                return -1;
            }else if(compare > 0){
                return 1;
            }
        }

        if(arr1.length == arr2.length){
            return arr1[0].compareTo(arr2[0]);
        }else if(arr1.length < arr2.length){
            return -1;
        }else{
            return 1;
        }
    }
}