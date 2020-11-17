package test;

public class _141 {
    // 使用快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode p = head.next;
        ListNode q = p;
        if(q.next == null)
            return false;
        boolean flag = false;
        // p指针走一步，q指针走两步
        // 当p与q相遇的时候，代表链表有环
        while(q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
            if(p == q) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
