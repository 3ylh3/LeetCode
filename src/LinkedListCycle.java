/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author yin_zhj
 * @date 2020/5/7
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while(l1 != l2) {
            if(null == l2 || null == l2.next) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(l1));
    }
}
