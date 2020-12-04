package com.xiaobai.leetcood;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yin_zhj
 * @date 2020/12/4
 */
public class Interview_17_12 {
    public TreeNode convertBiNode(TreeNode root) {
        if(null == root) {
            return null;
        }
        List<TreeNode> list = new LinkedList<>();
        //中序遍历
        mid(root, list);
        for(int i = 1;i < list.size();i++) {
            list.get(i - 1).left = null;
            list.get(i - 1).right = list.get(i);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    public void mid(TreeNode root, List<TreeNode> list) {
        if(null == root) {
            return;
        }
        if(null != root.left) {
            mid(root.left, list);
        }
        list.add(root);
        if(null != root.right) {
            mid(root.right, list);
        }
    }
}
