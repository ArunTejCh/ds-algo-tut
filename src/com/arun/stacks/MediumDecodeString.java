package com.arun.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class MediumDecodeString {

	public static void main(String[] args) {
		MediumDecodeString inst = new MediumDecodeString();

		String arg1 = null;
		String arg2 = "";
		String arg3 = "3[a]2[bc]";
		String arg4 = "3[a2[c]]";
		String arg5 = "2[abc]3[cd]ef";
		String arg6 = "2[2[a]]";

		assert inst.decodeString(arg1).equalsIgnoreCase("");
		assert inst.decodeString(arg2).equalsIgnoreCase("");
		assert inst.decodeString(arg3).equalsIgnoreCase("aaabcbc");
		assert inst.decodeString(arg4).equalsIgnoreCase("accaccacc");
		assert inst.decodeString(arg5).equalsIgnoreCase("abcabccdcdcdef");
		assert inst.decodeString(arg6).equalsIgnoreCase("aaaa");
	}

	public String decodeString(String s) {
		if(s == null || s.length() == 0){
			return "";
		}
		
		Stack<Character> main = new Stack<Character>();
		StringBuilder outer = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++){
			char cur = s.charAt(i);
			if(cur == ']'){
				StringBuilder s2 = new StringBuilder();
				char back = 0;
				while((back = main.pop())!= '['){
					s2.append(back);
				}
				String s4 = s2.reverse().toString();
				StringBuilder s3 = new StringBuilder();
				while(!main.empty() && !Character.isAlphabetic(main.peek()) && main.peek()!= '['){
					s3.append(main.pop());
				}
				int repeat = Integer.parseInt(s3.reverse().toString());
				String res = "";
				for(int j = 0; j < repeat; j++){
					res = res + s4;
				}
				
				for(char c: res.toCharArray())
					main.push(c);
			}else{
				main.push(cur);
			}
		}
		
		StringBuilder ret = new StringBuilder();
		for(char c : main){
			ret.append(c);
		}
		return ret.toString();
	}

}
