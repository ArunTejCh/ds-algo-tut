package com.arun.strings;

import java.util.Stack;

public class MediumBasicCalculatorII {

	public static void main(String[] args) {
		MediumBasicCalculatorII inst = new MediumBasicCalculatorII();

		String arg1 = "3+2*2";
		String arg2 = "2-3+4";
		String arg3 = " 3+5 / 2 ";
		String arg4 = "3/2+05*4";
		String arg5 = "5+4-2*2";
		String arg6 = "6*7/3+11-1";
		String arg7 = "";
		String arg8 = null;

		assert inst.calculate(arg1) == 7;
		assert inst.calculate(arg2) == 3;
		assert inst.calculate(arg3) == 5;
		assert inst.calculate(arg4) == 21;
		assert inst.calculate(arg5) == 5;
		assert inst.calculate(arg6) == 24;
		assert inst.calculate(arg7) == 0;
		assert inst.calculate(arg8) == 0;
	}

	public int calculate(String s) {

		if (s == null || s == "") {
			return 0;
		}

		Stack<Integer> nums = new Stack<Integer>();
		int no = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				no = no * 10 + c - '0';
			}

			if ((c!=' ' && !Character.isDigit(c)) || i == s.length() - 1) {
				switch (sign) {
				case '-':
					nums.push(-no);
					break;
				case '+':
					nums.push(no);
					break;
				case '*':
					nums.push(nums.pop() * no);
					break;
				case '/':
					nums.push(nums.pop() / no);
					break;
				}
				no = 0;
				sign = c;
			}

		}

		int res = 0;
		for(int i : nums){
			res = res + i;
		}
		
		return res;
	}

}
