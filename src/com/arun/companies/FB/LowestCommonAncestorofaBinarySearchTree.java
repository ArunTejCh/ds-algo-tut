package com.arun.companies.FB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofaBinarySearchTree {

    public static void main(String[] args) {
        LowestCommonAncestorofaBinarySearchTree sol = new LowestCommonAncestorofaBinarySearchTree();

        TreeNode root = sol.new TreeNode(6);
        TreeNode n1 = sol.new TreeNode(0);
        TreeNode n2 = sol.new TreeNode(2);
        TreeNode n3 = sol.new TreeNode(4);
        TreeNode n4 = sol.new TreeNode(3);
        TreeNode n5 = sol.new TreeNode(5);
        TreeNode n6 = sol.new TreeNode(8);
        TreeNode n7 = sol.new TreeNode(7);
        TreeNode n8 = sol.new TreeNode(9);

        root.left = n2;
        root.right = n6;

        n2.left = n1;
        n2.right = n3;

        n3.left = n4;
        n3.right = n5;

        n6.left = n7;
        n6.right = n8;

        assert sol.lowestCommonAncestor(root, n2, n3).val == 2;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Queue<TreeNode> pList = this.getAncestors(root, p);
        Queue<TreeNode> qList = this.getAncestors(root, q);

        TreeNode ancestor = root;
        while(!pList.isEmpty() && !qList.isEmpty()){
            TreeNode temp = pList.peek();
            if(pList.remove().val != qList.remove().val)
                return ancestor;
            else
                ancestor = temp;
        }

        return ancestor;
    }

    public Queue<TreeNode> getAncestors(TreeNode root, TreeNode a){

        Queue<TreeNode> aList = new LinkedList<TreeNode>();
        aList.add(root);

        while(root.val != a.val){
            if(root.val < a.val){
                root = root.right;
                aList.add(root);
            }else{
                root = root.left;
                aList.add(root);
            }
        }

        return aList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
