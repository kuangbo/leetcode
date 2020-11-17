package test;

public class _100 {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        boolean leftFlag = isSameTree(p.left, q.left);
        boolean rightFlag = isSameTree(p.right, q.right);
        return leftFlag && rightFlag;
    }

    public static class TreeNode {
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
