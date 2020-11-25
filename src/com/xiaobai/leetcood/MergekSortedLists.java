package com.xiaobai.leetcood;

import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author yin_zhj
 * @date 2020/4/26
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rs = null;
        if(null == lists || lists.length == 0) {
            return rs;
        }
        rs = lists[0];
        for(int i = 1;i < lists.length;i++) {
            if(null == rs) {
                rs = lists[i];
            } else if(null == lists[i]) {
                continue;
            } else {
                ListNode listNode1 = rs;
                ListNode listNode2 = lists[i];
                ListNode p = null;
                ListNode q = null;
                if (listNode1.val <= listNode2.val) {
                    p = listNode1;
                    q = listNode2;
                } else {
                    p = listNode2;
                    q = listNode1;
                }
                rs = p;
                while (null != p.next && null != q) {
                    if (p.next.val < q.val) {
                        p = p.next;
                    } else {
                        ListNode tmp = p.next;
                        p.next = q;
                        q = q.next;
                        p.next.next = tmp;
                        p = p.next;
                    }
                }
                if (null != q) {
                    p.next = q;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        MergekSortedLists mergekSortedLists = new MergekSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(0);
        ListNode[] lists = {l4, l5};
        ListNode rs = mergekSortedLists.mergeKLists(lists);
        while (null != rs) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }
}
