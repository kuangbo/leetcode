package test;

public class _1022 {
    // 使用先序遍历完成
    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 0) % (int) (Math.pow(10, 9) + 7);
    }

    public int dfs(TreeNode root, int res) {
        if (root == null) {
            return 0;
        }
        res = res * 2 + root.val;   // 当前值*2+当前节点值
        if (root.left == null && root.right == null)    // 当前节点无左右节点时，返回
            return res;
        return dfs(root.left, res) + dfs(root.right, res);
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
