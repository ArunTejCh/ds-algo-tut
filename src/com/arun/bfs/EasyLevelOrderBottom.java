package com.arun.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.arun.bfs.EasyMinimumDepth.TreeNode;

public class EasyLevelOrderBottom {
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
		
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> nodeList = new ArrayList<List<Integer>>();
    	List<List<Integer>> retList = new ArrayList<List<Integer>>();
    	if(root == null){
    		return retList;
    	}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> childQ = new LinkedList<TreeNode>();
    	q.offer(root);
    	List<Integer> curList = new ArrayList<Integer>();
        while(q.size() != 0){
        	TreeNode cur = q.remove();
        	
        	TreeNode left = cur.left;
    		TreeNode right = cur.right;
    		
    		if(left != null)
    			childQ.offer(left);
    		
    		if(right !=null)
    			childQ.offer(right);
        	
        	curList.add(cur.val);
        	if(q.size() == 0){
        		q = childQ;
        		childQ = new LinkedList<TreeNode>();
        		nodeList.add(curList);
        		curList = new ArrayList<Integer>();
        	}
        }
        
    	
    	for(int i = nodeList.size() - 1; i >= 0; i--){
    		retList.add(nodeList.get(i));
    	}
    	
    	return retList;
    }

}
