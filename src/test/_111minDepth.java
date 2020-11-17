package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/18
 * Time: 下午3:48
 */
public class _111minDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        for (int i = 0; i < 4; i++) {
            p.left = new TreeNode(i + 2);
            p = p.left;
        }
        int res = minDepth_bfs(root);
        System.out.println(res);
    }

    public static int minDepth_bfs(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode now = queue.poll();
                if (now.left == null && now.right == null) {
                    return depth;
                }
                if (now.left != null) {
                    queue.add(now.left);
                }
                if (now.right != null) {
                    queue.add(now.right);
                }
                count--;
            }
            depth++;
        }
        return depth;
    }

    public static int minDepth(TreeNode root) {
        if (root == null)    // 当前节点为null，返回0
            return 0;
        // 如果左右节点有一个为null，直接返回子树最小深度+1
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        // 递归遍历左右子树
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;   // 返回左右子树最小深度+1
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
