package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/17
 * Time: 上午11:24
 */
public class _25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1.next != null && l2.next != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1.next != null) {
            p.next = l1;
        }
        if (l2.next != null) {
            p.next = l2;
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
