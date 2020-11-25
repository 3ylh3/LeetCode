package com.xiaobai.leetcood;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * @author yin_zhj
 * @date 2020/4/10
 */
public class RemoveNthNodeFromEndofList {
    /**
     * 双指针遍历，第一个指针先往前走n步，然后两个指针同时走，当第一个指针指向尾时，第二个指针下一个
     *     节点就是要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        for(int k = 0;k < n;k++) {
            if(null != j.next) {
                j = j.next;
            } else {
                //这种情况是删除第一个节点
                head = head.next;
                return head;
            }
        }
        while(j.next != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode rs = removeNthNodeFromEndofList.removeNthFromEnd(node, 2);
        while(rs != null) {
            System.out.print(rs.val + " ");
            rs = rs.next;
        }
    }
}
