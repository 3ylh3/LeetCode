package com.xiaobai.leetcood;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author yin_zhj
 * @date 2020/4/11
 */
public class MergeTwoSortedLists {
    /**
     * 设置两个指针，i指向头结点值较小的那个链表，j指向另一个链表，遍历两个链表，当i.next不为空并且j不为空时,
     * 将j指针指向的节点插入到另一个链表合适的位置（判断j.val如果大于i.next.val，则将i指针后移,否则i后面的位置
     * 则为合适的位置），如果i指针指到链表尾部，j指针不为空的话，则将j指针指向的节点接到i指针后
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode rs = null;
        ListNode i = null;
        ListNode j = null;
        if(l1.val < l2.val) {
            i = l1;
            j = l2;
            rs = l1;
        } else {
            i = l2;
            j = l1;
            rs = l2;
        }

        while(i.next != null && j != null) {
            if(j.val > i.next.val) {
                i = i.next;
            } else {
                ListNode tmp = i.next;
                i.next = j;
                j = j.next;
                i.next.next = tmp;
                i = i.next;
            }
        }
        if(j != null) {
            i.next = j;
        }
        return rs;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        while(l != null) {
            System.out.println(l.val + " ");
            l = l.next;
        }
    }
}
