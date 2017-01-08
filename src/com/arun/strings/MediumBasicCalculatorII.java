package com.arun.strings;

import java.util.ArrayList;
import java.util.List;

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
		s = s.replaceAll(" ", "");

		List<String> elems = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();

		StringBuilder cur = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				if (cur.length() > 0) {
					elems.add(cur.toString());
					cur = new StringBuilder();
				}
				elems.add(Character.toString(c));
			}else{
				cur.append(c);
			}
		}
		
		if(cur.length()>0){
			elems.add(cur.toString());
		}
		
		String[] math = {"/","*","-","+"};
		
		for(String m : math){
			for(int i = 0; i < elems.size(); i++){
				if(elems.get(i).equalsIgnoreCase(m)){
					int before = Integer.parseInt(temp.get(temp.size() - 1));
					int after = Integer.parseInt(elems.get(i+1));
					switch (m){
						case "*":
							temp.set(temp.size() - 1, (before * after)+"");
							break;
						case "/":
							temp.set(temp.size() - 1, (before / after)+"");
							break;
						case "+":
							temp.set(temp.size() - 1, (before + after)+"");
							break;
						case "-":
							temp.set(temp.size() - 1, (before - after)+"");
							break;
					}
					i++;
				}else{
					temp.add(elems.get(i));
				}
			}
			elems = temp;
			temp = new ArrayList<String>();

		}
		
		int res = Integer.parseInt(elems.get(0));
		return res;
	}

}
