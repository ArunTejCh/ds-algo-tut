package com.arun.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class EasySymmetricTree {

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

		EasySymmetricTree inst = new EasySymmetricTree();

		TreeNode arg1 = inst.new TreeNode(5);

		TreeNode arg21 = inst.new TreeNode(5);
		TreeNode arg22 = inst.new TreeNode(3);
		TreeNode arg23 = inst.new TreeNode(3);
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

		assert inst.isSymmetric(null) == true;
		assert inst.isSymmetric(arg1) == true;
		assert inst.isSymmetric(arg21) == true;
		assert inst.isSymmetric(arg31) == false;

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		if((root.left == null && root.right !=null) || (root.right == null && root.left !=null)){
			return false;
		}

		Queue<TreeNode> left = new LinkedList<TreeNode>();
		Queue<TreeNode> right = new LinkedList<TreeNode>();

		if (root.left.val == root.right.val) {
			left.offer(root.left);
			right.offer(root.right);
		} else {
			return false;
		}

		while (!(left.size() == 0 && right.size() == 0)) {
			TreeNode l = left.remove();
			TreeNode r = right.remove();

			if(l.left == null ){
				if(r.right != null ){
					return false;
				}
			}else{
				if(r.right == null){
					return false;
				}
				
				if(l.left.val == r.right.val){
					left.offer(l.left);
					right.offer(r.right);
				}else{
					return false;
				}
			}
			
			if(l.right == null ){
				if(r.left != null ){
					return false;
				}
			}else{
				if(r.left == null){
					return false;
				}
				
				if(l.right.val == r.left.val){
					left.offer(l.right);
					right.offer(r.left);
				}else{
					return false;
				}
			}
		}

		return true;
	}
}
