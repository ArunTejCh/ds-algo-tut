package com.arun.companies.FB;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths inst = new BinaryTreePaths();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        System.out.println(inst.binaryTreePaths(n1).toString());
        System.out.println(inst.binaryTreePaths(null).toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null)
            return ret;
        recurse(root, ret,"");
        return ret;
    }

    public void recurse(TreeNode node, List<String> list, String curPath){
        if(node.left == null && node.right == null){
            if(curPath.equalsIgnoreCase("")){
                list.add(node.val+"");
            }else {
                list.add(curPath + "->" + node.val);
            }
            return;
        }
        if(curPath.equalsIgnoreCase(""))
            curPath = node.val+"";
        else
            curPath = curPath + "->"+node.val;

        if(node.left != null)
            recurse(node.left, list, curPath);

        if(node.right != null)
            recurse(node.right, list, curPath);
    }
}

