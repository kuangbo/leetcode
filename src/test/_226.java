package test;

public class _226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode rightTree = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
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
