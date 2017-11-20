package com.arun.companies.FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSumBST {
    public static void main(String[] args) {
        TwoSumBST inst = new TwoSumBST();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n4.left = n5;
        n5.left = n1;
        n5.right = n2;
        n4.right = n3;

        assert !inst.findTarget(null, 0);
        assert !inst.findTarget(new TreeNode(3), 4);
        assert inst.findTarget(n4, 12);

    }

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(root == null)
            return false;
        recurse(root, map);

        Set<Integer> keys = map.keySet();

        for(Integer key : keys){
            int diff = k - key;
            if(diff != key){
                if(map.containsKey(diff))
                    return true;
            }else{
                if(map.get(key) > 1)
                    return true;
            }
        }

        return false;
    }

    public void recurse(TreeNode node, Map<Integer, Integer> map){
        if(node.left!=null)
            recurse(node.left, map);
        int count = map.getOrDefault(node.val, 0);
        map.put(node.val, ++count);
        if(node.right!=null)
            recurse(node.right, map);
    }
}
