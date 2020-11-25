package com.xiaobai.leetcood;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author yin_zhj
 * @date 2020/5/7
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        int lengthA = 0;
        int lengthB = 0;
        int sub = 0;
        while(null != tmpA) {
            lengthA++;
            tmpA = tmpA.next;
        }
        while(null != tmpB) {
            lengthB++;
            tmpB = tmpB.next;
        }
        if(lengthA < lengthB) {
            sub = lengthB - lengthA;
            for(int i = 0;i < sub;i++) {
                headB = headB.next;
            }
        } else {
            sub = lengthA - lengthB;
            for(int i = 0;i < sub;i++) {
                headA = headA.next;
            }
        }
        while(null != headA && null != headB) {
            if(headA == headB) {
                return headA;
            } else {
                headA  = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode tmp = new ListNode(2);
        l1.next = tmp;
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = tmp;
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode rs = getIntersectionNode.getIntersectionNode(l1, l2);
        System.out.println(rs.val);
    }
}
