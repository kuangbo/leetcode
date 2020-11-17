package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 上午10:14
 */
public class _109sortedListToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return new TreeNode(head.val);
        // 利用快慢指针寻找中间位置，快指针走2步，慢指针走1步
        // 当快指针走到头时，慢指针为中间位置
        ListNode pre = head;    // pre为slow的前驱节点
        ListNode slow = pre.next;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {  // 寻找中间位置slow
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 在中间位置断开
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        // 此时，中间位置左边和右边分别进入递归
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
