package com.arun.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MediumBSTIterator {

	public static void main(String[] args) {

	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public MediumBSTIterator(TreeNode root) {
		this.root = root;
		List<Integer> retList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(cur.left == null && cur.right == null){
				retList.add(cur.val);
			}else{
				TreeNode left = cur.left;
				TreeNode right = cur.right;
				cur.left = null;
				cur.right = null;
				if(right != null)
				    stack.push(right);
				stack.push(cur);
				if(left != null)
				    stack.push(left);
			}
		}
		for(int i = retList.size()-1; i >= 0; i--){
			inorder.push(retList.get(i));
		}
    }
	
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> retList = new ArrayList<Integer>();
		if (root != null)
			recurse(root, retList);
		return retList;
    }

    public void recurse(TreeNode node, List<Integer> retList) {

		if (node.left == null && node.right == null) {
			retList.add(node.val);
			return;
		}

		if (node.left != null)
			recurse(node.left, retList);
		
		retList.add(node.val);
		
		if (node.right != null)
			recurse(node.right, retList);
	}
	
	TreeNode root = null;
	Stack<Integer> inorder = new Stack<Integer>();

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inorder.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return inorder.pop();
    }


}
