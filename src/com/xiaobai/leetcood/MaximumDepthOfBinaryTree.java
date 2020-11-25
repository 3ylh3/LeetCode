package com.xiaobai.leetcood;

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
 }
public class MaximumDepthOfBinaryTree {
    static int maxDepth(TreeNode1 root) {
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
