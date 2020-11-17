package test;

public class _114 {
    TreeNode p = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        root.right = p;
        root.left = null;
        p = root.right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
