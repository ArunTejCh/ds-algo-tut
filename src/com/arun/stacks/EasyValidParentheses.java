package com.arun.stacks;

import java.util.Stack;

public class EasyValidParentheses {

	public static void main(String[] args) {

		EasyValidParentheses inst = new EasyValidParentheses();

		String arg1 = null;
		String arg2 = "";
		String arg3 = "(]";
		String arg4 = "([)]";
		String arg5 = "{}()[][{}]{]";
		String arg6 = "{}()[]";
		String arg7 = "{([])}";
		String arg8 = "{}[({})]";

		assert inst.isValid(arg1) == true;
		assert inst.isValid(arg2) == true;
		assert inst.isValid(arg3) == false;
		assert inst.isValid(arg4) == false;
		assert inst.isValid(arg5) == false;
		assert inst.isValid(arg6) == true;
		assert inst.isValid(arg7) == true;
		assert inst.isValid(arg8) == true;
	}

	public boolean isValid(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> braces = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '{' || cur == '[' || cur == '(') {
				braces.push(cur);
			} else {
				if(braces.size() == 0)
					return false;
				char counterPart = braces.pop();
				switch (cur) {
				case '}':
					if (counterPart == '{')
						break;
					else
						return false;
				case ']':
					if (counterPart == '[')
						break;
					else
						return false;
				case ')':
					if (counterPart == '(')
						break;
					else
						return false;

				}
			}
		}
		
		if(braces.size() == 0)
			return true;
		else
			return false;
	}
}
