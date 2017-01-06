package com.arun.strings;

public class EasyReverseString {

	public static void main(String[] args) {

		EasyReverseString inst = new EasyReverseString();

		String arg1 = "hello";
		String ret1 = inst.reverseString(arg1);
		assert ret1.equalsIgnoreCase("olleh");

	}

	public String reverseString(String s) {

		StringBuilder ret = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			ret.append(s.charAt(i));
		}

		return ret.toString();
	}

}
