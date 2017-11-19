package com.danal;

import java.util.Arrays;

/**
     * Prints the list of words in alphabetical order
     * 
     * YOU CAN USE ANY JAVA LIBRARY: math, collections, etc.
     */
public class SortWords {

    private String[] wordsToSort = {"watermelons", "costs", "twelve", "apple", "more", "than", "An"};

    public static void main(String[] args) {

        SortWords sw = new SortWords();
        
        //ADD CODE HERE
        Arrays.sort(sw.wordsToSort);
        for(String s : sw.wordsToSort){
            System.out.println(s);
        }
    }



}
