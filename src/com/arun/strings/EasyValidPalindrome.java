package com.arun.strings;

import java.util.ArrayList;
import java.util.List;

public class EasyValidPalindrome {

	public static void main(String[] args) {
		
		EasyValidPalindrome inst = new EasyValidPalindrome();
		
		String arg1 = "A man, a plan, a canal: Panama";
		boolean res1 = inst.isPalindrome(arg1);
		assert res1 == true;
		
		String arg2 = "race a car";
		boolean res2 = inst.isPalindrome(arg2);
		assert res2 == false;
		
		String arg3 = "";
		boolean res3 = inst.isPalindrome(arg3);
		assert res3 == true;
		
	}
	
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
        	return true;
        	
        List<Character> charList = new ArrayList<Character>();
        
        for(char cur : s.toCharArray()){
        	if(Character.isAlphabetic(cur) || Character.isDigit(cur)){
        		charList.add(Character.toLowerCase(cur));
        	}
        }
        
        for(int i = 0; i < charList.size()/2; i++){
        	if(charList.get(i) != charList.get(charList.size() - 1 - i)){
        		return false;
        	}
        }
        
    	return true;
    }

}
