package com.arun.strings;

public class EasyLengthOfLastWord {

	public static void main(String[] args) {
		EasyLengthOfLastWord inst = new EasyLengthOfLastWord();
		
		String arg1 = "Hello World";
		String arg2 = "Mary had a little Lamb";
		String arg3 = "";
		String arg4 = "baaaaaaaa";
		String arg5 = " ";
		
		assert inst.lengthOfLastWord(arg1) == 5;
		assert inst.lengthOfLastWord(arg2) == 4;
		assert inst.lengthOfLastWord(arg3) == 0;
		assert inst.lengthOfLastWord(arg4) == 9;
		assert inst.lengthOfLastWord(arg5) == 0;
		
	}

    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	if(s==null || s.equalsIgnoreCase("")){
    		return 0;
    	}
        String[] strs = s.split(" ");
    	return strs[strs.length-1].length();
    }
}
