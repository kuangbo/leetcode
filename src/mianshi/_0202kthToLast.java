package mianshi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午6:16
 */
public class _0202kthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
