package test;

public class _206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);    // 新建节点作为反转链表的头节点
        ListNode q = head;
        while (q != null) {
            // 利用新节点来完成节点的插入，头插法
            ListNode temp = new ListNode(q.val);
            temp.next = newHead.next;
            newHead.next = temp;
            q = q.next;
        }
        return newHead.next; // 返回newHead.next
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
