package test;

public class _61 {
    // 主要思路：题目可以转化为，将链表的后k个元素移到链表的最前端
    // 中间过程使用循环链表的思想
    public ListNode rotateRight(ListNode head, int k) {
        // 当head为null，直接返回null
        // 当head.next为null，返回head
        // 当k==0，直接返回head
        if (head == null || k == 0)
            return head;
        ListNode p = head;
        ListNode q = head;

        int length = 1; // 链表长度，因为下面while循环判断的是q.next!=null
        while (q.next != null) {
            q = q.next;
            length++;
        }
        if (length == 1 || k % length == 0) // length=1表示只有一个元素，k%length=0表示正好循环长度整数倍
            return head;

        int step = length - k % length - 1;  // 指针需要移动的步数，因为最后会多出一个q=q.next，所以需要减1
        q.next = head;  // 将链表做成循环链表
        for (int i = 0; i < step; i++) {
            p = p.next;
        }
        // p和q之间断开
        q = p.next;
        p.next = null;
        return q;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
