/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * @author yin_zhj
 * @date 2020/5/8
 */
public class GetKthFromEnd {
    /**
     * 双指针，第一个指针先走k - 1步，然后两个指针一起走，当第一个指针走到最后一个节点时，返回第一个指针
     * 指向的节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(null == head) {
            return null;
        }
        if(0 >= k) {
            return null;
        }
        ListNode rs = null;
        ListNode tmp = head;
        for(int i = 1;i < k;i++) {
            tmp = tmp.next;
        }
        if(null == tmp) {
            return null;
        }
        rs = head;
        while(null != tmp.next) {
            rs = rs.next;
            tmp = tmp.next;
        }
        return rs;
    }

    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode rs = getKthFromEnd.getKthFromEnd(head, 2);
        while(null != rs) {
            System.out.print(rs.val + " ");
            rs = rs.next;
        }
    }
}
