package com.arun.strings;

public class EasyRepeatedSubstringPattern {

	public static void main(String[] args) {

		EasyRepeatedSubstringPattern inst = new EasyRepeatedSubstringPattern();

		String arg1 = "abab";
		boolean ret = inst.repeatedSubstringPattern(arg1);
		assert ret == true;

		String arg2 = "aba";
		boolean ret2 = inst.repeatedSubstringPattern(arg2);
		assert ret2 == false;

		String arg3 = "abcabcabcabc";
		boolean ret3 = inst.repeatedSubstringPattern(arg3);
		assert ret3 == true;
	}

	public boolean repeatedSubstringPattern(String str) {

		for (int i = str.length() / 2; i > 0; i--) {
			if (str.length() % (i) == 0) {
				int repeat = str.length()/(i);
				StringBuilder repeater = new StringBuilder();
				String sub = str.substring(0, i);
				for(int j = 0; j < repeat; j++){
					repeater.append(sub);
				}
				
				if(repeater.toString().equalsIgnoreCase(str))
					return true;
			}
		}

		return false;
	}
}
