package com.arun.companies.FB;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        VerticalOrderTraversal inst = new VerticalOrderTraversal();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        assert inst.verticalOrder(null).size() == 0;
        assert inst.verticalOrder(new TreeNode(5)).get(0).get(0) == 5;
        assert inst.verticalOrder(n1).size() == 4;


    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer,ArrayList<Integer>> orderMap = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        nodes.add(root);
        cols.add(0);
        int min = 0;
        int max = 0;

        while(!nodes.isEmpty()){
            TreeNode cu = nodes.remove();
            int column = cols.remove();
            min = Math.min(column, min);
            max = Math.max(column, max);
            ArrayList<Integer> list = orderMap.getOrDefault(column, new ArrayList<>());
            list.add(cu.val);
            orderMap.put(column, list);
            if(cu.left!=null) {
                nodes.add(cu.left);
                cols.add(column - 1);
            }
            if(cu.right!=null) {
                nodes.add(cu.right);
                cols.add(column + 1);
            }
        }

        for(int i = min; i <= max; i++)
            res.add(orderMap.get(i));

        return res;
    }


}
