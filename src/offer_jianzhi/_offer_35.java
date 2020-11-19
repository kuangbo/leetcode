package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/18
 * Time: 上午10:00
 */
public class _offer_35 {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        Node p = head;
        // 将每个节点复制到当前节点的后面一个位置
        while (p != null) {
            Node tempNode = new Node(p.val);
            tempNode.next = p.next;
            p.next = tempNode;
            p = tempNode.next;
        }
        p = head;
        // 复制random指针
        while (p!=null) {
            if (p.random != null)
                p.next.random = p.random.next;
            else
                p.next.random = null;
            p = p.next.next;
        }
        p = head;
        Node q = newHead;
        // 拆分链表
        while (p != null) {
            q.next = p.next;
            q = q.next;
            p.next = q.next;
            p = p.next;
        }
        return newHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
