package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/22
 * Time: 下午2:56
 */
public class _offer_36 {
    // 题目使用中序+递归
    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        helper(root);
        // 首尾相连
        head.left = pre;
        pre.right = head;
        // 返回头节点
        return head;
    }

    public void helper(Node root) {
        if (root == null)
            return;
        helper(root.left);
        if (pre == null)    // 判断pre，为空表示是第一个节点，head指向该节点
            head = root;
        else    // 中间节点，pre右指针指向该节点
            pre.right = root;
        root.left = pre;    // 该节点左指针指向上一个节点pre
        pre = root; // 保存当前节点为pre，作为下一次递归的上一个节点
        helper(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
