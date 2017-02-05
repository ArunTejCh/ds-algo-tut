package com.arun.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class EasyMinimumDepth {

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
		EasyMinimumDepth inst = new EasyMinimumDepth();
		
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

		assert inst.minDepth(null) == 0;
		assert inst.minDepth(arg1) == 1;
		assert inst.minDepth(arg21) == 2;
		assert inst.minDepth(arg31) == 3;
	}

	
    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> innerQ = new LinkedList<TreeNode>();
    	int depth = 1;
    	q.offer(root);
    	
    	while(q.size() != 0){
    		TreeNode cur = q.remove();
    		TreeNode left = cur.left;
    		TreeNode right = cur.right;
    		
    		if(left == null && right == null){
    			return depth;
    		}
    		
    		if(left != null)
    			innerQ.offer(left);
    		
    		if(right !=null)
    			innerQ.offer(right);
    		
    		if(q.size() == 0){
    			depth++;
    			q = innerQ;
    			innerQ = new LinkedList<TreeNode>();
    		}
    		
    	}
    	
    	return depth;
    }
}
