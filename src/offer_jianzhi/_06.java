package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午4:35
 */
public class _06 {
    // 主要思路：对head链表遍历，过程中记录元素个数
    // 再次遍历，从数组最后一次位置放入元素
    public int[] reversePrint(ListNode head) {
        if (head == null)   // 当head为null，直接返回空数组
            return new int[]{};
        if (head.next == null)  // 当head.next为null，直接返回head.val
            return new int[]{head.val};

        ListNode p = head;
        int foot = 0;
        while (p != null) {
            p = p.next;
            foot++;
        }
        int[] res = new int[foot];
        p = head;
        System.out.println(foot);
        while (p != null) {
            res[foot--] = p.val;
            p = p.next;
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
