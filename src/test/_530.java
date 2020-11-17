package test;

public class _530 {
    // 主要思路：中序遍历root
    TreeNode pre = null;    // 作为当前节点的前驱节点
    int minSub = Integer.MAX_VALUE; // 最小差值

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minSub;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        if (pre != null && root.val - pre.val < minSub)
            minSub = root.val - pre.val;
        pre = root; // 存储当前节点为下面递归的前驱节点
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
