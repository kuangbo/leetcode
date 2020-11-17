package test;

public class _876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = p;
        while(q != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
