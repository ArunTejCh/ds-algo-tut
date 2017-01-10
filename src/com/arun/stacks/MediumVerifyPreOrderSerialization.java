package com.arun.stacks;

import java.util.Stack;

public class MediumVerifyPreOrderSerialization {

	public static void main(String[] args) {

		MediumVerifyPreOrderSerialization inst = new MediumVerifyPreOrderSerialization();

		String arg = null;
		String arg0 = "";
		String arg1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String arg2 = "1,#";
		String arg3 = "9,#,#,1";

		assert inst.isValidSerialization(arg) == true;
		assert inst.isValidSerialization(arg0) == true;
		assert inst.isValidSerialization(arg1) == true;
		assert inst.isValidSerialization(arg2) == false;
		assert inst.isValidSerialization(arg3) == false;

	}

	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return true;
		}

		Stack<String> stack = new Stack<String>();
		String[] nodes = preorder.split(",");

		for (int i = nodes.length - 1; i >= 0; i--) {
			stack.push(nodes[i]);
		}

		int count = 1;

		while (!stack.isEmpty()) {
			if (count <= 0)
				return false;
			String cur = stack.pop();
			if (cur.equalsIgnoreCase("#")) {
				--count;
			} else {
				count = count + 1;
			}
		}
		if (count == 0)
			return true;
		else
			return false;
	}
}
