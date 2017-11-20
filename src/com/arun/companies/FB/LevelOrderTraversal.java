package com.arun.companies.FB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal inst = new LevelOrderTraversal();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        assert inst.levelOrder(null).size() == 0;
        assert inst.levelOrder(new TreeNode(5)).get(0).get(0) == 5;
        assert inst.levelOrder(n1).size() == 3;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);

        while(!current.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> curLevel = new ArrayList<>();
            while(!current.isEmpty()){
                TreeNode cur = current.remove();
                curLevel.add(cur.val);
                if(cur.left != null)
                    next.add(cur.left);
                if(cur.right != null)
                    next.add(cur.right);
            }
            res.add(curLevel);
            current = next;
        }

        return res;
    }
}
