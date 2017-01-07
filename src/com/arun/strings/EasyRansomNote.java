package com.arun.strings;

import java.util.HashMap;
import java.util.Map;

public class EasyRansomNote {

	public static void main(String[] args) {

		EasyRansomNote inst = new EasyRansomNote();
		
		String arg11 = "a";
		String arg12 = "b";
		boolean res1 = inst.canConstruct(arg11, arg12);
		assert res1 == false;
		
		String arg21 = "aa";
		String arg22 = "ab";
		boolean res2 = inst.canConstruct(arg21, arg22);
		assert res2 == false;
		
		String arg31 = "aa";
		String arg32 = "aab";
		boolean res3 = inst.canConstruct(arg31, arg32);
		assert res3 == true;
		
	}

	public boolean canConstruct(String ransomNote, String magazine) {

		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		
		for(int i = 0; i < magazine.length(); i++){
			char curChar = magazine.charAt(i);
			Integer value = charMap.get(curChar);
			if(value == null){
				value = 0;
			}
			charMap.put(curChar, ++value);
		}
		
		for(int i = 0; i < ransomNote.length(); i++){
			char ranChar = ransomNote.charAt(i);
			Integer value = charMap.get(ranChar);
			if(value == null || value == 0){
				return false;
			}
			charMap.put(ranChar, --value);
		}
		
		
		return true;
	}

}
