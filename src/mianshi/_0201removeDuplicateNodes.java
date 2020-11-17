package mianshi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午12:36
 */
public class _0201removeDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode p = head;
        ListNode pre = head;
        boolean[] flag = new boolean[20001];    // 加入链表的节点值对应数组，直接置为true
        if(head == null)
            return null;
        else
            flag[head.val] = true;

        while(p.next != null) {
            if(flag[p.next.val]) {  // 链表中已有重复的值
                p = p.next;
                pre.next = p.next;
            } else {
                flag[p.next.val] = true;
                p = p.next;
                pre = pre.next;
            }
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
