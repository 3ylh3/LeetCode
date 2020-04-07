import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class AddTwoNumbers {
    /**
     * 用一个变量记录进位，依次相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        int jw = 0;
        int sum1 = 0;
        int sum2 = 0;
        ListNode result = new ListNode(0);
        ListNode tm = result;
        while(l1 != null || l2 != null){
            if(l1 != null){
                sum1 = l1.val;
                l1 = l1.next;
            }
            else{
                sum1 = 0;
            }
            if(l2 != null){
                sum2 = l2.val;
                l2 = l2.next;
            }
            else{
                sum2 = 0;
            }
            int rs = jw + sum1 + sum2;
            if(rs >= 10) {
                temp = rs - 10;
                jw = 1;
            }
            else{
                temp = rs;
                jw = 0;
            }
            System.out.println("sum1:" + sum1 + " sum2:" + sum2 + " rs:" + rs + " temp:" + temp + " jw:" + jw);
            tm.next = new ListNode(temp);
            tm = tm.next;
        }
        if(jw == 1){
            tm.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        ListNode rs = addTwoNumbers(l1,l2);
        while(rs != null){
            System.out.print(rs.val);
            rs = rs.next;
        }
    }
}
