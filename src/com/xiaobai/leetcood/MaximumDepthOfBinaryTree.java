package com.xiaobai.leetcood;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class MaximumDepthOfBinaryTree {
    static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if(root.left == null & root.right == null){
            return 1;
        }
        else{
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }
}
