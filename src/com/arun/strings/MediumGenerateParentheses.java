package com.arun.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediumGenerateParentheses {

	public static void main(String[] args) {
		MediumGenerateParentheses inst = new MediumGenerateParentheses();
		int arg1 = 3;
		String[] res = {
		                 "((()))",
		                 "(()())",
		                 "(())()",
		                 "()(())",
		                 "()()()"
		               };
		List<String> list1 =  Arrays.asList(res);
		
		assert inst.generateParenthesis(arg1) == list1;
		
		
 	}

	public List<String> generateParenthesis(int n) {

		List<String> pars = new ArrayList<String>();
		int left = n;
		int right = n;
		recurse(left,right,pars,"");
		return pars;
	}

	public void recurse(int left, int right, List<String> pars, String cur) {
		if (left == 0 && right == 0) {
			pars.add(cur.toString());
			return;
		}

		if (left > right) {
			return;
		}

		if(left > 0)
			recurse(left - 1, right, pars, cur +"(");
		if(right > 0)
			recurse(left, right - 1, pars, cur +")");

	}
}
