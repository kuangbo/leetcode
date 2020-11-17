package test;

public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        // 在head之前添加pre指针，指向head，可以避免head前几个元素全是val的情况和head为null
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 此时pre和q都是指向head的前面
        ListNode q = pre;
        // 只是用q指针完成节点的删除
        while (q.next != null) {
            if (q.next.val == val) {
                q.next = q.next.next;
            } else {
                q = q.next;
            }
        }
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
