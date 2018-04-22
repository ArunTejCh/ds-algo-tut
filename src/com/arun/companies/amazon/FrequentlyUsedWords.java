package com.arun.companies.amazon;

import java.util.*;

public class FrequentlyUsedWords {

    public static void main(String[] args) {
        FrequentlyUsedWords inst = new FrequentlyUsedWords();
        List<String> excludes = new ArrayList<>();
        excludes.add("and");
        excludes.add("he");
        excludes.add("the");
        excludes.add("to");
        excludes.add("is");
        System.out.println(inst.retrieveMostFrequentlyUsedWords("Jack and Jill went to the market to buy Cheese and Cheese is Jack favorite food", excludes));
    }

    List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude){
        List<String> freqWords = new ArrayList<>();
        if(literatureText == null || literatureText.equalsIgnoreCase("")){
            return freqWords;
        }

        String [] words = literatureText.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Boolean> wordsToExcludeMap = new HashMap<>();
        for(String word : words){
            Integer res = wordMap.getOrDefault(word, 0);
            wordMap.put(word, ++res);
        }

        for(String word : wordsToExclude){
            wordsToExcludeMap.put(word, true);
        }
        int maxFreq = 0;
        Set<String> keys = wordMap.keySet();

        for(String key : keys){
            if(!wordsToExcludeMap.getOrDefault(key, false)){
                int freq = wordMap.get(key);
                if(freq > maxFreq){
                    freqWords = new ArrayList<>();
                    maxFreq = freq;
                    freqWords.add(key);

                }else if(freq == maxFreq){
                    freqWords.add(key);
                }
            }
        }

        return freqWords;
    }
}
