package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/24
 * Time: 下午7:26
 */
public class _offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p = headA;
        ListNode q = headB;
        while (p != null || q != null) {
            if (p == null)
                p = headB;
            else if (q == null)
                q = headA;
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
