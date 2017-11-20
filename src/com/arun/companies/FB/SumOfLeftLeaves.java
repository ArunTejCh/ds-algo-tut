package com.arun.companies.FB;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return recurse(root, 0);
    }

    public int recurse(TreeNode node, int flag){
        if(node.left == null && node.right == null)
            if( flag == 1)
                return node.val;
            else
                return 0;
        int ls = 0;
        int rs = 0;
        if(node.left != null)
            ls = recurse(node.left, 1);
        if(node.right != null)
            rs = recurse(node.right, 0);

        return ls + rs;
    }
}
