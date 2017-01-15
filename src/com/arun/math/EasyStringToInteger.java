package com.arun.math;

public class EasyStringToInteger {

	public static void main(String[] args) {
		EasyStringToInteger inst = new EasyStringToInteger();

		String arg1 = null;
		String arg2 = "";
		String arg3 = "-123";
		String arg4 = "00034";
		String arg5 = "-55";
		String arg6 = "75839";
		String arg7 = "0000";
		String arg8 = "+";
		String arg9 = "+1";
		String arg10 = "+234rty";
		String arg11 = "    10522545459";

		assert inst.myAtoi(arg1) == 0;
		assert inst.myAtoi(arg2) == 0;
		assert inst.myAtoi(arg3) == -123;
		assert inst.myAtoi(arg4) == 34;
		assert inst.myAtoi(arg5) == -55;
		assert inst.myAtoi(arg6) == 75839;
		assert inst.myAtoi(arg7) == 0;
		assert inst.myAtoi(arg8) == 0;
		assert inst.myAtoi(arg9) == 1;
		assert inst.myAtoi(arg10) == 234;
		assert inst.myAtoi(arg11) == Integer.MAX_VALUE;

	}

	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		long base = 1;
		boolean isNegative = false;
		str = str.trim();

		if (str.startsWith("-")) {
			isNegative = true;
			str = str.substring(1);
		} else if (str.startsWith("+")) {
			str = str.substring(1);
		}
		
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			}
			s.append(str.charAt(i));
		}
		
		str = s.toString();
		long num = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			num = num + base * (str.charAt(i) - '0');
			if (num > Integer.MAX_VALUE) {
				if(!isNegative){
					return Integer.MAX_VALUE;
				}else{
					return Integer.MIN_VALUE;
				}
				
			}
			base = base * 10;
		}

		if (isNegative) {
			num = num * -1;
		}

		if (num < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else if (num > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return (int) num;
		}
	}

}
