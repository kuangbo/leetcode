package mianshi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/22
 * Time: 下午4:46
 */
public class _0203deleteNode {
    public void deleteNode(ListNode node) {
        // 将自身的值变为下一个节点的值，而后删除下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
