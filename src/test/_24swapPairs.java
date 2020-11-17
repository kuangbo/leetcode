package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 下午12:17
 */
public class _24swapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 6; i ++) {
            ListNode newNode = new ListNode(i);
            p.next = newNode;
            p = p.next;
        }
        p = head;
        while(p != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
        swapPairs(head);
        p = head;
        while(p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = p;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(p.next != null) {
            p = p.next;
            temp.next = p;
            q.next = p.next;
            p.next = q;
            temp = temp.next.next;
            if(q.next == null)
                break;
            q = q.next;
            p = q;
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
