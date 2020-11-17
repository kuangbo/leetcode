package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午3:37
 */
public class _234isPalindrome {
    // 主要思路：先使用快慢指针，找到中间节点
    // 将后半个链表reverse为新链表headb
    // 最后将head和headb进行比较
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode headb = new ListNode(-1);
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        while(slow != null){
            // 头插法创建链表
            ListNode temp = new ListNode(slow.val);
            temp.next = headb.next;
            headb.next = temp;
            slow = slow.next;
        }
        headb = headb.next;
        while(headb != null) {
            if(head.val != headb.val)
                return false;
            head = head.next;
            headb = headb.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
