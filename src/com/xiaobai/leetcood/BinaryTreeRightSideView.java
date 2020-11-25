package com.xiaobai.leetcood;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 * @author yin_zhj
 * @date 2020/4/23
 */
public class BinaryTreeRightSideView {
    /**
     * 采用层次遍历的思想，每次先访问右孩子，使用一个hashmap记录每一层对应的最右边节点（即每一层访问的第一个节点），
     * 使用两个队列，其中一个用于存储层次遍历时的节点，另一个用来存储层次遍历时节点所处的层级
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        if(null == root) {
            return rs;
        }
        levelMap.put(1, root.val);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> lvlQueue = new LinkedList<>();
        lvlQueue.add(1);
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode treeNode = nodeQueue.poll();
            int lvl = lvlQueue.poll();
            if(!levelMap.containsKey(lvl)) {
                levelMap.put(lvl, treeNode.val);
            }
            if(null != treeNode.right) {
                nodeQueue.add(treeNode.right);
                lvlQueue.add(lvl + 1);
            }
            if(null != treeNode.left) {
                nodeQueue.add(treeNode.left);
                lvlQueue.add(lvl + 1);
            }

        }
        for(Map.Entry<Integer, Integer> entry : levelMap.entrySet()) {
            rs.add(entry.getValue());
        }
        return rs;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);
        List<Integer> rs = binaryTreeRightSideView.rightSideView(treeNode);
        for(int val : rs) {
            System.out.print(val + " ");
        }
    }
}
