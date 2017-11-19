package com.arun.companies.FB;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree inst = new DiameterOfBinaryTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        assert inst.diameterOfBinaryTree(null) == 0;
        assert inst.diameterOfBinaryTree(new TreeNode(1)) == 0;
        assert inst.diameterOfBinaryTree(n1) == 3;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

    public int recurse(TreeNode node, int x){
        return 0;
    }
}

