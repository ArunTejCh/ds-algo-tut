package com.arun.strings;

import java.util.ArrayList;
import java.util.List;

public class MediumMultiplyNumbers {

	public static void main(String[] args) {
		MediumMultiplyNumbers inst = new MediumMultiplyNumbers();

		String arg11 = "0";
		String arg12 = "0";
		String arg21 = "20";
		String arg22 = "12";
		String arg31 = "100";
		String arg32 = "0";
		String arg41 = "123";
		String arg42 = "456";

		assert inst.multiply(arg11, arg12).equalsIgnoreCase("0");
		assert inst.multiply(arg21, arg22).equalsIgnoreCase("240");
		assert inst.multiply(arg31, arg32).equalsIgnoreCase("0");
		assert inst.multiply(arg41, arg42).equalsIgnoreCase("56088");
	}

	public String multiply(String num1, String num2) {
		if(num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0")){
			return "0";
		}
		
		List<String> multiList = new ArrayList<String>();

		for (int i = num2.length() - 1; i >= 0; i--) {
			int x = num2.charAt(i) - '0';
			int carryOver = 0;
			String cur = "";
			for (int j = i; j < num2.length() - 1; j++) {
				cur = cur + "0";
			}
			for (int k = num1.length() - 1; k >= 0; k--) {
				int y = num1.charAt(k) - '0';
				int xy = x * y + carryOver;
				carryOver = xy / 10;
				cur = xy % 10 + cur;
			}
			if (carryOver > 0)
				cur = carryOver + cur;
			multiList.add(cur);
		}

		int max = multiList.get(multiList.size() - 1).length();
		int carryOver = 0;
		String fin = "";
		int add = 0;
		for (int i = 0; i < max; i++) {
			add = 0;
			for (String mid : multiList) {
				if (i < mid.length()) {
					add = add + mid.charAt(mid.length() - 1 - i) - '0';
				}

			}
			add = add + carryOver;
			fin = add % 10 + fin;
			carryOver = add / 10;
		}

		if (carryOver > 0)
			fin = carryOver + fin;

		return fin;
	}
}
