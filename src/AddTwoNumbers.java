import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class AddTwoNumbers {
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
