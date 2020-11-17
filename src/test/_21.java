package test;

public class _21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode point = res;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                point.next = l1;
                point = point.next;
                l1 = l1.next;
            } else {
                point.next = l2;
                point = point.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            point.next = l2;
        }else {
            point.next = l1;
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
