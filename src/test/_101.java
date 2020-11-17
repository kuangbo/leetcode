package test;

public class _101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return compare(root.left, root.right);
    }
    public static boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
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
