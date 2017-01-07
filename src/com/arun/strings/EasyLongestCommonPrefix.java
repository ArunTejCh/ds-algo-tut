package com.arun.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EasyLongestCommonPrefix {

	public static void main(String[] args) {
		EasyLongestCommonPrefix inst = new EasyLongestCommonPrefix();
		
		String[] arg1 = {"arun", "aruntej", "aruntejrox", "abcde", "arunxyzc" , "angie"};
		String[] arg2 = {};
		String[] arg3 = {"cbd", "cbe", "cyc", "cbc"};
		String[] arg4 = {"", "b"};
		
		String res1 = inst.longestCommonPrefix(arg1);
		String res2 = inst.longestCommonPrefix(arg2);
		String res3 = inst.longestCommonPrefix(arg3);
		String res4 = inst.longestCommonPrefix(arg4);
		
		assert res1.equalsIgnoreCase("");
		assert res2.equalsIgnoreCase("");
		assert res3.equalsIgnoreCase("c");
		assert res4.equalsIgnoreCase("");
 	}
	
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0)
    		return "";
    	
    	String pre = strs[0];
    	
    	for(int i = 1; i < strs.length; i++){
    		while(strs[i].indexOf(pre) != 0){
    			pre = pre.substring(0, pre.length() - 1);
    		}
    	}
      
    	return pre;
    }

}
