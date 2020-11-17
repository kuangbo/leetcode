package test;

public class _19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode post = head;
        ListNode pre = null;
        int index = 0;
        while(post != null) {
            post = post.next;
            index ++;
        }
        if (index <= 1)
            return null;
        if (index == n)
            return head.next;
        post = head;
        pre = post;
        for (int i = 0; i < index-n; i++) {
            pre = post;
            post = post.next;
        }
        if(post != null)
            pre.next = post.next;
        else
            pre.next = null;
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
