package offer_jianzhi;

public class _offer_55 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
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
