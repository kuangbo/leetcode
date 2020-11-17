package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Node now = stack.pop();
                res.add(now.val);
                for (int j = now.children.size() - 1; j >= 0; j--) {
                    Node children = now.children.get(j);
                    if (children != null) {
                        stack.push(children);
                    }
                }
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
