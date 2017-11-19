package com.arun.companies.FB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInaBinaryTree {
    public static void main(String[] args) {
        AverageOfLevelsInaBinaryTree inst = new AverageOfLevelsInaBinaryTree();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        assert inst.averageOfLevels(null).size() == 0;
        assert inst.averageOfLevels(new TreeNode(5)).get(0) == 5;
        assert inst.averageOfLevels(n1).size() == 3;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);

        while(!current.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            Double sum = 0.0;
            int noOfElems = current.size();
            while(!current.isEmpty()){
                TreeNode cur = current.remove();
                sum = sum + cur.val;
                if(cur.left != null)
                    next.add(cur.left);
                if(cur.right != null)
                    next.add(cur.right);
            }
            res.add(sum/noOfElems);
            current = next;
        }


        return res;
    }
}
