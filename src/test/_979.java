package test;

public class _979 {
    int res = 0;

    public static void main(String[] args) {

    }

    public int distributeCoins(TreeNode root) {
        return 0;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.left != null) {
            root.val += dfs(root.left);
        }
        if (root.right != null) {
            root.val += dfs(root.right);
        }
        res += Math.abs(root.val - 1);
        return root.val - 1;
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
