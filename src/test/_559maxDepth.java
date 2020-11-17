package test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/20
 * Time: 上午10:54
 */
public class _559maxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int childrenLength = root.children.size();
        int depth = 0;
        for(int i = 0; i < childrenLength; i ++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
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
