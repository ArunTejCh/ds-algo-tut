package com.arun.bst;

public class MediumDeleteNode {

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

	public static void main(String[] args) {
		MediumDeleteNode inst = new MediumDeleteNode();

		TreeNode arg11 = inst.new TreeNode(5);
		TreeNode arg12 = inst.new TreeNode(3);
		TreeNode arg13 = inst.new TreeNode(7);
		TreeNode arg14 = inst.new TreeNode(2);
		TreeNode arg15 = inst.new TreeNode(4);

		arg11.left = arg12;
		arg11.right = arg13;
		arg12.left = arg14;
		arg12.right = arg15;

		inst.deleteNode(arg11, -1);
		inst.deleteNode(arg11, 7);
		inst.deleteNode(arg11, 3);
		inst.deleteNode(arg11, 5);

	}

	public TreeNode deleteNode(TreeNode root, int key) {

		TreeNode del = findNode(root, key);
		if (del != null)
			return removeNode(root, del);

		return root;
	}

	private TreeNode removeNode(TreeNode root, TreeNode del) {

		// Case 1: Leaf node & Case 2: Single child
		if (del.left == null || del.right == null) {
			return simpleDelete(root, del);
		} else {
			// Case 3: Two children
			return replaceWithSuccessor(root, del);
		}

	}

	private TreeNode replaceWithSuccessor(TreeNode root, TreeNode del) {

		TreeNode succ = findSuccessor(root, del);
		root = this.removeNode(root, succ);
		del.val = succ.val;
		return root;
	}

	private TreeNode findSuccessor(TreeNode root, TreeNode del) {
		if (del.right != null) {
			return findMinimum(del.right);
		} else {
			return findTreeSuccessor(root, del, null);
		}
	}

	private TreeNode findTreeSuccessor(TreeNode root, TreeNode cur, TreeNode par) {
		if(cur.val == root.val){
			return par;
		}else if(cur.val < root.val){
			return findTreeSuccessor(root.left, cur, root);
		}else{
			return findTreeSuccessor(root.right, cur, par);
		}
	}

	private TreeNode findMinimum(TreeNode right) {
		TreeNode cur = right;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur;
	}

	private TreeNode simpleDelete(TreeNode root, TreeNode del) {

		TreeNode parent = null;
		TreeNode cur = root;

		while (cur != del) {
			parent = cur;
			if (cur.val < del.val) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}

		TreeNode child = null;

		if (cur.left != null) {
			child = cur.left;
		} else {
			child = cur.right;
		}

		if (parent != null) {
			if (parent.left == cur) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		} else {
			return child;
		}
		return root;
	}

	private TreeNode findNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root.val == key) {
			return root;
		} else if (root.val < key) {
			return findNode(root.right, key);
		} else {
			return findNode(root.left, key);
		}
	}

}
