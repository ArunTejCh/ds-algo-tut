package com.arun.stacks;

import java.util.ArrayList;
import java.util.List;

public class MediumPreorderTraversal {

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

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> retList = new ArrayList<Integer>();
		if (root != null)
			recurse(root, retList);
		return retList;
	}

	public void recurse(TreeNode node, List<Integer> retList) {
		retList.add(node.val);

		if (node.left == null && node.right == null) {
			return;
		}

		if (node.left != null)
			recurse(node.left, retList);

		if (node.right != null)
			recurse(node.right, retList);
	}
}
