public class PartionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        //用两个链表来存储小于和大于等x的节点
        ListNode list1 = new ListNode(0);
        ListNode res1= list1;
        ListNode list2 = new ListNode(0);
        ListNode res2 = list2;
        //遍历链表
        while(head != null){
            //小于x的节点放到list1中
            if(head.val < x){
                ListNode tmp = new ListNode(head.val);
                list1.next = tmp;
                list1 = list1.next;
            }
            //大于等于x的节点放到list2中
            else{
                ListNode tmp = new ListNode(head.val);
                list2.next = tmp;
                list2 = list2.next;
            }
            head = head.next;
        }
        //合并两个链表
        if(res2.next != null){
            list1.next = res2.next;
        }
        return res1.next;
    }
}
