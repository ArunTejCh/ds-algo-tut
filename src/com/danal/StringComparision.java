package com.danal;

import java.util.Map;

public class StringComparision {

    public static void main(String[] args) {
        StringComparision inst = new StringComparision();

        assert inst.compare("", "") == 100;
        assert inst.compare("arun", "arun") == 100;
        assert inst.compare("arun", "") == 0;
        assert inst.compare("arun", "runa") == 99;
        assert inst.compare("arun", "oneon") == 20;
        assert inst.compare("ab", "abab") == 50;


    }

    public int compare(String s1, String s2){

        String longer = null;
        String shorter = null;

        if(s1.length() > s2.length()) {
            longer = s1;
            shorter = s2;
        } else{
            longer = s2;
            shorter = s1;
        }


        if(longer.equalsIgnoreCase(shorter))
            return 100;

        if((longer.length() == 0 && shorter.length()!= 0) || (shorter.length() == 0 && longer.length()!= 0))
            return 0;

        char[] countsOne = new char[26];
        char[] countsTwo = new char[26];

        for(int i = 0; i < longer.length(); i++)
            countsOne[longer.toLowerCase().charAt(i) - 97]++;

        for(int i = 0; i < shorter.length(); i++)
            countsTwo[shorter.toLowerCase().charAt(i) - 97]++;

        int count = 0;
        for(int i = 0; i < 26; i++){
            count = count + Math.min(countsOne[i], countsTwo[i]);
        }

        int percentSimilar = (count/longer.length()) * 100;

        if(percentSimilar == 100) {
            return percentSimilar - 1;
        }else{
            return percentSimilar;
        }
    }


}
