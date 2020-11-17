package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午3:17
 */
public class _83deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = p;
        int pre = q.val;
        while(q.next != null) {
            if(pre == q.next.val) { // 当当前节点等于pre时，q指针后移
                q = q.next;
                p.next = q.next;
            } else {
                pre = q.next.val;
                q = q.next;
                p = q;
            }
        }
        if(pre == q.val)
            p.next = null;
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
