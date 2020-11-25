package com.xiaobai.leetcood;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * @author yin_zhj
 * @date 2020/4/14
 */
public class AddTwoNumbersII {
    /**
     * 利用栈来存储两个数字和结果，记录进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        while(null != l1) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(null != l2) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty() && !s2.isEmpty()) {
                int rs = s1.pop() + s2.pop() + tmp;
                tmp = rs / 10;
                s3.push(rs % 10);
            } else if(s1.isEmpty()) {
                int rs = s2.pop() + tmp;
                tmp = rs / 10;
                s3.push(rs % 10);
            } else {
                int rs = s1.pop() + tmp;
                tmp = rs / 10;
                s3.push(rs % 10);
            }
        }
        if(0 != tmp) {
            s3.push(tmp);
        }
        ListNode tmpNode = new ListNode(s3.pop());
        ListNode result = tmpNode;
        while(!s3.isEmpty()) {
            tmpNode.next = new ListNode(s3.pop());
            tmpNode = tmpNode.next;
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode rs = addTwoNumbersII.addTwoNumbers(l1, l2);
        while(null != rs) {
            System.out.print(rs.val + " ");
            rs = rs.next;
        }
    }
}
