package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                sum += now.val;
                if (now.left != null)
                    queue.offer(now.left);
                if (now.right != null)
                    queue.offer(now.right);
            }
            res.add(sum / (double) size);
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
