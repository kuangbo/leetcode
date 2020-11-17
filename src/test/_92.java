package test;

public class _92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode p = head;
        ListNode pre = null;    // 反转链表部分的前一个节点
        ListNode last = null;   // 反转链表反转之后的最后一个节点，也是需要反转的第一个节点
        ListNode newhead = new ListNode(-1);    // 反转链表反转之后的第一个节点，也是需要反转的最后一个节点
        ListNode post = null;   // 反转链表部分的后一个节点

        int start = 1;
        while (start <= n) {
            if (start == m - 1)
                pre = p;
            if (start == n)
                post = p.next;
            if (start < m)
                p = p.next;
            else if (start <= n) {
                if (newhead.next == null) {
                    newhead.next = p;
                    last = p;
                }
                ListNode next = p.next;
                p.next = newhead.next;
                newhead.next = p;
                p = next;
            }
            start++;
        }
        if (start - 1 < n) {
            System.out.println("-----------");
            pre.next = newhead.next;
        }
        else
            head = newhead.next;
        last.next = post;
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
