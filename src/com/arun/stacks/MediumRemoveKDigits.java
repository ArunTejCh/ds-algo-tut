package com.arun.stacks;

import java.util.HashSet;
import java.util.Set;

public class MediumRemoveKDigits {

	public static void main(String[] args) {
		MediumRemoveKDigits inst = new MediumRemoveKDigits();
		
		String arg11 = ""; int arg12 = 0;
		String arg21 = "1432219"; int arg22 = 3;
		String arg31 = "10200"; int arg32 = 1;
		String arg41 = "10"; int arg42 = 2;
		String arg51 = "4444449";int arg52 = 3;
		String arg61 = "43214321"; int arg62 = 4;
		
		assert inst.removeKdigits(arg11, arg12).equalsIgnoreCase("0");
		assert inst.removeKdigits(arg21, arg22).equalsIgnoreCase("1219");
		assert inst.removeKdigits(arg31, arg32).equalsIgnoreCase("200");
		assert inst.removeKdigits(arg41, arg42).equalsIgnoreCase("0");
		assert inst.removeKdigits(arg51, arg52).equalsIgnoreCase("4444");
		assert inst.removeKdigits(arg61, arg62).equalsIgnoreCase("1321");
		
	}
	
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
        	return "0";
        }
        if(k == 0){
        	return num;
        }
        
        Set<Integer> indexes = new HashSet<Integer>();
        int needToRemove = k;
        for(int i = 0; i < num.length() - k; i++){
        	boolean allEqual = true;
        	int localMaxima = Integer.MIN_VALUE;
        	int localMaximaIndex = -1;
        	for(int j = i; j < i + k + 1; j++){
        		if(indexes.contains(j)){
        			continue;
        		}
        		if(j != i + k && num.charAt(j) != num.charAt(j+1)){
        			allEqual = false;
        		}
        		
        		if(j == i){
        			if(num.charAt(j+1)=='0'){
        				localMaximaIndex = j;
        				break;
        			}
        		}
        		int val = num.charAt(j) - '0';
        		if(val > localMaxima){
        			localMaxima = val;
        			localMaximaIndex = j;
        		}
        	}
        	
        	if(!allEqual){
        		indexes.add(localMaximaIndex);
        		if(localMaximaIndex==i && num.charAt(i+1)=='0')
        			indexes.add(i+1);
        		needToRemove--;
        		if(needToRemove == 0)
        			break;
        	}
        }
        
        StringBuilder optimal = new StringBuilder();
        
        for(int i =0; i < num.length(); i++){
        	if(!indexes.contains(i)){
        		optimal.append(num.charAt(i));
        	}
        }
    	
        String ret = optimal.toString().substring(0, optimal.length() - needToRemove);
        
        if(ret.length() == 0){
        	return "0";
        }else{
        	return ret;
        }
    	
    }

}
