package com.arun.bst;

import java.util.Stack;

public class MediumValidateBST {

	public static void main(String[] args) {
		MediumValidateBST inst = new MediumValidateBST();
		
		TreeNode arg21 = inst.new TreeNode(5);
		TreeNode arg22 = inst.new TreeNode(3);
		TreeNode arg23 = inst.new TreeNode(6);
		arg21.left = arg22;
		arg21.right = arg23;

		TreeNode arg31 = inst.new TreeNode(5);
		TreeNode arg32 = inst.new TreeNode(3);
		TreeNode arg33 = inst.new TreeNode(3);
		TreeNode arg34 = inst.new TreeNode(4);
		TreeNode arg35 = inst.new TreeNode(4);
		arg31.left = arg32;
		arg31.right = arg33;
		arg32.left = arg34;
		arg33.left = arg35;
		
		assert inst.isValidBST(arg21) == true;
		assert inst.isValidBST(arg31) == false;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	
    public boolean isValidBST(TreeNode root) {
        
    	if(root == null)
    		return true;
    	
    	Stack<Integer> nodes = new Stack<Integer>();

    	return recursiveLoad(root,nodes);
    }

	private boolean isSorted(Stack<Integer> nodes) {
		int last = nodes.pop();
		
		while(nodes.size()!=0){
			int cur = nodes.pop();
			if(cur >= last)
				return false;
			else
				last = cur;
		}
		
		return true;
	}

	private boolean recursiveLoad(TreeNode root, Stack<Integer> nodes) {
		
		if(root == null)
			return true;
		
		boolean left = recursiveLoad(root.left, nodes);
		if(!left)
			return left;
		if(nodes.size() == 0 || (nodes.peek() < root.val))
			nodes.push(root.val);
		else
			return false;
		boolean right = recursiveLoad(root.right, nodes);
		if(!right)
			return right;
		
		return true;
	}
	
	
}
