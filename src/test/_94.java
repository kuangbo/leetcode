package test;

import java.util.ArrayList;
import java.util.List;

public class _94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
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
