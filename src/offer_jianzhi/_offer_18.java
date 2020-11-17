package offer_jianzhi;

public class _offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null)    // 当head为null时，返回null
            return null;
        if(head.val == val) {   // 当head的值==val时，返回head.next
            return head.next;
        }
        ListNode p = head;
        ListNode q = p;
        while(q.next != null) {
            q = q.next;
            if(q.val == val) {  // 当q的值==val，直接删除当前节点，break
                p.next = q.next;
                break;
            }
            p = p.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
