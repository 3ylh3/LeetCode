import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author yin_zhj
 * @date 2020/5/8
 */
public class ReverseList {
    /**
     * 利用栈，遍历链表，将节点入栈，然后再依次出栈拼接
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(null == head) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while(null != head) {
            stack.push(head);
            head = head.next;
        }
        ListNode rs = stack.pop();
        ListNode tmp = rs;
        while(!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
            if(stack.isEmpty()) {
                tmp.next = null;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList reverseList = new ReverseList();
        ListNode rs = reverseList.reverseList(head);
        while(null != rs) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }
}
