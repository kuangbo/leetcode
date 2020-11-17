package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 上午11:19
 */
public class _23mergeKLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 分治法
        if (lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if (lists.length == 2)
            return mergeTwoLists(lists[0], lists[1]);
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode point = res;
        while (l1 != null && l2 != null) {
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
        } else {
            point.next = l1;
        }
        return res.next;
    }

    public static class ListNode {
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
