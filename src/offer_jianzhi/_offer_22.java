package offer_jianzhi;

public class _offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = p;
        for(int i = 0; i < k; i ++)
            q = q.next;
        while(q!=null){
            p = p.next;
            q = q.next;
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
