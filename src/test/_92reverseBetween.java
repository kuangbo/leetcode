package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/30
 * Time: 上午9:45
 */
public class _92reverseBetween {
    // 主要思路：在链表[m,n]位置上直接作反转链表操作
    // 而后用指针将三段链表首尾相连
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode p = head;  // 当前节点
        ListNode pre = null;    // 反转链表部分的前一个节点
        ListNode last = null;   // 反转链表反转之后的最后一个节点，也是需要反转的第一个节点
        ListNode newhead = new ListNode(-1);    // 反转链表的头节点
        ListNode post = null;   // 反转链表部分的后一个节点

        int start = 1;
        while (start <= n) {
            if (start == m - 1) // 当前节点为第一段链表的最后一个节点
                pre = p;
            if (start == n) // 当前节点为第三段链表的第一个节点
                post = p.next;
            if (start < m)
                p = p.next;
            else if (start <= n) {
                if (newhead.next == null) { // last指针记录第二段链表反转之后的最后一个节点
                    newhead.next = p;
                    last = p;
                }
                // 完成头插法反转链表
                ListNode next = p.next;
                p.next = newhead.next;
                newhead.next = p;
                p = next;
            }
            start++;
        }
        if (pre != null)    // 判断pre是否为null，若不为null，按照三段链表操作
            pre.next = newhead.next;
        else    // 若为null，表示第一个节点也在反转链表之内，也就是按照两段链表操作
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
