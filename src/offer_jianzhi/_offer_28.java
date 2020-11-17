package offer_jianzhi;

public class _offer_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        boolean lFlag = isSame(left.left, right.right);
        boolean rFlag = isSame(left.right, right.left);
        return lFlag && rFlag && left.val == right.val;
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
