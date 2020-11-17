package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199 {
    // 使用广度优先层次遍历
    // 每次进队列，先进右子树，再进左子树
    // 每次取第一个元素放入res集合
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.element().val);   // 取队头元素加入res集合
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                if (now.right != null)
                    queue.offer(now.right);
                if (now.left != null)
                    queue.offer(now.left);
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
