package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/17
 * Time: 上午9:33
 */
public class _110isBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        return fun(root) >= 0;
    }

    public static int fun(TreeNode root) {
        if(root == null)    // 如果当前根节点为null，直接返回0
            return 0;
        // 左右递归遍历
        int left = fun(root.left);
        int right = fun(root.right);
        // 当左右子树平衡，并且左右子树高度差不超过1，返回最深子树+1
        if(left >= 0 && right >= 0 && Math.abs(left - right) <= 1)
            return Math.max(left, right) + 1;
        return -1; // 不平衡，返回-1
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
