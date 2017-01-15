package com.arun.math;

public class EasyAddStrings {

	public static void main(String[] args) {
		EasyAddStrings inst = new EasyAddStrings();
		
		String arg11 = null; String arg12 = null; 
		String arg21 = ""; String arg22 = "";
		String arg31 = "12345"; String arg32 = "0";
		String arg41 = "12345"; String arg42 = "54321";
		
		assert inst.addStrings(arg11, arg12) == null;
		assert inst.addStrings(arg21, arg22).equalsIgnoreCase("");
		assert inst.addStrings(arg31, arg32).equalsIgnoreCase("12345");
		assert inst.addStrings(arg41, arg42).equalsIgnoreCase("66666");
	}

    public String addStrings(String num1, String num2) {
    	if(num1 == null && num2 == null){
    		return null;
    	}
    	
    	if(num1.length() == 0 && num2.length()==0){
    		return "";
    	}
    	
        StringBuilder sumString = new StringBuilder();
        String big = null;
        String small = null;
        
        if(num1.length() > num2.length()){
        	big = num1;
        	small = num2;
        }else{
        	big = num2;
        	small = num1;
        }
        
        int diff = big.length() - small.length();
        int carryOver = 0;
        for(int i = big.length() - 1; i >= 0 ; i--){
        	int j = i - diff;
        	int smallDig = 0;
        	int bigDig = 0;
        	if(j >= 0){
        		smallDig = small.charAt(j) - '0';
        	}
        	bigDig = big.charAt(i) - '0';
        	int sum = bigDig + smallDig + carryOver;
        	sumString.append(sum % 10);
        	carryOver = sum / 10;
        }
    	if(carryOver > 0){
    	    sumString.append(carryOver);
    	}
        return sumString.reverse().toString();
    }
	
}
